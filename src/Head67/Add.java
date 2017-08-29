package Head67;

public class Add {
	public int Add(int num1, int num2) {
		int n1 = num1 ^ num2;// 不算进位得出的结果
		int n2 = (num1 & num2) << 1;// 会产生进位的位
		//也可以直接用num1，2计算，就是会改变原值
		while (n2 != 0) {
			int temp = n1 ^ n2;//注意不能直接用n1= n1^n2;否则会改变n2 的值
			n2 = (n1 & n2)<<1;
			n1 = temp;
		}
		return n1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Add().Add(11, 29));
	}

}
