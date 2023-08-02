package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class education {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 @Column(name="Username",nullable=false,length=50)
 private String name;
 private String branch;
 @jakarta.validation.constraints.Email
 private String Email;
 private String Password;

	

}
