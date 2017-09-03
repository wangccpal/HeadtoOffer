package Head67;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInSlideWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
    	ArrayList<Integer> rst = new ArrayList<Integer>();
    	Deque<Integer> dq =  new LinkedList<Integer>();
    	for(int i = 0;i < num.length;i++) {
    		if(dq.isEmpty()) dq.offer(i);
    		while (num[i]>num[dq.getLast()] ) dq.pollLast();//如果新来的数比前面的大，表示他们成为不了最大值
    		if(dq.peekFirst() < i-size+1) dq.pollFirst();//如果最大的数已过期，就弹出
    		dq.offerLast(i);
    		if(i>=size-1) rst.add(num[i]);//判断滑动窗口是不是包含足够的数
    	}
		return rst;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
