package com.example.concurrentincrementindbcolumn.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.concurrentincrementindbcolumn.modal.SingleValueModel;

//@Repository
@Transactional
public interface IncrementDBValueRepository extends CrudRepository<SingleValueModel, String> {

	@Modifying
	@Query("update SingleValueModel svm set svm.intValue = :value")
	void updateDBValue(@Param("value") int value);
	
}
