import java.util.Scanner;

public class Ofo33 {
	static int[] arr; // ���4����
	static int[] tag; // ��Ǽ��� ���ȼ���+-��1��ʾ��*/��2��ʾ

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		arr = new int[4];
		tag = new int[3];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		input.close();
		getOrder(0);
	}

	/**
	 * �õ����������������
	 * 
	 * @param t
	 */
	public static void getOrder(int t) {
		if (t >= arr.length) {
			computer(0, 0, "");
			return;
		}
		for (int i = t; i < arr.length; i++) {
			ch(i, t);
			getOrder(t + 1);
			ch(i, t);
		}
	}

	/**
	 * ��i�������j��������
	 * 
	 * @param i
	 * @param j
	 */
	public static void ch(int i, int j) {
		int t = 0;
		t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	/**
	 * 
	 * @param t   ��ʾ��t����
	 * @param num ����ĵ�ǰֵ
	 * @param s   ��ǰ�ı��ʽ
	 */
	public static void computer(int t, int num, String s) {
		if (t == 4) {
			if (num == 24 && isOk(s)) {
				System.out.println(s);
			}
			return;
		}
		if (t == 0) {
			computer(t + 1, num + arr[t], String.valueOf(arr[0]));
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				tag[t - 1] = 1;
				computer(t + 1, num + arr[t], s + "+" + String.valueOf(arr[t]));
			}
			if (i == 1) {
				tag[t - 1] = 1;
				if (num - arr[t] > 0) {
					computer(t + 1, num - arr[t],
							s + "-" + String.valueOf(arr[t]));
				} else {
					return;
				}
			}
			if (i == 2) {
				tag[t - 1] = 2;
				computer(t + 1, num * arr[t], s + "*" + String.valueOf(arr[t]));
			}
			if (i == 3) {
				tag[t - 1] = 2;
				if (num % arr[t] == 0) {
					computer(t + 1, num / arr[t],
							s + "/" + String.valueOf(arr[t]));
				} else {
					return;
				}
			}
		}
	}

	/**
	 * ����tag��ǵ����ȼ��ж��Ƿ������
	 * 
	 * @param s
	 * @return ����������ŵı��ʽ����false�����ӷ���true
	 */
	public static boolean isOk(String s) {
		int t = 0;
		if (tag[0] == 1 && tag[1] == 1 && tag[2] == 2 || tag[0] == 2
				&& tag[1] == 1 && tag[2] == 2) {
			t = s.lastIndexOf("*") > s.lastIndexOf("/") ? s.lastIndexOf("*")
					: s.lastIndexOf("/");
			System.out.println("(" + s.substring(0, t) + ")" + s.substring(t));
			return false;
		} else if (tag[0] == 1 && tag[1] == 2) {

			t = s.indexOf("*") > s.indexOf("/") ? s.indexOf("*") : s
					.indexOf("/");

			System.out.println("(" + s.substring(0, t) + ")" + s.substring(t));
			return false;
		}
		return true;
	}
}
