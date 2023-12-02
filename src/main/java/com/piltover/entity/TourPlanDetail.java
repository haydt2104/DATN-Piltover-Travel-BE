package com.piltover.entity;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "tour_plan_detail", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "Tour_Plan_ID" })
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
    @NotNull
    private LocalTime startTime;

    @Column(name = "End_time")
    @NotNull
    private LocalTime endTime;

    @Column(name = "Description")
    @NotNull
    private String description;
}
