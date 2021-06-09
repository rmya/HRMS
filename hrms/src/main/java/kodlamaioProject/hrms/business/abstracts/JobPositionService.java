package kodlamaioProject.hrms.business.abstracts;

import java.util.List;

import kodlamaioProject.hrms.core.utilities.results.DataResult;
import kodlamaioProject.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	DataResult <List <JobPosition>> getAll();
}
