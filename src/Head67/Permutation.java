package Head67;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import tools.Swap;

public class Permutation {
	static ArrayList<String> res = new ArrayList();

	public static ArrayList<String> Permutation(String str) {
		recall(str.toCharArray(), 0);
		Collections.sort(res);
		return res;
	}

	private static void recall(char[] cs, int start) {
		if (start == cs.length - 1 && !res.contains(String.valueOf(cs)))
//			res.add(Arrays.toString(cs));
			res.add(String.valueOf(cs));//注意Arrays.toString()是带逗号的，value不带
		else {
			for (int i = start; i < cs.length; i++) {
//				if(i!=start&&cs[i]==cs[start]) break;
//				if(i==start || cs[i]!=cs[start]){
				Swap.swap(cs, start, i);
				recall(cs, start+1);
				Swap.swap(cs, start, i);
//				}
			}
		}
	}

	public static void main(String[] args) {
		for(String s : Permutation("aaaaaaa")){
			System.out.println(s.toString());
		}
	}

}

