package leetcode;

import java.util.Stack;

/**
 * Created by CC on 2017/3/8.
 */
public class BasicCalculator {
    public static int calculate(String s) {
        Stack<Integer> num= new Stack<Integer>();
        char sign = '+';
        int res = 0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c==' '&& i!=s.length()-1) continue;//除了最后一个字符是空格的情况都跳过空格
            if(c>='0' && c <='9'){//对连续数字的判断，如果字符串最后一个是数字就不能继续continue了；
                res = res*10 + c-'0';
               if(i!=s.length()-1) continue;
            }
            //可以合并上述两条判断为如下
//            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){//如果到最后一个字符就开始运算，或者遇到一个操作符就开始运算
            if (sign=='+') {//注意判断的是sign而不是当前的c，是遇到下一个运算符开始算上一个
                num.push(res);
                res = 0;

            }
            else if(sign=='-') {
                num.push(-res);
                res = 0;
            }
            else if(sign=='*') {
                num.push(num.pop()*res);
                res = 0;
            }
            else if(sign=='/') {
                num.push(num.pop()/res);
                res =0;
            }

            sign = c; //如果是数字或空格直接continue了，所以这里一定是运算符
        }
        int sum =0;
        while(!num.isEmpty()) {
            sum+=num.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 3+5 / 2 "));
    }
}
