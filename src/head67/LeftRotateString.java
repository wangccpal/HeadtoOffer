package head67;

public class LeftRotateString {
    public static String LeftRotateString(String str,int n) {
    	if("".equals(str)) return "";
    	if(n>str.length()) n=n%str.length();
        String s1 = str.substring(0, n);
        String s2 = str.substring(n);
        return s2+s1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LeftRotateString("", 3));
	}

}
