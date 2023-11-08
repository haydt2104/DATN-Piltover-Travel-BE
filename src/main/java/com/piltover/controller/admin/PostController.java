package com.piltover.controller.admin;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.dto.PostDTO;
import com.piltover.entity.Account;
import com.piltover.entity.Post;
import com.piltover.entity.PostImage;
import com.piltover.service.AccountService;
import com.piltover.service.LikeService;
import com.piltover.service.PostImageService;
import com.piltover.service.PostService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/post")
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
	
	@GetMapping("/getAllPosts")
    public ResponseEntity<?> getAllPosts( ) {
		List<Post> list = ps.getAllPost();
//		list.get(0).getLikes().
        return ResponseEntity.ok(ps.getAllPost());
    }
	
	@GetMapping("/getPostById/{id}")
	public ResponseEntity<Post> getPost(@PathVariable Long id){
		return ResponseEntity.ok(ps.getPost(id));
	}
	
	@GetMapping("/getLikePosts/{id}")
	public ResponseEntity<Integer> getLikePosts(@PathVariable Long id) {
        return ResponseEntity.ok(ls.getCountLikePostId(id));
    }
	
	@PutMapping("/updatePost/{id}")
	public ResponseEntity<?> updatePost(@Validated @RequestBody PostDTO post, @PathVariable Long id){
		Post entity = ps.getPost(id);
		if(entity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			String title = post.getTitle().replaceAll("<p>", "");
			String description = post.getDescription().replaceAll("<p>", "");
			String content = post.getContent().replaceAll("<p>", "");
			Account user = as.findUserByID((long) 1234567890);
			
			entity.setId(id);
			entity.setTitle(title.replaceAll("</p>", ""));
			entity.setDescription(description.replaceAll("</p>", ""));
			entity.setContent(content.replaceAll("</p>", ""));
			entity.setUpdateTime(LocalDateTime.now());
			entity.setUpdateUser(user);
			ps.updatePost(entity);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createPost(@RequestBody PostDTO post){
		String title = post.getTitle().replaceAll("<p>", "");
		String description = post.getDescription().replaceAll("<p>", "");
		String content = post.getContent().replaceAll("<p>", "");
		Account user = as.findUserByID((long) 1234567890);
		Post entity = new Post();
		entity.setTitle(title.replaceAll("</p>", ""));
		entity.setDescription(description.replaceAll("</p>", ""));
		entity.setContent(content.replaceAll("</p>", ""));
		entity.setCreateTime(LocalDateTime.now());
		entity.setCreateUser(user);
		ps.createPost(entity);
//		String newPostId = ps.idMostNewPost();
		System.out.println(post.getImages());
		for(int i = 0; i < post.getImages().size(); i++) {
			String path = post.getImages().get(i);
			PostImage postImg = new PostImage();
			postImg.setPost(entity);
			postImg.setPath(path);
			is.createPostImg(postImg);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/removePost/{id}")
	public ResponseEntity<?> removePost(@PathVariable Long id){
		Post entity = ps.getPost(id);
		if(entity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			entity.setIsDelete(true);
			ps.deletePost(entity);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
