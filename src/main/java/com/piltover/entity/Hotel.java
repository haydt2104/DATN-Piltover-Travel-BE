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
@Table(name = "Hotels", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "Create_User","Update_User" })
})
public class Hotel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private Integer price;

    @Column(name = "Star")
    private Integer star;

    @Column(name = "Address", columnDefinition = "TEXT")
    private String address;
    
    @ManyToOne
    @JoinColumn(name = "Create_User")
    private Account createUser;
    
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
    @OneToMany(mappedBy = "hotel")
    List<Tour> tours;
}
