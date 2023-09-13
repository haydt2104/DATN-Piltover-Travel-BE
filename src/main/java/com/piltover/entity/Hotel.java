package com.piltover.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Hotels")
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
    
    @JsonIgnore
    @OneToMany(mappedBy = "hotel")
    List<Booking> bookings;
}
