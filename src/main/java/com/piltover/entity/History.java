package com.piltover.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class History {
	@Id
	private Long userID;
    private String fullname;
    private Long bookingID;
    private Integer adult;
    private Integer children;
    private LocalDateTime book_date;
    private Integer total_price;
    private Integer booking_status;
    private String discount_name;
    private Double discount_percentage;
    private String discount_code;
    private Long tour_id;
    private String tour_name;
    private String tour_description;
	private String transport_name;
	private LocalDateTime start_date;
    private String start_address;
    private LocalTime start_time;
    private LocalTime end_time;
}
