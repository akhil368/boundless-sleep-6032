package com.masai.SB_101_Project.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	
	@Column( nullable = false)
	private int fixedChargeForConnection;
	
	
	private int unitRate;
	@Column( nullable = false)
	private int totalAmount;
	
	@Column( nullable = false)
	private double prevReading;
	
	@Column( nullable = false)
	private double currReading;
	
	
	private double tax;
	private double additionalAdjustmentFromCustomer;
	
	private double additionalAdjustmentFromCorporation;
	
	private LocalDate dueDate;
	private String Status;
	
	@Column( nullable = false)
	private int isPaid;
	
	@Column(nullable=false)
	private LocalDate startDate;
	
	@Column(nullable =false)
	private LocalDate endDate;
	
	private LocalDate billing_date;
	
	@ManyToOne
//  @JoinColumn(name = "consumer_id")
	private Customer consumer;
}
