package custumexecption;

public class InvalidChoiceException extends RuntimeException {
	private String msg;
	public InvalidChoiceException(String msg) {
		this.msg=msg;
	}
	
	public String toString() {
		return msg;
		
	}


}
