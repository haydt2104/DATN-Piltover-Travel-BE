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
import javax.persistence.OneToOne;
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
@Table(name = "Bookings", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "Create_User", "Update_User", "Tour_DateID", "DiscountID" })
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
    @JoinColumn(name = "Create_User")
    private Account createUser;

    @ManyToOne
    @JoinColumn(name = "Tour_DateID")
    private TourDate tourDate;

    @ManyToOne
    @JoinColumn(name = "DiscountID")
    private Discount discount;

    @Column(name = "Total_price")
    private Integer totalPrice;

    @Column(name = "Total_passengers")
    private Integer totalPassengers;
    
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
    
    @Column(name = "Status")
    private Integer status;

    @JsonIgnore
    @OneToOne(mappedBy = "booking")
    private BookingDetail bookingDetail;
}
