package com.lattice.dao;

import java.util.List;

import com.lattice.entity.Patient;

public interface PatientDAO {
	
	public List<Patient> findAll();
	
	public Patient findByEmail(String email);
	
	public void save(Patient patient);
	
	public void deleteByEmail(String email);
	
}
