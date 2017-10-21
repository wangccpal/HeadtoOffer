import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class eva {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		for (String temp : a) {
			if ("1".equals(temp)) {//为什么1、2结果不一样？
				
				a.remove(temp);
			}
		}
		System.out.println(a);

	}

}
