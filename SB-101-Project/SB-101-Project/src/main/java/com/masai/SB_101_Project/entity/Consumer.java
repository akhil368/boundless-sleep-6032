package com.masai.SB_101_Project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consumer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50,nullable=false)
	private String firstName;
	
	@Column(length=50,nullable=false)
	private String lastName;
	
	@Column(unique=true,length=50,nullable=false)
	private String userName;
	
	@Column(length=50,nullable=false)
	private String password;
	
	@Column(length=100,nullable=false)
	private String address;
	
	@Column(length=10,nullable=false)
	private int number;
	
	@Column(length=30,nullable=false)
	private String email;
	
	@Column(name = "is_deleted", nullable = false)
	private int isDeleted;
	
}
