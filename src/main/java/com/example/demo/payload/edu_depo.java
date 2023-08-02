package com.example.demo.payload;

//import org.hibernate.validator.constraintvalidators.RegexpURLValidator;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class edu_depo {
	 private int id;
	 @Column(name="Username",nullable=false,length=50)
	 private String name;
	 private String branch;
	 @jakarta.validation.constraints.Email
	 private String Email;

	 
	 private String Password;


		

	}