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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name = "TourPlanDetail", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "Tour_Plan_ID"})
})
public class TourPlanDetail implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Tour_Plan_ID")
    private TourPlan tourPlan;

    @Column(name = "Start_time")
    @DateTimeFormat(iso = ISO.DATE_TIME)
	@Temporal(TemporalType.DATE)
    private Date startTime;

    @Column(name = "End_time")
    @DateTimeFormat(iso = ISO.DATE_TIME)
	@Temporal(TemporalType.DATE)
    private Date endTime;

    @Column(name = "Description")
    private String description;
}
