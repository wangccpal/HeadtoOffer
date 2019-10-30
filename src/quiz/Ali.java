package quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Ali {

	public static void main(String[] args) {

		ArrayList<Integer> inputs = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		if (line != null && !line.isEmpty()) {
			int res = resolve(line.trim());
			System.out.println(String.valueOf(res));
		}
	}

	// write your code here
	public static int resolve(String expr) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean moreblank = false;
		int num = 0;
		for (char c : expr.toCharArray()) {
			int cc = c - '0';
			if (cc >= 0 && cc <= 9){
				moreblank = false;
				num = 10 * num + cc;
			}
			else if (c == ' ') {
				if (moreblank)
					continue;
				if (stack.size() == 16)
					return -2;
				stack.push(num);
				num = 0;
				moreblank = true;
			} else if (c == '^') {
				try {
				Integer i = stack.pop();
				stack.push(++i);
				}
				catch (Exception e){
					return -1;
				}

			} else if (c == '+') {

				try {
				Integer i = stack.pop();
				Integer j = stack.pop();
				stack.push(i+j);
				}
				catch (Exception e){
					return -1;
				}

			} else if (c == '*') {

				try {
				Integer i = stack.pop();
				Integer j = stack.pop();
				stack.push(i*j);
				}
				catch (Exception e){
					return -1;
				}
			}
		}

		// }
		return stack.pop() + 0;
	}
}