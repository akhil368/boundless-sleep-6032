package com.masai.SB_101_Project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int billId;
	private int fixedChargeForConnection;
	private int Totalunit;
	private int additionalAdjustment;
	private String Status;
	
	@Column( nullable = false)
	private int isDeleted;

}