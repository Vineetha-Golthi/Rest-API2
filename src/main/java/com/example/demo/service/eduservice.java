package com.example.demo.service;

import java.util.List;

import com.example.demo.model.education;
import com.example.demo.payload.edu_depo;

public interface eduservice {
	edu_depo addusers(edu_depo e1);
	edu_depo update(edu_depo e2,int id);
	void delete(int id);
	List<edu_depo>getallusers();
	edu_depo getbyid(int id);
}
