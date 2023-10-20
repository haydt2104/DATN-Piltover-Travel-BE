package com.piltover.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Post;
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
	
	@GetMapping("/getAllPosts")
    public ResponseEntity<?> getAllPosts() {
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
	public ResponseEntity<?> updatePost(@RequestBody Post post, @PathVariable Long id){
		Post entity = ps.getPost(id);
		if(entity == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			String title = post.getTitle();
			entity.setId(id);
			entity.setTitle(post.getTitle());
			entity.setDescription(post.getDescription());
			entity.setContent(post.getContent());
			ps.updatePost(entity);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping("/create")
	public ResponseEntity<?> createPost(@RequestBody Post post){
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
