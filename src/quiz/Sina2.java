package quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sina2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc.useDelimiter("0 0 0 0 0 0");
		List<String> list = new ArrayList<String>();
		while(sc.hasNext()) {
			String nextLine = sc.nextLine();
			if(nextLine.equals("0 0 0 0 0 0")) break;
		}
		sc.close();
		System.out.println("ed");
//		int count = 0;
//		int size = 0;
//		int num = 0;
//		for (int i = 0; i < list.size()-6; i++) {
//			int s = i%6;
//			size += list.get(i) * (s+1)*(s+1);
//			count ++;
//			if(count==6) {
//				System.out.println((int)Math.floor((double)size/36));
//				count = 0;
//				size = 0;
//			}
//		}
	}

}
