package quiz;

import java.util.HashSet;
import java.util.Scanner;

public class Toutiao2 {

	public static void main(String[] args) {
		HashSet<Long> set = new HashSet<Long>();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			long num  = sc.nextLong();
			if(num==0) break;
			set.add(num);
		}
		System.out.println(set.size());
	}
}
