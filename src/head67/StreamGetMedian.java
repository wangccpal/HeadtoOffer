package head67;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 得到输入流里的中位数
 * @author CC
 *
 */
public class StreamGetMedian {
	PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>();
	PriorityQueue<Integer> pqMax = new PriorityQueue<Integer>(
			new Comparator<Integer>() {
				
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}

				@Override
				public boolean equals(Object obj) {
					// TODO Auto-generated method stub
					return false;
				}
			});
	
	int  count;
	public static void main(String[] args) {

	}

    public void Insert(Integer num) {
        if(count%2==0) {
        	pqMax.offer(num);
        	pqMin.offer(pqMax.poll());
        }
        else {
        	pqMin.offer(num);
        	pqMax.offer(pqMin.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2 == 0) return (pqMax.peek()+pqMin.peek())/2.0;
        else return (double)pqMin.peek();
    }
}
