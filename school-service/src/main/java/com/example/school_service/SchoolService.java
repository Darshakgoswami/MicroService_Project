package com.example.school_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService 
{
	@Autowired
	private SchoolRepository schoolRepository;
	public School addSchool(School school)
	{
		return schoolRepository.saveAndFlush(school);
	}
	
	public List<School> fetchSchool(){
		return schoolRepository.findAll();
	}
	public School fetchSchoolById(int id)
	{
		return schoolRepository.findById(id).orElse(null);
	}

	public School updateSchool(Integer id, School schoolDetails) 
	{
	    School school = schoolRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("School not found with id: " + id));
	    
	    school.setSchoolName(schoolDetails.getSchoolName());
	    school.setLocation(schoolDetails.getLocation());
	    school.setPrincipalName(schoolDetails.getPrincipalName());
	    return schoolRepository.save(school);
	}

	public String deleteSchool(Integer id)
	{
	    School school = schoolRepository.findById(id).orElseThrow(() -> new RuntimeException("School not found with id: " + id));
	    schoolRepository.delete(school);
	    return "School with ID " + id + " deleted successfully!";
	}
}