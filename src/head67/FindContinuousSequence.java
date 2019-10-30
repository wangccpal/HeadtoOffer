package head67;

import java.util.ArrayList;

/*
 * (a1+an)*(an-a1+1)/2=s; **> k*l=2s;**>a1+an = k;an-a1+1=l;****>an=(k+l-1)/2;a1=(k-l+1)/2;
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(sum<3) return res;
        int l = (int)Math.sqrt(sum*2);
        for(int i=l;i>=2;i--){
        	if(sum*2%i==0){
        		int k = sum*2/i;
        		if((k%2==0&&i%2!=0) || (i%2==0&&k%2!=0) ){
        			int a1 = (k-i+1)/2;
        			int an = (k+i-1)/2;
        			ArrayList<Integer> list = new ArrayList<Integer>();
        			for(int j = a1;j<=an;j++){
        				list.add(j);
        			}
    				res.add(list);
        		}
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		System.out.println(new FindContinuousSequence().FindContinuousSequence(15));
	}

}
