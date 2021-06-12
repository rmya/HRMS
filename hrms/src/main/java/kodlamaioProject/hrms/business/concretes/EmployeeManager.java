package kodlamaioProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaioProject.hrms.business.abstracts.EmployeeService;
import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.core.utilities.results.Result;
import kodlamaioProject.hrms.core.utilities.results.SuccessDataResult;
import kodlamaioProject.hrms.core.utilities.results.SuccessResult;
import kodlamaioProject.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaioProject.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), "Tüm çalışanlar listelendi.");
	}

	@Override
	public Result add(Employee employee) {
		
		this.employeeDao.save(employee);
		
		return new SuccessResult("Yeni çalışan eklendi.");
	}

}
