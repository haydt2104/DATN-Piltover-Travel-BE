
package com.piltover.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name = "comments", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "PostID" , "Comment_User" })
})
public class Comment implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "Comment_User")
    private Account commentUser;

    @ManyToOne
    @JoinColumn(name = "PostID")
    private Post post;
    
    @DateTimeFormat(iso = ISO.DATE_TIME)
//	@Temporal(TemporalType.DATE)
    @Column(name = "Comment_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date commentTime;
    
    @DateTimeFormat(iso = ISO.DATE_TIME)
//	@Temporal(TemporalType.DATE)
    @Column(name = "Update_at", nullable = true, updatable = true, insertable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updateTime;
    
    @Column(name = "Content")
    private String content;
    
    @Column(name = "is_Delete")
    private Boolean isDelete = false;
}