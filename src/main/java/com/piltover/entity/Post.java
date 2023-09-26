package com.piltover.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Posts", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "AccountId" })
})
public class Post implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "AccountID")
    private Account account;

    @Column(name = "Title")
    private String title;

    @Lob
    @Column(name = "Description")
    private String description;

    @Lob
    @Column(name = "Content")
    private String content;
    
    @Column(name = "Image")
    private String image;

    @DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
    @Column(name = "Create_time", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @Column(name = "Status")
    private Boolean status;
    
    @JsonIgnore
    @OneToMany(mappedBy = "post")
    List<PostImage> postImages;
    
    @JsonIgnore
    @OneToMany(mappedBy = "post")
    List<Like> likes;
    
    @JsonIgnore
    @OneToMany(mappedBy = "post")
    List<Comment> comments;
}
