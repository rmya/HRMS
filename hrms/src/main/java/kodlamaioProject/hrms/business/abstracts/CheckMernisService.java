package kodlamaioProject.hrms.business.abstracts;

import kodlamaioProject.hrms.entities.concretes.JobSeeker;

public interface CheckMernisService {
	
	boolean checkIfRealTc(JobSeeker jobSeeker);

}
