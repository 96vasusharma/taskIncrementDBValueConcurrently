package com.example.concurrentincrementindbcolumn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.concurrentincrementindbcolumn.service.IncrementDBValueService;

@RestController
public class IncrementDBValueController {

	@Autowired
	private IncrementDBValueService incrementDBValueService; 

	@PostMapping("/incrementDBValue")
    public void incrementDBValue() {
    	
    	incrementDBValueService.incrementDBValue();
    }

}
