package com.piltover.controller.admin;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.dto.PostDTO;
import com.piltover.entity.Account;
import com.piltover.entity.Post;
import com.piltover.service.AccountService;
import com.piltover.service.LikeService;
import com.piltover.service.PostService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/post")
@Transactional
public class PostController {

	@Autowired
	PostService ps;
	
	@Autowired
	LikeService ls;
	
	@Autowired
	AccountService as;
	
	@GetMapping("/getAllPosts")
    public ResponseEntity<?> getAllPosts( ) {
//		Pageable pageable;
//		try {
//			pageable = PageRequest.of(p.orElse(0), 5);
//		} catch (Exception e) {
//			pageable = PageRequest.of(0, 5);
//		}
//		Page<Post> listPage = ps.getAllPost(pageable);
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
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
