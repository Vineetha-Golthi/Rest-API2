package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.education;

import jakarta.servlet.Registration;

	@Repository
	public interface edurepository extends JpaRepository<education, Integer>{

	}



