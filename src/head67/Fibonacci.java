package head67;

public class Fibonacci {
	public static int Fibonacci(int n) {
		int res = 0;
		int num1 = 0;
		int num2 = 1;
		for (int i = 0; i < n; i++) {
			res = num1 + num2;
			num2 = num1;
			num1 = res;
		}
		return res;
	}

	public static int Fibonacci0(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		return Fibonacci0(n - 1) + Fibonacci0(n - 2);
	}

	public static int FibonacciMatrix(int n) {// 矩阵快速幂解法
		if (n == 1 || n == 2)
			return 1;
		int[][] matrix = { { 1, 1 }, { 1, 0 } };
		int len = matrix.length;
		int[][] res = fastMulti(matrix, n - 2);
		return res[0][0] + res[0][1];
	}

	public static int[][] multiMatrix(int[][] m1, int[][] m2) {
		// 参数判断什么的就不给了，如果矩阵是n*m和m*p,那结果是n*p
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}

	public static int[][] fastMulti(int[][] m1, int base) {
		if (base == 1)
			return m1;
		int[][] res = new int[m1.length][m1[0].length];
		res = multiMatrix(fastMulti(m1, base / 2), fastMulti(m1, base / 2));
		if (base % 2 == 1)
			res = multiMatrix(m1, res);
		return res;
	}
	

		    /* * 矩阵的快速幂：
		     * 1.假如不是矩阵，叫你求m^n,如何做到O(logn)？答案就是整数的快速幂：
		     * 假如不会溢出，如10^75,把75用用二进制表示：1001011,那么对应的就是：
		     * 10^75 = 10^64*10^8*10^2*10
		     * 2.把整数换成矩阵，是一样的
		     **/
//		    public int[][] matrixPower(int[][] m, int p) {
//		        int[][] res = new int[m.length][m[0].length];
//		        //先把res设为单位矩阵
//		        for (int i = 0; i < res.length; i++) {
//		            res[i][i] = 1;
//		        } //单位矩阵乘任意矩阵都为原来的矩阵
//		        //用来保存每次的平方
//		        int[][] tmp = m;
//		        //p每循环一次右移一位
//		        for ( ; p != 0; p >>= 1) {
//		            //如果该位不为零，应该乘
//		            if ((p&1) != 0) {
//		                res = multiMatrix(res, tmp);
//		            }
//		            //每次保存一下平方的结果
//		            tmp = multiMatrix(tmp, tmp);
//		        }
//		        return res;
//		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t1 = System.currentTimeMillis();
		int n1 = Fibonacci(10);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		System.out.println(n1+"循环计算的时间是：" + (t2 - t1-1));
		
		 t1 = System.currentTimeMillis();
		int n2 = Fibonacci0(41);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 t2 = System.currentTimeMillis();
		System.out.println(n2+"递归计算的时间是：" + (t2 - t1-1));
		
		 t1 = System.currentTimeMillis();
			int n3 = FibonacciMatrix(10);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 t2 = System.currentTimeMillis();
		System.out.println(n3+"快速幂计算的时间是：" + (t2 - t1-1));
		float x = 0f;
		System.out.println(x==0);
	}

}
