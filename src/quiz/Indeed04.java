package quiz;

import java.util.Scanner;
import java.util.TreeMap;
/*
 * 
 10000000000 5
3282894320 391
4394338332 929
6932893249 181
7823822843 440
9322388365 623
Time limit : 2sec / Memory limit : 256MB

Score : 100 points

Problem Statement
There is a road with a length of L meters that runs east-west, and there are N houses built along this road. The i-th house from the west is located xi meters east of the west end of the road, and there are ri people who live in the house.

A station is going to be built on this road, and there was a discussion on the location of the station. Let the location of the station be P meters east of the west end of the road. According to the law, P must be a integer satisfying 0≤P≤L. After the discussion, it was decided that the location of the station will be chosen so that it minimizes the disutility calculated as follows:

(disutility) = (the sum of (|xi−P|×ri) over all i (1≤i≤N))
Here, |a| denotes the absolute value of a.

Find the disutility when the location of the station is chosen to minimize it.

Constraints
All input values are integers.
1≤L≤1010
1≤N≤105
0≤x1<x2<…<xN≤L
1≤ri≤103
Input
The input is given from Standard Input in the following format:

L N
x1 r1
x2 r2
:
xN rN
Output
Print the disutility when the location of the station is chosen to minimize it.
Sample Input 1
Copy
100 3
20 3
50 2
70 1
Sample Output 1
Copy
110
When P=40, the disutility is |20−40|×3+|50−40|×2+|70−40|×1=110. There is no location with a lower disutility.

Sample Input 2
Copy
100 2
0 1
100 10
Sample Output 2
Copy
100
There may be houses at both ends of the road, and the station may also be built at these locations.

Sample Input 3
Copy
10000000000 5
3282894320 391
4394338332 929
6932893249 181
7823822843 440
9322388365 623
Sample Output 3
Copy
5473201404068
 */
public class Indeed04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long out = 0;

		long L = sc.nextLong();
		int N = sc.nextInt();
		long[] x = new long[N];
		int[] r = new int[N];
		for(int i=0;i<N;i++){
			x[i] = sc.nextLong();
			r[i] = sc.nextInt();
		}
//		int left=0,right = N;
//		while(left<=right){
//			int mid = left+(right-left)/2;
//			
//		}
		TreeMap<Long , Long > tree = new TreeMap<Long, Long>();
		for(long xi:x) {
			long sum = 0;
			for(int j=0;j<N; j++){
				sum+=Math.abs(x[j]-xi)*r[j];
			}
//			if(sum<min) {
//				min=sum;
//				out = i;
//			}
			tree.put(sum, xi);
		}
		long min1 = tree.firstKey();
		long min2 = tree.higherKey(min1);
		System.out.println(min1+","+min2);//5473201404068
		long min = min2;
		for(long i = min1;i<=min2;i++) {
			long sum = 0;
			for(int j=0;j<N; j++){
				sum+=Math.abs(x[j]-i)*r[j];
			}
			if(sum<min) {
				min=sum;
				out = i;
			}
		}
		System.out.println(out+","+min);//5473201404068
	}

}
