import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sina1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		for(int i = 0; i < m; i++) {
			a[i] = sc.nextInt();
		}
		
		List<Integer> rst = new ArrayList<>();
		for(int i = 0,count=0;count < n;i++) {
			int temp = a[i%m];
			int loop = temp;
			if(i < rst.size())
				 loop = rst.get(i);
			for (int j = 0; j < loop ; j++) {
				rst.add(temp);
				count++;
			}
		}
		System.out.println(rst);
//		for (Integer r : rst) {
//			System.out.println(r);
//		}
	}

}
