package Head67;

/**
 * 机器人的运动范围
 * 
 * @author CC
 *         地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *         例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8
 *         = 19。请问该机器人能够达到多少个格子？
 */
public class movingCountInMatrix {
	int count = 0;

	public static void main(String[] args) {
//		System.out.println(new movingCountInMatrix().movingCount(5, 10, 10));
		Integer i = null;
		System.out.println(i);
	}

	public int movingCount(int threshold, int rows, int cols) {
		boolean[] flag = new boolean[rows * cols];
		coreCount(threshold, rows, cols, 0, 0, flag);
		return count;
	}

	private void coreCount(int threshold, int rows, int cols, int i, int j, boolean[] flag) {
		if (i < 0 || i >= rows || j < 0 || j >= cols)
			return;
		int index = i * cols + j;
		if (flag[index] || !isLowerThreshold(threshold, i, j))
			return;
		count++;
		flag[index] = true;
		coreCount(threshold, rows, cols, i, j - 1, flag);
		coreCount(threshold, rows, cols, i, j + 1, flag);
		coreCount(threshold, rows, cols, i - 1, j, flag);
		coreCount(threshold, rows, cols, i + 1, j, flag);
	}

	private boolean isLowerThreshold(int threshold, int i, int j) {
		int xsum = 0;
		int ysum = 0;
		while (i > 0) {//注意这个判断条件
			xsum += i % 10;
			i /= 10;
		}
		while (j > 0) {
			ysum += j % 10;
			j /= 10;
		}
		return (xsum + ysum <= threshold);
	}

}
