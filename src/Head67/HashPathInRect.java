package Head67;

/**
 * 滑动窗口最大值
 * 
 * @author CC 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *         路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *         如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e
 *         矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
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
