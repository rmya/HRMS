package kodlamaioProject.hrms.core.utilities.results;

public class ErrorResult extends Result{

	public ErrorResult(String message) {
		super(false, message);
		// TODO Auto-generated constructor stub
	}
	
	public ErrorResult() {
		super(false);
	}

}
