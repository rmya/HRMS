package kodlamaioProject.hrms.business.abstracts;

import java.util.List;

import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.core.utilities.results.Result;
import kodlamaioProject.hrms.entities.concretes.Employee;

public interface EmployeeService {
	
	DataResult <List <Employee>> getAll();

	Result add(Employee employee);
}
