package head67;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MoreThanHalfNum {
	public static int MoreThanHalfNum(int[] array) {
		Map<Integer, Integer> tree = new TreeMap<Integer, Integer>();
		for (int i : array) {
			if (tree.containsKey(i))
				tree.put(i, tree.get(i) + 1);
			else
				tree.put(i, 1);
		}
		Iterator it1 = tree.entrySet().iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}

		Iterator it = tree.keySet().iterator();
		int max=(int) it.next(), v = 0;
		while (it.hasNext()) {
			v = (int) it.next();
			if (tree.get(v) > tree.get(max))
				max = v;
//			System.out.println(v);
		}
		if (tree.get(max) >= array.length / 2){
			System.out.println(max);
			return max;
		} else return 0;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 2, 1, 2, 4, 3 };
		MoreThanHalfNum(a);
	}
}