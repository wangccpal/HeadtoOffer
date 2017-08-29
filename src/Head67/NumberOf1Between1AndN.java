package Head67;
//链接：https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
//来源：牛客网
//
//从 1 至 10，在它们的个位数中，任意的 X 都出现了 1 次。
//  
//    从 1 至 100，在它们的十位数中，任意的 X 都出现了 10 次。
//  
//    从 1 至 1000，在它们的百位数中，任意的 X 都出现了 100 次。
public class NumberOf1Between1AndN {
	public int NumberOf1Between1AndN_Solution(int n) {
		int cur, low, high = 1, i = 1, sum = 0;
		while (high != 0) {
			// 从右往左计算
			high = n / (i * 10); // 更高的所有位
			cur = n % (i * 10) / i;// 当前位
			low = n % i;// 更低的所有位
			if (cur > 1)
				sum += (high + 1) * i;
			else if (cur == 1)
				sum += high * i + low + 1;
			else if (cur < 1)
				sum += high * i;
			i *= 10;
		}
		return sum;
	}

	public int NumberOf1Between1AndN_Solution(int n,int x) {
		int cur, low, high = 1, i = 1, sum = 0;
		while (high != 0) {
			// 从右往左计算
			high = n / (i * 10); // 更高的所有位
			cur = n % (i * 10) / i;// 当前位
			low = n % i;// 更低的所有位
			if (cur > x)
				sum += (high + 1) * i;
			else if (cur == x)
				sum += high * i + low + 1;
			else if (cur < x)
				sum += high * i;
			i *= 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(2593,5));
	}
}
