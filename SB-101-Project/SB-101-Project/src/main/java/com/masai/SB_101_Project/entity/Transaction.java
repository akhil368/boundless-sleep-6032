package com.masai.SB_101_Project.entity;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TransactionId;

	private double amountPaid;
	private LocalDate paymentDate;
	private String paymentMethod;
	
	@ManyToOne
    @JoinColumn(name = "consumer_id")
	private Customer consumer;
}