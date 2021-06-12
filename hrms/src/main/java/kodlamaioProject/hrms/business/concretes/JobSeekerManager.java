package kodlamaioProject.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaioProject.hrms.business.abstracts.JobSeekerService;
import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.core.utilities.results.Result;
import kodlamaioProject.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}

}
