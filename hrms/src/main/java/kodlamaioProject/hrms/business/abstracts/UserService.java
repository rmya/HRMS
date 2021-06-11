package kodlamaioProject.hrms.business.abstracts;

import java.util.List;

import kodlamaioProject.hrms.core.entities.User;
import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.core.utilities.results.Result;

public interface UserService {

	DataResult <List <User>> getAll();
	
	DataResult <List <User>> getById(int id);
	
	DataResult <List <User>> getByEmail(String email);
	
	Result add(User user);
}
