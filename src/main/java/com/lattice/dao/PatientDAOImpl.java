package com.lattice.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lattice.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Patient> findAll() {
		
				Session currentSession = entityManager.unwrap(Session.class);
				
				// create a query
				Query<Patient> theQuery =
						currentSession.createQuery("from Patient", Patient.class);
				
				// execute query and get result list
				List<Patient> patients = theQuery.getResultList();
				
				// return the results	
				
				return patients;
	}

	@Override
	public Patient findByEmail(String email) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		List<Patient> patient=findAll();
		System.out.println(patient);
		Patient thePatient=null;
		for(Patient i:patient)
		{
			if(i.getEmail().equals(email))
			{
				thePatient=i;
			}
		}
		
		return thePatient;
	}

	@Override
	public void save(Patient patient) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(patient);
	
		
		
	}

	@Override
	public void deleteByEmail(String email) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Transaction tx=currentSession.beginTransaction();
		Query theQuery = 
				currentSession.createQuery(
						"delete from Patient where email=:email");
		theQuery.setParameter("email", email);
		
		theQuery.executeUpdate();
		
		
		
	}
	
	

}
