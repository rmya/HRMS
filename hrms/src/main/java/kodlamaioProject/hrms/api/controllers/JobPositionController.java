package kodlamaioProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaioProject.hrms.business.abstracts.JobPositionService;
import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {
	
	private final JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	@GetMapping("/gelall")
	public DataResult <List <JobPosition>> getAll(){
		
		return this.jobPositionService.getAll();
	}
}
