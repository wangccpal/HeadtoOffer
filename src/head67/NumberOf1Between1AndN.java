package head67;
//���ӣ�https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
//��Դ��ţ����
//
//�� 1 �� 10�������ǵĸ�λ���У������ X �������� 1 �Ρ�
//  
//    �� 1 �� 100�������ǵ�ʮλ���У������ X �������� 10 �Ρ�
//  
//    �� 1 �� 1000�������ǵİ�λ���У������ X �������� 100 �Ρ�
public class NumberOf1Between1AndN {
	public int NumberOf1Between1AndN_Solution(int n) {
		int cur, low, high = 1, i = 1, sum = 0;
		while (high != 0) {
			// �����������
			high = n / (i * 10); // ���ߵ�����λ
			cur = n % (i * 10) / i;// ��ǰλ
			low = n % i;// ���͵�����λ
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
			// �����������
			high = n / (i * 10); // ���ߵ�����λ
			cur = n % (i * 10) / i;// ��ǰλ
			low = n % i;// ���͵�����λ
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
