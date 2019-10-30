package head67;

//����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
//�����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
public class printMatrix {

	public static void printMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int k = (Math.min(m, n) - 1) / 2 + 1; // ѭ������
		for (int i = 0; i < k; i++) {
			int j, p,q;
			for (j = i; j < n - i; j++)
				System.out.print(matrix[i][j]);
			System.out.println();
			for (p = i + 1,--j; p < m - i; p++) //ע��ѭ��������һ��ѭ���󲻷�������Ҫ����
				System.out.print(matrix[p][j]);
			System.out.println();
//			for (j = j - 1,--p; j >= i && p!=i; j--)//����ֻ��һ��ʱ�ظ����
//				System.out.print(matrix[p][j]);
			for (q = j - 1,--p; q >= i && p!=i; q--)//����ֻ��һ��ʱ�ظ����
				System.out.print(matrix[p][q]);
			System.out.println();
			for (p = p - 1,++q; p > i&&q!=j ; p--)//����ֻ��һ��ʱ�ظ����
				System.out.print(matrix[p][q]);
			System.out.println();

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
//		int [][] m = {{1,2,3,4,5}};
//		int [][] m = {{1},{2},{3},{4}};
		
		printMatrix(m);
	}

}
