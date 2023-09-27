package com.piltover.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Bookings", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "AccountID", "TourDateID", "HotelID", "DiscountID" })
})
public class Booking implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "AccountID")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "TourDateID")
    private TourDate tourDate;

    @ManyToOne
    @JoinColumn(name = "HotelID")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "DiscountID")
    private Discount discount;

    @Column(name = "Total_price")
    private Integer totalPrice;

    @Column(name = "Total_passengers")
    private Integer totalPassengers;
    
    @Column(name = "Status")
    private Integer status;

    @JsonIgnore
    @OneToOne(mappedBy = "booking")
    private BookingDetail bookingDetail;
}
