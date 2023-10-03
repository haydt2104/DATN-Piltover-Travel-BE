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
@Table(name = "Tour_Dates", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "TourID" })
})
public class TourDate implements Serializable {
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

    @Column(name = "Initiate_date")
    @DateTimeFormat(iso = ISO.DATE)
    @Temporal(TemporalType.DATE)
    private Date initiateDate;

    @JsonIgnore
    @OneToMany(mappedBy = "tourDate")
    private List<Booking> bookings;

    @JsonIgnore
    @OneToMany(mappedBy = "tourDate")
    List<TourPlan> tourPlans;
}
