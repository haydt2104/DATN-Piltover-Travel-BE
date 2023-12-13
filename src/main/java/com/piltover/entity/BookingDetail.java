package com.piltover.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name = "booking_detail", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "BookingID" })
})
public class BookingDetail implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "BookingID")
    private Booking booking;

    @Column(name = "Adult")
    private Integer adult;

    @Column(name = "Children")
    private Integer children;

    @Column(name = "Surcharge")
    private Integer surcharge;

    @Column(name = "Booking_time", updatable = false)
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingTime = new Date();
}
