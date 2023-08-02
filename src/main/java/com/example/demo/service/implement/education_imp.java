package com.example.demo.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.exceptionhandling.ResourceNotFoundException;
import com.example.demo.model.education;
import com.example.demo.payload.edu_depo;
import com.example.demo.repository.edurepository;
import com.example.demo.service.eduservice;
@Service

public class education_imp implements eduservice {
	
	@Autowired
	edurepository repo;
	
	@Autowired
	ModelMapper modelmapper;

	@Override
	public edu_depo addusers(edu_depo e1) {
		education es = this.dto_edu(e1);
		education edd = this.repo.save(es);
		return this.edu_dto(edd);
	}

	@Override
	public edu_depo update(edu_depo e2, int id) {
		education eg =this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException ("education","id",id));
		eg.setName(e2.getName());
		eg.setEmail(e2.getEmail());
		eg.setPassword(e2.getPassword());
		education e3=this.repo.save(eg);
		edu_depo edd=this.edu_dto(e3);
		return edd;
		
	}

	@Override
	public void delete(int id) {
		education es=this.repo.findById(id).orElseThrow( ()->new ResourceNotFoundException("education","id", id));
		// TODO Auto-generated method stub
		this.repo.delete(es);

	}

	@Override
	public List<edu_depo> getallusers() {
		List<education> es=this.repo.findAll();
		List<edu_depo> edu=es.stream().map(educate->this.edu_dto(educate)).collect(Collectors.toList());
		return edu;
	}

	@Override
	public edu_depo getbyid(int id) {
		// TODO Auto-generated method stub
		education es=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("education", "id", id));
		return this.edu_dto(es);
	}
	
	public education dto_edu(edu_depo ed) {
		education e = this.modelmapper.map(ed, education.class);
		return e;
	}
	
	public edu_depo edu_dto(education edu) {
		edu_depo ed = this.modelmapper.map(edu, edu_depo.class);
		return ed;
	}

}
