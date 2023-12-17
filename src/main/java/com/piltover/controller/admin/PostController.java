package com.piltover.controller.admin;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.dto.CommentDTO;
import com.piltover.dto.PostDTO;
import com.piltover.entity.Account;
import com.piltover.entity.Comment;
import com.piltover.entity.Like;
import com.piltover.entity.Post;
import com.piltover.entity.PostImage;
import com.piltover.service.AccountService;
import com.piltover.service.CommentService;
import com.piltover.service.LikeService;
import com.piltover.service.PostImageService;
import com.piltover.service.PostService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Transactional
public class PostController {

	@Autowired
	PostService ps;

	@Autowired
	PostImageService is;

	@Autowired
	LikeService ls;

	@Autowired
	AccountService as;

	@Autowired
	CommentService cs;

	private String getEmail() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return username;
	}

	private Long getIdUser() {
		Long id = as.getId(getEmail());
		return id;
	}

	@GetMapping("/post/getAllPosts")
	public ResponseEntity<?> getAllPosts() {
		return ResponseEntity.ok(ps.getAllPost());
	}

	@GetMapping("/post/getRandomPosts")
	public ResponseEntity<?> getRandomPosts() {
		return ResponseEntity.ok(ps.getRandomPost());
	}

	@GetMapping("/post/getPostById/{id}")
	public ResponseEntity<Post> getPost(@PathVariable Long id) {
		Post post = ps.getPost(id);
		List<PostImage> img = is.postImg(id);
		post.setPostImages(img);
		return ResponseEntity.ok(post);
	}

	@GetMapping("/post/getLikePosts/{id}")
	public ResponseEntity<Integer> getLikePosts(@PathVariable Long id) {
		return ResponseEntity.ok(ls.getCountLikePostId(id));
	}

	@GetMapping("/post/checkUserLike")
	public ResponseEntity<Boolean> checkUserLike(@RequestParam Long postId) {
		boolean check = ls.checkUserLike(getIdUser(), postId);
		System.out.println("Check User Like: " + check);
		if (check == true) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.ok(false);
		}
	}

	@GetMapping("/post/getIdUserCmt")
	public ResponseEntity<?> getId() {
		Long id = getIdUser();
		return ResponseEntity.ok(id);
	}

	@PostMapping("/post/likePost")
	public ResponseEntity<?> likePost(@RequestParam Long postId, @RequestBody Boolean isLike) {
		Like newLike = new Like();
		Account acc = as.findUserByID(getIdUser());
		Post post = ps.getPost(postId);
		newLike.setIsLike(true);
		newLike.setLikeUser(acc);
		newLike.setPost(post);

		ls.newLike(newLike);
		return ResponseEntity.ok(newLike);
	}

	@PutMapping("/post/doLike")
	public ResponseEntity<?> doLike(@RequestParam Long postId, @RequestBody Boolean isLike) {
		Like entity = ls.getLike(getIdUser(), postId);
		if (entity == null) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			if (isLike == true) {
				entity.setLikeTime(new Date());
			} else {
				entity.setUnlikeTime(new Date());
			}
			entity.setIsLike(isLike);
			ls.doLike(entity);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@GetMapping("/post/getPostImgById/{id}")
	public ResponseEntity<?> getPostImageById(@PathVariable Long id) {
		return ResponseEntity.ok(is.postImg(id));
	}

	@GetMapping("/post/setThumbnailPost/{id}")
	public ResponseEntity<?> setThumbnailPost(@PathVariable Long id) {
		return ResponseEntity.ok(is.postImg(id).get(0));
	}

	@GetMapping("/post/getCommentPost/{id}")
	public ResponseEntity<?> getCommentPost(@PathVariable Long id) {
		return ResponseEntity.ok(cs.getCommentPost(id));
	}

	@PostMapping("/post/addComment")
	public ResponseEntity<?> addComment(@RequestBody CommentDTO cmtDTO) {
		Comment cmt = new Comment();
		Account user = as.findUserByID(getIdUser());
		Post post = ps.getPost(cmtDTO.getPostId());
		cmtDTO.setCreateAt(new Date());

		cmt.setCommentTime(cmtDTO.getCreateAt());
		cmt.setCommentUser(user);
		cmt.setContent(cmtDTO.getContent());
		cmt.setPost(post);
		cs.addComment(cmt);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/post/removeComment/{id}")
	public ResponseEntity<?> removeComment(@PathVariable Long id) {
		Comment cmt = cs.fimdCommentById(id);
		if (cmt == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			cs.removeComment(cmt);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/post/updateComment/{id}")
	public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody CommentDTO cmtDTO) {
		Comment entity = cs.fimdCommentById(id);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			entity.setContent(cmtDTO.getContent());
			cs.updateComment(entity);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/admin/post/updatePost/{id}")
	public ResponseEntity<?> updatePost(@Validated @RequestBody PostDTO post, @PathVariable Long id) {
		Post entity = ps.getPost(id);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			String title = post.getTitle();
			String description = post.getDescription();
			String content = post.getContent();
			Account user = as.findUserByID(getIdUser());

			entity.setId(id);
			entity.setTitle(title);
			entity.setDescription(description);
			entity.setContent(content);
			entity.setUpdateTime(LocalDateTime.now());
			entity.setUpdateUser(user);
			ps.updatePost(entity);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PostMapping("/admin/post/create")
	public ResponseEntity<?> createPost(@RequestBody PostDTO post) {
		String title = post.getTitle();
		String description = post.getDescription();
		String content = post.getContent();
		Account user = as.findUserByID(getIdUser());
		Post entity = new Post();
		entity.setTitle(title);
		entity.setDescription(description);
		entity.setContent(content);
		entity.setCreateTime(LocalDateTime.now());
		entity.setCreateUser(user);
		ps.createPost(entity);
		for (int i = 0; i < post.getImages().size(); i++) {
			String path = post.getImages().get(i);
			PostImage postImg = new PostImage();
			postImg.setPost(entity);
			postImg.setPath(path);
			is.createPostImg(postImg);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/admin/post/removePost/{id}")
	public ResponseEntity<?> removePost(@PathVariable Long id) {
		Post entity = ps.getPost(id);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			entity.setIsDelete(true);
			ps.deletePost(entity);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
