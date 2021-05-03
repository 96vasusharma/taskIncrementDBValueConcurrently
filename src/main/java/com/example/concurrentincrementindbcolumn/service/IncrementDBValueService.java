package com.example.concurrentincrementindbcolumn.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.concurrentincrementindbcolumn.modal.SingleValueModel;
import com.example.concurrentincrementindbcolumn.repository.IncrementDBValueRepository;

@Service
public class IncrementDBValueService {

	private static final String SINGLE_DB_VALUE_ID = "1";
	@Autowired
	private IncrementDBValueRepository incrementDBValueRepository;
	
	synchronized public void incrementDBValue() {
		
		// GET
		Optional<SingleValueModel> singleValueModelOptional = incrementDBValueRepository.findById(SINGLE_DB_VALUE_ID);
		if (singleValueModelOptional.isPresent()) {
			SingleValueModel singleValueModel = singleValueModelOptional.get();

			singleValueModel.setIntValue(singleValueModel.getIntValue() + 1);

			// UPDATE
			incrementDBValueRepository.save(singleValueModel);
		}
	}

	public void updateDBValue(int value) {
		// TODO Auto-generated method stub
		
		// UPDATE
		incrementDBValueRepository.updateDBValue(value);
		
	}

//	Below approaching is causing RTOs
	
//	@PersistenceContext
//	private EntityManager em;
//	
//	@Transactional
//	public void incrementDBValue() {
//
//		em.createQuery("update SingleValueModel svm set svm.intValue = svm.intValue + 1").executeUpdate();
//	}
	
}
