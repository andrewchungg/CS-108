
public class PasswordDriver {
	public static void main(String[] args) {
		String[] test = { "pw1", "pw1", "pw3", "pw4",
	             "pw5", "pw6", "pw7", "pw8", 
	             "pw9", "pw10", "pw10", "pw10" };
		PasswordProg1 p = new PasswordProg1(test);
		if(p.hasWord("pw1")) {
			System.out.println("yay");
		}
	}
}
