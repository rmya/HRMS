package kodlamaioProject.hrms.business.abstracts;

import java.util.List;

import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.core.utilities.results.Result;
import kodlamaioProject.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List <Employer>> getAll();
	
	DataResult<List <Employer>> getByEmail(String email);
	
	Result add (Employer employer);

}
