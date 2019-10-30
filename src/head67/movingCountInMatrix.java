package head67;

/**
 * �����˵��˶���Χ
 * 
 * @author CC
 *         ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 *         ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8
 *         = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
		while (i > 0) {//ע������ж�����
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
