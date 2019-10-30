package leetcode;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Stack;

/**
 * Created by CC on 2017/3/7.
 */
public class HappyNum {
    public static int calculate(String s) {
        Stack<Integer> num= new Stack<Integer>();
        Stack<Character> op= new Stack<Character>();
        char[] cl = s.trim().toCharArray();
        for(int i=0;i<cl.length;i++){
            char c = cl[i];
            if(c=='+')  op.push(c);
            else if(c=='-') op.push(c);
            else if(c==')') {
                if(op.isEmpty()) return num.pop();
                char opr = op.pop();
                int val = num.pop();
                if(c=='+')  num.push(num.pop()+val);
                else if(c=='-') num.push(num.pop()-val);
            }
            else {
                int temp = 0;
                while(i<cl.length&&cl[i]<='9'&&cl[i]>='0'){
                    temp = temp*10+cl[i]-'0';
                    i++;
                }
                num.push(temp);
            }
        }
        while(!op.isEmpty()) {
            char opr = op.pop();
            int val = num.pop();
            if(val=='+')  num.push(num.pop()+val);
            else if(val=='-') num.push(num.pop()-val);
        }
        return num.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculate("(1+8)"));
    }
}
