package head67;

import java.util.*;
import java.util.stream.Stream;

import util.Swap;

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
			res.add(String.valueOf(cs));//ע��Arrays.toString()�Ǵ����ŵģ�value����
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
		for(String s : new Permutation().permutation("abc")){
			System.out.println(s);
		}
	}

	public String[] permutation(String s) {
		List<String> res = new ArrayList<>();
		char[] cs = s.toCharArray();
		permutation(cs, 0, res);
		String[] ans = new String[res.size()];
		return res.toArray(ans);
	}

	void permutation(char[] cs, int l, List<String> res) {
		if(l >= cs.length) {
			res.add(new String(cs));
			return;
		}
		Set<Character> set = new HashSet<>();
		for(int i = l; i < cs.length; i++) {
			if(!set.contains(cs[i])) {
				swap(cs, i, l);
				//note. l+1 not i+1
				permutation(cs, l+1, res);
				swap(cs, i, l);
				set.add(cs[i]);
			}
		}
 	}

	void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

}

