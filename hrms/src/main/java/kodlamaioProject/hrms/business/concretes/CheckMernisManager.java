package kodlamaioProject.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaioProject.hrms.business.abstracts.CheckMernisService;
import kodlamaioProject.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class CheckMernisManager implements CheckMernisService{

	@Override
	public boolean checkIfRealTc(JobSeeker jobSeeker) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		boolean result = true;
		
		try {
			
			result = client.TCKimlikNoDogrula(
					Long.parseLong(jobSeeker.getIdentityNumber()),
					jobSeeker.getFirstName().toUpperCase(),
					jobSeeker.getLastName().toUpperCase(),
					jobSeeker.getBirthYear());
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

}
