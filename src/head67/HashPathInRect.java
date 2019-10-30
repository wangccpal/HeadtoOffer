package head67;

/**
 * �����������ֵ
 * 
 * @author CC �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 *         ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 *         ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� ���� a b c e s f c s a d e e
 *         �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 */
public class HashPathInRect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean[] flag = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (coreFind(matrix, rows, cols, str, i, j, flag, 0))
					return true;
			}
		}
		return false;
	}

	private boolean coreFind(char[] matrix, int rows, int cols, char[] str, int i, int j, boolean[] flag, int k) {
		if(k==str.length) return true;
		if(i<0 || i>= rows || j<0 || j>=cols) return false;
		int loc = i * cols + j;
		if(matrix[loc] != str[k] || flag[loc]) return false;
		flag[loc] = true;
		if(	coreFind(matrix, rows, cols, str, i, j-1, flag, k+1) || coreFind(matrix, rows, cols, str, i, j+1, flag, k+1)
		  || coreFind(matrix, rows, cols, str, i-1, j, flag, k+1) || coreFind(matrix, rows, cols, str, i+1, j, flag, k+1) )
			return true;
		flag[loc] = false;
		return false;
	}
}
