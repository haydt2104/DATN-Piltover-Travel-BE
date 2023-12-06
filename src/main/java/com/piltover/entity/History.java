package com.piltover.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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
	private Long Id;
    private Long bookingID;
    private Integer adult;
    private Integer children;
    private Integer Surcharge;
    private LocalDateTime Booking_time;
    private Long create_user;
}
