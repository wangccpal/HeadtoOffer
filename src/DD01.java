import java.util.Scanner;
/*
 *  4 5
 *  11000
 *  11000
 *  00100
 *  00011
 */

public class DD01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = func();
		System.out.println(count);
	}

	public static int func() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] map = new int[m][n];
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					if (i >= 1 && j >= 1) {
						if (map[i - 1][j] != 1 && map[i][j - 1] != 1)
							count++;
					} else if ( j >= 1) {
						if (map[i][j - 1] != 1)
							count++;
					} else if ( i >= 1) {
						if (map[i - 1][j] != 1)
							count++;
					}
					else count++;
				}
			}
		}
		return count;
	}

}
