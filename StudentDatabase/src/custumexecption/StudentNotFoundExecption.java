package custumexecption;

public class StudentNotFoundExecption extends RuntimeException{
	
	private String msg;
	public StudentNotFoundExecption(String msg) {
		this.msg=msg;
	}
	
	public String toString() {
		return msg;
		
	}

}
