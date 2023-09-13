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
@Table(name = "Accounts")
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
    
    @Column(name = "Create_at")
    private Date createAt;
    
    @Column(name = "Update_at")
    private Date updateAt;
    
    @Column(name = "Error_count")
    private Integer errorCount;
    
    @Column(name = "Banned_time")
    private Date bannedTime;
    
    @Column(name = "Active")
    private Boolean active;
	
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Post> posts;
    
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Authority> authorities;
    
    @JsonIgnore
    @OneToMany(mappedBy = "creator")
    List<Tour> tours;
    
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Booking> bookings;
}
