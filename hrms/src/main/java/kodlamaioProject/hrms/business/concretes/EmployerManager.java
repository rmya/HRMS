package kodlamaioProject.hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.boolex.Matcher;
import kodlamaioProject.hrms.business.Rules;
import kodlamaioProject.hrms.business.abstracts.EmployerService;
import kodlamaioProject.hrms.business.abstracts.VerificationCodeService;
import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.core.utilities.results.ErrorResult;
import kodlamaioProject.hrms.core.utilities.results.Result;
import kodlamaioProject.hrms.core.utilities.results.SuccessDataResult;
import kodlamaioProject.hrms.core.utilities.results.SuccessResult;
import kodlamaioProject.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaioProject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private VerificationCodeService verificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, VerificationCodeService verificationService) {
		super();
		this.employerDao = employerDao;
		this.verificationService = verificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Tüm işverenler liatelendi");
	}

	@Override
	public DataResult<List<Employer>> getByEmail(String email) {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByEmail(email));
	}

	@Override
	public Result add(Employer employer) {
		
		Result result=Rules.run(nullControl(employer),webAdressControl(employer.getWebsite(),employer.getEmail()),existEmail(employer.getEmail()),realPhoneNumber(employer.getPhone()));
		
		if(result.isSuccess()) {
			
			this.employerDao.save(employer);
			verificationService.sendVerificationCoode(employer.getEmail());
			
			return new SuccessResult("İş veren sisteme eklendi.E-mail adresine doğrulama kodu gönderilmiştir.");
		}
		return result;
	}
	
	private Result nullControl(Employer employer) {
		
		if (Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getEmail()) 
				|| Objects.isNull(employer.getId()) || Objects.isNull(employer.getPassword()) 
				|| Objects.isNull(employer.getPhone()) || Objects.isNull(employer.getWebsite())) {
			
			return new ErrorResult("bu alanlar boş bırakılamaz.");
		}
		return new SuccessResult();
	}
	

	private Result existEmail(String email) {
		
		if (this.employerDao.getByEmail(email).stream().count() !=0) {
		
			return new ErrorResult("Bu E mail adresi kayıtlı.");
		}	
		return new SuccessResult();
	}

	private Result webAdressControl(String webAddress, String email) {
	
		String emailSplit= email.split("@")[1];
	
		if (!webAddress.contains(emailSplit)) {
			
			return new ErrorResult("email,web sitenin domainine sahip olmalıdır.");
		}
		
		return new SuccessResult();
	}
	
	private Result realPhoneNumber(String phone) {
		
		String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	
		Pattern pattern = Pattern.compile(patterns);
		
		java.util.regex.Matcher matcher = pattern.matcher(phone);
		
		if(!matcher.matches()) {
			
			return new ErrorResult("Telefon Numarası Geçersiz");
		}
		
		return new SuccessResult();
	
	}

}
