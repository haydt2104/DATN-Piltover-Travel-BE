package com.piltover.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.piltover.entity.Account;
import com.piltover.entity.Comment;
import com.piltover.entity.Like;
import com.piltover.entity.PostImage;

import lombok.Data;

@Data
public class PostDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private Account createUser;
    private String title;
    private String description;
    private String content;
    private Date createTime = new Date();
    private Account updateUser;
    private Date updateTime;
    private Boolean isDelete = false;
    List<PostImage> postImages;
    List<Like> likes;
    List<Comment> comments;
}
