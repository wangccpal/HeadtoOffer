import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class DD001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println(new DD001().land(arr));
	}

	public int land(int[][] arr){
	    int m = arr.length;
	    int n = arr[0].length;
	    int count = 0;
	    boolean flag[][] = new boolean[m][n];
	    Queue<int[]> queue = new LinkedList<>();
	    int dirs[][] = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if(arr[i][j] == 1 && !flag[i][j]){
	                queue.offer(new int[]{i,j});
	                while(!queue.isEmpty()){
	                    int [] cell = queue.poll();
	                    flag[cell[0]][cell[1]] = true;
	                    for(int [] d : dirs){
	                        int row = cell[0] + d[0];
	                        int col = cell[1] + d[1];
	                        if(row<0 || row >=m || col<0 || col>=n || flag[row][col]
	                                || arr[row][col] == 0) continue;
	                        else {
	                            queue.offer(new int[]{row,col});
	                            flag[row][col] = true;
	                        }
	                    }
	                }
	                count++;
	            }
	        }
	    }
	    return count;
	}
}