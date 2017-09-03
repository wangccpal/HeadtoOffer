import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Poin24 {
	static List<double[]> num = new ArrayList<double[]>();
	static List<String> opt = new ArrayList<String>();
	static StringBuffer sb = new StringBuffer();

/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static String[] Check24(double[][] data, int n) {//n表示有几张牌
		String [] rst = new String[data.length];
		if(opt.isEmpty()) getOptAllOrder("+-*/", n-1);
		int i = 0;
		for(double[] d:data) {
			rst[i] = compute(d); 
			i++;
		}
		return rst;
    }
    
    private static String compute(double[] d) {
    	num.clear();
    	getNumAllOrder(d,0);
    	Stack<Double> snum = null;
    	Stack<Character> sopt = null;
    	for (double[] in : num) {
    		snum = new Stack<Double>();
			for (double e : in) {
				snum.push(e);
			}
			for (String op : opt) {
				sopt = new Stack<Character>();
				for(char c : op.toCharArray()) {
					sopt.push(c);
				}
				Stack<Double> temp = (Stack<Double>) snum.clone();
				while(snum.size()!=1&& !sopt.isEmpty()) {
					Double n1 = temp.pop();
					Double n2 = temp.pop();
					Character p = sopt.pop();
					if(p.equals('+')) temp.push((n1+n2));
					else if(p.equals('-')) temp.push((n1-n2));
					else if(p.equals('*')) temp.push((n1*n2));
					else if(p.equals('/')) {
						if(n2==0) break;
						temp.push((n1/n2));
					}
				}
				if(temp.pop()==24)
					return "true";
//				else System.out.println(snum.peek());
			}
		}
		return "false";
	}

    /**
     * 计算输入数字的全排列
     * @param input 输入数字
     * @param n 输入0开始计算
     * @return
     */
    private static List<double[]> getNumAllOrder(double[] input,int n){
    	
    	if(n==input.length) {
    		System.out.println(Arrays.toString(input));
    		num.add(input.clone());
    	}
    	for(int i = n;i<input.length;i++) {
    		if(input[i]==input[n] && i>n) continue;
			swap(input,i,n);
			getNumAllOrder(input,n+1);
			swap(input,i,n);
    	}
    	return num;
    }
    
    private static void getOptAllOrder(String input,int n){
    	for (char c : input.toCharArray()) {
			if(sb.length()==n) {
				System.out.println(sb.toString());
				opt.add(sb.toString());
				return ;
			}
			sb.append(c);
			getOptAllOrder(input,n);
			sb.deleteCharAt(sb.length()-1);
		}
    	return;
    }
    	
private static void swap(double[] input, int i, int j) {
		if(i==j) return;
		double temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;
            
        int _data_rows = 0;
        int _data_cols = 0;
        _data_rows = Integer.parseInt(in.nextLine().trim());
        _data_cols = Integer.parseInt(in.nextLine().trim());
        
        double[][] _data = new double[_data_rows][_data_cols];
        for(int _data_i=0; _data_i<_data_rows; _data_i++) {
            for(int _data_j=0; _data_j<_data_cols; _data_j++) {
                _data[_data_i][_data_j] = in.nextDouble();
                
            }
        }   

        if(in.hasNextLine()) {
          in.nextLine();
        }
  
        res = Check24(_data,_data_cols);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
