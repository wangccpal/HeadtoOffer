package javapuzzle;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Before {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set set = new TreeSet();
		set.add("2");
		set.add(3);
		set.add("1");
		Iterator ot = set.iterator();
		while(ot.hasNext()) {
			System.out.println(ot.next()+" ");
		}
	}

}
