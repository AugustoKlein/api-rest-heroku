package com.products.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.model.SchedulerUpdate ;
import com.products.apirest.model.SchedulerUpdate;
import com.products.apirest.repository.SchedulerUpdateRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Scheduler Update")
@CrossOrigin(origins="*")
public class SchedulerUpdateResource {

	@Autowired
	SchedulerUpdateRepository schedulerRepository;
	
	
	@GetMapping("/schedulerUpdates")
	public List<SchedulerUpdate> schedulerUpdates(){
		return schedulerRepository.findAll();
	}
	
	@GetMapping("/schedulerUpdates({id})")
	public SchedulerUpdate schedulerEntry(@PathVariable(value="id") long id){
		return schedulerRepository.findById(id);
	}
	
	@PostMapping("/schedulerUpdates")
	public SchedulerUpdate saveSchedulerUpdate (@RequestBody SchedulerUpdate product){
		return schedulerRepository.save(product);
	} 
	
	@DeleteMapping("/schedulerUpdates({id})")
	public void deleteSchedulerUpdate(@PathVariable(value="id") long id){
		schedulerRepository.delete(schedulerRepository.findById(id));
	}
}
