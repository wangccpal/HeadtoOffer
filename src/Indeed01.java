import java.util.Scanner;

public class Indeed01 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		String[] in = new String[m];
		String[][] res = new String[m*a][b];
		for(int i = 0;i<m;i++) {
				in[i] = sc.next();
			}
		for(int i = 0;i<m;i++) 
		{
				for(int k = 0;k<a*m;k=k+m)
					for(int l=0;l<b;l++) 
						res[k+i][l] =in[i]; 
			}
//			print(in);
//			System.out.println("end");
			print(res);
	}

	private static void print(String[][] in) {
		int m = in.length;
		int n = in[0].length;
		for(int i =0;i<m;i++){
			for(int j=0;j<n;j++)
				System.out.print(in[i][j]);
			System.out.println();
		}
	}
	private static void print(String[] in) {
		int m = in.length;
		for(int i =0;i<m;i++){
				System.out.print(in[i]);
			System.out.println();
		}
	}

}
