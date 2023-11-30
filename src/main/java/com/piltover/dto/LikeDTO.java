package com.piltover.dto;

import java.util.Date;

import com.piltover.entity.Account;
import com.piltover.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDTO {

	private Long id;
	private Account likeUser;
	private Post post;
	private Date likeTime;
	private Date unlikeTime;
	private Boolean isLike;
}
