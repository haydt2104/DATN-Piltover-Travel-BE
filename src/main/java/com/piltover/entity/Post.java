package com.piltover.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "Posts", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "Create_User","Update_User" })
})
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Proxy(lazy = false)
public class Post implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Create_User")
    private Account createUser;

    @Column(name = "Title")
    private String title;

    @Lob
    @Column(name = "Description")
    private String description;

    @Lob
    @Column(name = "Content")
    private String content;

    @DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
    @Column(name = "Create_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime = new Date();
    
    @ManyToOne
    @JoinColumn(name = "Update_User")
    private Account updateUser;
    
    @DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
    @Column(name = "Update_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updateTime;

    @Column(name = "is_Delete")
    private Boolean isDelete = false;
    
    @JsonIgnore
    @OneToMany(mappedBy = "post")
    List<PostImage> postImages;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post", cascade = CascadeType.ALL)
    List<Like> likes;
    
    @JsonIgnore
    @OneToMany(mappedBy = "post")
    List<Comment> comments;
}
