package headtoOffer67;

import java.util.Stack;

public class stackWithMin {
	Stack<Integer> stack = new Stack();
	Stack<Integer> min = new Stack();
	int m = Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if(node<m) m=node;
        min.push(m);
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
       return min.peek();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
