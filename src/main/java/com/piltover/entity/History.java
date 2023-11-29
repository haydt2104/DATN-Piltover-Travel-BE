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
    private LocalDateTime bookDate;
    private Integer totalPrice;
    private Integer bookingStatus;
    private String discountName;
    private Double discountPercentage;
    private String discountCode;
    private Long tourID;
    private String tourName;
    private String tourDescription;
	private String transportName;
	private LocalDateTime startDate;
    private String startAddress;
    private LocalTime startTime;
    private LocalTime endTime;
}
