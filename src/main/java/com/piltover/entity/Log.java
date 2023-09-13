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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name = "Logs", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "AccountId" })
})
public class Log implements Serializable{/**
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

    @Column(name = "Login_time")
    @DateTimeFormat(iso = ISO.DATE_TIME)
	@Temporal(TemporalType.DATE)
    private Date loginTime;

    @Column(name = "Logout_time")
    @DateTimeFormat(iso = ISO.DATE_TIME)
	@Temporal(TemporalType.DATE)
    private Date logoutTime;

    @Column(name = "Ip_address")
    private String ipAddress;
}
