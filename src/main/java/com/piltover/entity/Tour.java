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
@Table(name = "Tours", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "PriceID", "CreateID",  "TransportID"})
})
public class Tour implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PriceID")
    private Price price;

    @ManyToOne
    @JoinColumn(name = "CreateID")
    private Account creator;
    
    @ManyToOne
    @JoinColumn(name = "TransportID")
    private Transport transport;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "Image")
    private String image;

    @Column(name = "Destination_address", columnDefinition = "TEXT")
    private String destinationAddress;

    @Column(name = "Available_spaces")
    private Integer availableSpaces;

    @DateTimeFormat(iso = ISO.DATE_TIME)
	@Temporal(TemporalType.DATE)
    @Column(name = "Create_at")
    private Date createTime;

    @Column(name = "Active")
    private Boolean active;
    
    @JsonIgnore
    @OneToMany(mappedBy = "tour")
    List<TourDate> tourDates;
    
    @JsonIgnore
    @OneToMany(mappedBy = "tour")
    List<TourImage> tourImages;
    
}
