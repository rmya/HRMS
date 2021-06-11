package kodlamaioProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaioProject.hrms.business.abstracts.JobSeekerService;
import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.core.utilities.results.Result;
import kodlamaioProject.hrms.entities.concretes.JobSeeker;

@RestController
@Controller("api/jobseekers")
public class JobSeekerController {
	
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List <JobSeeker>> getAll(){
		
		return this.jobSeekerService.getAll();
	}
	
	public Result add(JobSeeker jobSeeker) {
		
		return this.jobSeekerService.add(jobSeeker);
	}

}
