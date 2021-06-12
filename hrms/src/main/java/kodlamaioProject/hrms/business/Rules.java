package kodlamaioProject.hrms.business;

import kodlamaioProject.hrms.core.utilities.results.Result;
import kodlamaioProject.hrms.core.utilities.results.SuccessResult;

public class Rules {

	public static Result run(Result... logics) {
		
		for(Result logic : logics) {
			if(!logic.isSuccess()) {
				return logic;
			}
		}
		
		return new SuccessResult();
	}
}
