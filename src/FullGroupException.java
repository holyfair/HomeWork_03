
public class FullGroupException extends Exception{

	@Override
	public String getMessage() {
		return "Group is already full";
	}
}
