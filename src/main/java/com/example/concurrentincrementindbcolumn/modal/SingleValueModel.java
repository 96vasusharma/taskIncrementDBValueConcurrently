package com.example.concurrentincrementindbcolumn.modal;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

// caching the entity object also not solving the purpose
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SingleValueModel {

	@Id
	private String id;
	private int intValue;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

}
