package head67;
import java.util.Stack;

public class QueueOf2Stack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(stack2.isEmpty()) {
            while(stack1.size()!=0){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) return -1;
        else 
        return stack2.pop();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueOf2Stack q = new QueueOf2Stack();
		q.push(1);
		q.push(2);
		q.push(3);
//		q.push(4);
		System.out.println(q.pop()+""+q.pop()+""+q.pop()+""+q.pop()+"");
	}

}
