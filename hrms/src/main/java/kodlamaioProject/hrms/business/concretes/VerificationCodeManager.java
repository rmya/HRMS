package kodlamaioProject.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaioProject.hrms.business.abstracts.VerificationCodeService;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	@Override
	public boolean sendVerificationCoode(String email) {
		
		return true;
	}

}
