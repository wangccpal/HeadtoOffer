package com.company.LeetCode;

import java.util.Stack;

/**
 * Created by CC on 2017/3/8.
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculatorHard {
    public static int calculate(String s) {
        Stack<Integer> stack= new Stack<Integer>();//保存括号（外的数
        int num = 0;
        int sign =1;//代表加减号
        int res = 0;//保存连+的结果
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num*10+c-'0';
            }
            if(c=='+')  {
//                stack.push(sign*res);//连加直接做加法而不是压栈,注意是做上一个操作符
                res = res +num*sign;
                sign=1;
                num = 0;
            }
            else if(c=='-')//注意这时候的num，如果运算符前是)则num就是0；
            {
                res = res +num*sign;
                sign=-1;
                num = 0;
            }
            else if(c==')') {
                res = res + num * sign;//括号内的结果
                sign = stack.pop();
                res = sign*res  + stack.pop();//分别是括号内连加的结果，，最后一个数字，括号前的结果
                num = 0;
                sign = 1;
            }
            else if (c=='('){//保存括号前的结果到stack里
                stack.push(res);
                stack.push(sign);//注意是括号前的sign是对括号后的数起效
                sign = 1;
                res = 0;
            }
        }
//        int sum = 0;
//        for (int i : stack){
//            sum =sum +i;
//        }
//        return sum;
        return res+sign*num;//别忘了加最后一个数字
    }
    public static void main(String[] args) {
        System.out.println(calculate("1-(5)" ));
    }
}
