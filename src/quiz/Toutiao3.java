package quiz;

import java.util.Scanner;

public class Toutiao3 {
	static StringBuilder l1 = new StringBuilder();
	static StringBuilder l2 = new StringBuilder();
	static StringBuilder l3 = new StringBuilder();
	static StringBuilder l4 = new StringBuilder();
	static StringBuilder l5 = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		char op = sc.next().charAt(0);
		int n2 = sc.nextInt();
		System.out.println(n1 + op + n2);
		int res = 0;
		double rd = 0;
		switch (op) {
		case '+':
			res = n1 + n2;
			break;
		case '-':
			res = n1 - n2;
			break;
		case '*':
			res = n1 * n2;
			break;
		case '/':
			res =  n1 / n2;
			rd =  (double)n1 / n2;
			break;
		}
		System.out.println(res);
		format(n1 + "");
		if(op=='/'){
			format(op + "");
			format(n2 + "");
			format("=");
			if(rd-res>0)
			format(rd + "");
			else format(res+"");
		}
		else{
		format(op + "");
		format(n2 + "");
		format("=");
		format(res + "");
		}
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(l4);
		System.out.println(l5);

	}

	private static void format(String res) {
		for (char c : res.toCharArray()) {
			switch (c) {
			case '1':
				l1.append("*  ");
				l2.append("*  ");
				l3.append("*  ");
				l4.append("*  ");
				l5.append("*  ");
				break;
			case '2':
				l1.append("***  ");
				l2.append("  *  ");
				l3.append("***  ");
				l4.append("*    ");
				l5.append("***  ");
				break;
			case '3':
				l1.append("***  ");
				l2.append("  *  ");
				l3.append("***  ");
				l4.append("  *  ");
				l5.append("***  ");
				break;
			case '4':
				l1.append("* *  ");
				l2.append("* *  ");
				l3.append("***  ");
				l4.append("  *  ");
				l5.append("  *  ");
				break;
			case '5':
				l1.append("***  ");
				l2.append("*    ");
				l3.append("***  ");
				l4.append("  *  ");
				l5.append("***  ");
				break;
			case '6':
				l1.append("***  ");
				l2.append("*    ");
				l3.append("***  ");
				l4.append("* *  ");
				l5.append("***  ");
				break;
			case '7':
				l1.append("***  ");
				l2.append("  *  ");
				l3.append("  *  ");
				l4.append("  *  ");
				l5.append("  *  ");
				break;
			case '8':
				l1.append("***  ");
				l2.append("* *  ");
				l3.append("***  ");
				l4.append("* *  ");
				l5.append("***  ");
				break;
			case '9':
				l1.append("***  ");
				l2.append("* *  ");
				l3.append("***  ");
				l4.append("  *  ");
				l5.append("***  ");
				break;
			case '0':
				l1.append("***  ");
				l2.append("* *  ");
				l3.append("* *  ");
				l4.append("* *  ");
				l5.append("***  ");
				break;
			case '+':
				l1.append("     ");
				l2.append(" *   ");
				l3.append("***  ");
				l4.append(" *   ");
				l5.append("     ");
				break;
			case '-':
				l1.append("     ");
				l2.append("     ");
				l3.append("***  ");
				l4.append("     ");
				l5.append("     ");
				break;
			case '*':
				l1.append("     ");
				l2.append("* *  ");
				l3.append(" *   ");
				l4.append("* *  ");
				l5.append("     ");
				break;
			case '/':
				l1.append("     ");
				l2.append("  *  ");
				l3.append(" *   ");
				l4.append("*    ");
				l5.append("     ");
				break;
			case '.':
				l1.append("    ");
				l2.append("    ");
				l3.append("    ");
				l4.append("**  ");
				l5.append("**  ");
				break;
			case '=':
				l1.append("      ");
				l2.append("****  ");
				l3.append("      ");
				l4.append("****  ");
				l5.append("      ");
				break;
			}
		}
	}

}
