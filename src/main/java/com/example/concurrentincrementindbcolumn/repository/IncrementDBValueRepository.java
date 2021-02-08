package com.example.concurrentincrementindbcolumn.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.concurrentincrementindbcolumn.modal.SingleValueModel;

public interface IncrementDBValueRepository extends CrudRepository<SingleValueModel, String> {

	
}
