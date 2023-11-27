package com.piltover.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

	Long id;
	Long userId;
	Long postId;
	String content;
	Date createAt;
	Date updateAt;
}
