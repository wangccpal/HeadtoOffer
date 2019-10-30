package head67;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintMinNumber {
	public static String PrintMinNumber(int[] nums) {
		List<String> list= new ArrayList<String>();
				for(int x : nums){
			String s = x+"";
			list.add(s);
		}
			Collections.sort(list,(new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				
				return (o1+o2).hashCode()-(o2+o1).hashCode();
			}

			@Override
			public boolean equals(Object obj) {
				// TODO Auto-generated method stub
				return false;
			}
		}));

		StringBuilder sb = new StringBuilder();
		for(String s :list ) {
			sb.append(s);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,32,321};
		System.out.println(PrintMinNumber(nums));
	}

}
