package custumexecption;

public class StudentNotFoundExecption2 extends RuntimeException{
	
	private String msg;
	public StudentNotFoundExecption2(String msg) {
		this.msg=msg;
	}
	
	public String toString() {
		return msg;
		
	}

}
