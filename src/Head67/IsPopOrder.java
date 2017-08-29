package Head67;

import java.util.Stack;

public class IsPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int i=1;
        stack.push(pushA[0]);//空栈peek会异常
        for(int pop :popA){
        	while(pop!=stack.peek()) {
        		if(i==popA.length) return false;//不能在i++后面判断以免结果错误
        		stack.push(pushA[i]);
        		i++;
        	}
        	stack.pop();
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5};
		int b[] = {4,5,3,2,1};
		System.out.println(IsPopOrder(a,b));
	}

}
