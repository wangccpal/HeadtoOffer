package head67;

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
    		while (num[i]>num[dq.getLast()] ) dq.pollLast();//�������������ǰ��Ĵ󣬱�ʾ���ǳ�Ϊ�������ֵ
    		if(dq.peekFirst() < i-size+1) dq.pollFirst();//����������ѹ��ڣ��͵���
    		dq.offerLast(i);
    		if(i>=size-1) rst.add(num[i]);//�жϻ��������ǲ��ǰ����㹻����
    	}
		return rst;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
