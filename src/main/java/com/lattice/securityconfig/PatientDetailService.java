package com.lattice.securityconfig;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lattice.dao.PatientDAO;
import com.lattice.entity.Patient;

@Service
public class PatientDetailService implements UserDetailsService {

	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		
			
		Patient patient = patientDAO.findByEmail(username);
		if (patient != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(patient.getRole()));
			return new User(patient.getEmail(), patient.getPassword(), roles);
		}
		throw new UsernameNotFoundException("Patient not found with the email " + username);

	}
}
