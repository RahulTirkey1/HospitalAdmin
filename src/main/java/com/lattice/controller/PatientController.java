package com.lattice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.entity.Booking;
import com.lattice.entity.Login;
import com.lattice.entity.Patient;
import com.lattice.entity.Token;
import com.lattice.securityconfig.JwtUtil;
import com.lattice.securityconfig.PatientDetailService;
import com.lattice.service.PatientService;

import io.swagger.annotations.ApiOperation;

@RestController
public class PatientController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientDetailService patientservice;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

		@GetMapping("/allPatients")
		public List<Patient> findAll() {
			return patientService.findAll();
		}

		@GetMapping("/patient/{email}")
		public Patient getEmployee(@PathVariable String email) {
			
			Patient patient = patientService.findByEmail(email);
			
			if (patient == null) {
				throw new RuntimeException("patient email not found - " + email);
			}
			
			return patient;
		}
		
		// add mapping for POST /employees - add new employee
		
		@PostMapping("/patient")
		public Patient addPatient(@RequestBody Patient patient) {
			
			patient.setCreationdate(new Date());
			patient.setBooking(false);
			patient.setRole("ROLE_USER");
			patient.setPassword(bcryptEncoder.encode(patient.getPassword()));
			patientService.save(patient);
			
			return patient;
		}
		
		// add mapping for PUT /employees - update existing employee
		
		@PutMapping("/updatepatient")
		public Patient updatePatient(@RequestBody Patient thePatient) {
			
			patientService.save(thePatient);
			
			return thePatient;
		}
		
		// add mapping for DELETE /employees/{employeeId} - delete employee
		
		@DeleteMapping("/patient/{email}")
		public String deletePatient(@PathVariable String email) {
			
			Patient patient = patientService.findByEmail(email);
			
			// throw exception if null
			
			if (patient == null) {
				throw new RuntimeException("Patient email not found - " + email);
			}
			
			patientService.deleteByEmail(email);
			
			return "Deleted employee id - " + email;
		}
		
		@PostMapping("/patient/makeAppointment")
		public String bookingAppointment(@RequestBody Booking booking)
		{
			Patient patient = patientService.findByEmail(booking.getEmail());
			if (booking.getEmail() == null) {
				throw new RuntimeException("Patient email not found - " + booking.getEmail());
			}
			patient.setBooking(true);
			patient.setBookingDate(new Date());
			patientService.save(patient);
			
			return "Appointment Successful for = "+booking.getEmail();
		}
		
		@PostMapping("/patient/login")
		public ResponseEntity<?> createAuthenticationToken(@RequestBody Login login)
				throws Exception {
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						login.getEmail(), login.getPassword()));
			} catch (DisabledException e) {
				throw new Exception("USER_DISABLED", e);
			}
			catch (BadCredentialsException e) {
				throw new Exception("INVALID_CREDENTIALS", e);
			}
			
			UserDetails userdetails = patientservice.loadUserByUsername(login.getEmail());
			String token = jwtUtil.generateToken(userdetails);
			return ResponseEntity.ok(new Token(token));
		}
		
	
}
