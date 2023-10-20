package com.piltover.dto;

import java.util.Date;
import java.util.List;

import com.piltover.entity.Account;
import com.piltover.entity.Comment;
import com.piltover.entity.Like;
import com.piltover.entity.PostImage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

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
