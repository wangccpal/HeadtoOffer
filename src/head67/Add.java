package head67;

public class Add {
	public int Add(int num1, int num2) {
		int n1 = num1 ^ num2;// �����λ�ó��Ľ��
		int n2 = (num1 & num2) << 1;// �������λ��λ
		//Ҳ����ֱ����num1��2���㣬���ǻ�ı�ԭֵ
		while (n2 != 0) {
			int temp = n1 ^ n2;//ע�ⲻ��ֱ����n1= n1^n2;�����ı�n2 ��ֵ
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
