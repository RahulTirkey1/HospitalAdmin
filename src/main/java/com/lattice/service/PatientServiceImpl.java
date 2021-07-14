package com.lattice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lattice.dao.PatientDAO;
import com.lattice.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientDAO patientDAO;

	@Override
	@Transactional
	public List<Patient> findAll() {
	
		List<Patient> patients=patientDAO.findAll();
		List<Patient> newPatients=new ArrayList<Patient>();
		
		List<Patient> patient1= new ArrayList<Patient>();
		List<Patient> patient2= new ArrayList<Patient>();
		
		patients.forEach(e->{
			if(e.getBooking())
			{ 
				System.out.println("Hello");
				patient1.add(e);
			}
		});
		
		patients.forEach(e->{
			if(!e.getBooking())
			{
				patient2.add(e);
			}
		});
		
		if(patient1.size()>0)
		{
			patient1.sort(Comparator.comparing(Patient::getBookingDate));
			
			patients.clear();
			patient1.forEach(e->{
				newPatients.add(e);
			});
		}
		patient2.sort(Comparator.comparing(Patient::getCreationdate));
		patient2.forEach(e->{
			newPatients.add(e);
		});
		
		
		
		return newPatients;
	}

	@Override
	@Transactional
	public Patient findByEmail(String email) {
		
		return patientDAO.findByEmail(email);
	}

	@Override
	@Transactional
	public void save(Patient patient) {
		patientDAO.save(patient);

	}

	@Override
	@Transactional
	public void deleteByEmail(String email) {
		patientDAO.deleteByEmail(email);

	}
	
	
}
