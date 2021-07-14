package com.lattice.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lattice.entity.Patient;

public interface PatientService {
	
	public List<Patient> findAll();
	
	public Patient findByEmail(String email);
	
	public void save(Patient patient);
	
	public void deleteByEmail(String email);
	

}
