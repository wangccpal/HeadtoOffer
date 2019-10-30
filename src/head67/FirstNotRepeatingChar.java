package head67;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
    	Map map = new LinkedHashMap<Character,Integer>();
        for(int i =0;i<str.length();i++){
        	char c  = str.charAt(i);
        	if(map.containsKey(c)) map.put(c, 2);
        	else map.put(c, 1);
        }
        for(int i =0;i<str.length();i++){
        	char c  = str.charAt(i);
        	if((int)map.get(c)==1) return i;
        }
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" ".length());
	}

}
