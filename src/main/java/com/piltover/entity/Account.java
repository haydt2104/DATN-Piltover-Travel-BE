package com.piltover.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Account implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
    
    @Column(name = "Email", unique = true)
    private String email;
    
    @Column(name = "Password")
    private String password;
    
    @Column(name = "Phone", unique = true)
    private String phone;
    
    @Column(name = "Fullname")
    private String fullname;
    
    @DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
    @Column(name = "Birthday")
    private Date birthday;
    
    @Column(name = "Gender")
    private Boolean gender;
    
    @Column(name = "Address")
    private String address;
    
    @DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
    @Column(name = "Create_at")
    private Date createAt = new Date();
    
    @DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
    @Column(name = "Update_at")
    private Date updateAt;
    
    @Column(name = "Error_count")
    private Integer errorCount = 0;
    
    @Column(name = "Banned_time")
    private Date bannedTime;
    
    @Column(name = "is_Delete")
    private Boolean isDelete = false;
	
    @JsonIgnore
    @OneToMany(mappedBy = "createUser")
    List<Post> listPostCreated;
    
    @JsonIgnore
    @OneToMany(mappedBy = "updateUser")
    List<Post> listPostUpdated;
    
    @JsonIgnore
    @OneToMany(mappedBy = "commentUser")
    List<Comment> listComment;
    
    @JsonIgnore
    @OneToMany(mappedBy = "likeUser")
    List<Like> listLike;
    
    @JsonIgnore
    @OneToMany(mappedBy = "createUser")
    List<Discount> listDiscountCreate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "updateUser")
    List<Discount> listDiscountUpdate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Authority> authorities;
    
    @JsonIgnore
    @OneToMany(mappedBy = "creator")
    List<Tour> listTourCreate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "createUser")
    List<Booking> listBookingCreate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "updateUser")
    List<Booking> listBookingUpdate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "updateUser")
    List<Hotel> listHotelUpdate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "createUser")
    List<Hotel> listHotelCreate;
    
    
}
