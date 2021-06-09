package kodlamaioProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaioProject.hrms.business.abstracts.JobPositionService;
import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.core.utilities.results.SuccessDataResult;
import kodlamaioProject.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaioProject.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private  JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Data listelendi");
	}

}
