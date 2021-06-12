package kodlamaioProject.hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaioProject.hrms.business.Rules;
import kodlamaioProject.hrms.business.abstracts.UserService;
import kodlamaioProject.hrms.core.entities.User;
import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.core.utilities.results.ErrorResult;
import kodlamaioProject.hrms.core.utilities.results.Result;
import kodlamaioProject.hrms.core.utilities.results.SuccessDataResult;
import kodlamaioProject.hrms.core.utilities.results.SuccessResult;
import kodlamaioProject.hrms.dataAccess.abstracts.UserDao;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	
	@Override
	public Result add(User user) {
		 
		Result result = Rules.run(nullControl(user), eMailFormat(user.getEmail()));
		
		return null;
	}
	
	private Result nullControl(User user) {
		
		if(Objects.isNull(user.getId()) || Objects.isNull(user.getEmail()) || Objects.isNull(user.getPassword())){
			
			return new ErrorResult("Bu alanlar boş bırakılamaz!");
		}
		
		return new SuccessResult();
	}
	
	
	public static final Pattern validEmail = Pattern.compile(
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$",
			Pattern.CASE_INSENSITIVE);
	

	private Result eMailFormat(String email) {
		
		if(!validEmail.matcher(email).find()) {
			
			return new ErrorResult("Lütfen geçerli bir mail adresi yazınız!");
		}
		
		return new SuccessResult();
	}
	
	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Kullanıcılar Listelendi.");
	}

	@Override
	public DataResult<List<User>> getById(int id) {
		
		return null;//new SuccessDataResult<List<User>>(this.userDao.getById(id));
	}

	@Override
	public DataResult<List<User>> getByEmail(String email) {
		return null;//new SuccessDataResult<List<User>>(this.userDao.getByEmail(email));
	}



}
