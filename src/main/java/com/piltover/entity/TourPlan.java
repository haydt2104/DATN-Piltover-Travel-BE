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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tour_plan", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "Tour_Date_ID", "TransportID" })
})
public class TourPlan implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Tour_Date_ID")
    @NotNull
    private TourDate tourDate;
    @ManyToOne
    @JoinColumn(name = "TransportID")
    @NotNull
    private Transport transport;

    @Column(name = "Start_name")
    @NotBlank
    private String startName;

    @Column(name = "Start_address", columnDefinition = "TEXT")
    @NotBlank
    private String startAddress;

    @Column(name = "Start_time")
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date startTime;

    @JsonIgnore
    @OneToMany(mappedBy = "tourPlan")
    private List<TourPlanDetail> tourPlans;
}
