package head67;

public class IsNumeric {

	public static boolean main(String[] args) {
		String str = "1.2";
		try {
			
			Double.parseDouble(str);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	private static boolean isNumeric(String str) {
		if (str == null) return false;
		char[] c = str.toCharArray();
		return true;
	}

}
