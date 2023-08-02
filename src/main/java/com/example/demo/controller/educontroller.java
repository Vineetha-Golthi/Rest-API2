package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptionhandling.APIresponse;
import com.example.demo.payload.edu_depo;
import com.example.demo.service.eduservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class educontroller {
	@Autowired
	eduservice service;
	@PostMapping("/insert")
	public ResponseEntity<edu_depo>adduser(@Valid @RequestBody edu_depo edu) {
		edu_depo education=this.service.addusers(edu);
		return new ResponseEntity<>(education,HttpStatus.CREATED);
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<edu_depo>Update(@Valid @PathVariable int id, edu_depo edu){
		edu_depo education=this.service.update(edu, id);
		return ResponseEntity.ok(education);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIresponse>delete(@Valid @PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<APIresponse>(new APIresponse("id deleted successfully",true),HttpStatus.OK);
		
		
	}
	@GetMapping("/getallusers/{id}")
	public ResponseEntity<List<edu_depo>>getallusers(){
		return ResponseEntity.ok(this.service.getallusers());
	}
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<edu_depo>getbyid(@Valid @PathVariable int id){
		return ResponseEntity.ok(this.service.getbyid(id));
	}

}
