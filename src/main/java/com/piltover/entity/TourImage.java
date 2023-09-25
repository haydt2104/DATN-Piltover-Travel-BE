package com.piltover.entity;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "TourImages", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "TourID" })
})
public class TourImage implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TourID")
    private Tour tour;

    @Column(name = "Path")
    private String path;
    
    @JsonIgnore
    @OneToMany(mappedBy = "tourDate")
    private List<Booking> bookings;
}
