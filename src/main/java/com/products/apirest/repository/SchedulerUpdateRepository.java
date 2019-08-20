package com.products.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.apirest.model.SchedulerUpdate;

public interface SchedulerUpdateRepository extends JpaRepository<SchedulerUpdate, Long>{
	
	SchedulerUpdate findById(long id);
}
