package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CC on 2017/3/22.
 * TimeComplexity
 * T(n) = T(n-1)+T(n-2)+...+T(1)
 * T(n+1) = T(n)+ T(n-1) +...+T(1) = 2T(n);
 * T(n) = 2T(n-1) = 4T(n-2) = 2^n;
 */
public class L131PalindromePart {
    List<List<String>> resultLst;
    ArrayList<String> currLst;
    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack2(s,0);
        return resultLst;
    }
    public void backTrack(String s, int l){
        if(currLst.size()>0 //the initial str could be palindrome
                && l>=s.length()){
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);//精髓，注意这时候要删除最后一个字母时下一个已经把结果存了
            }
        }
    }
    //cleaner version
    public void backTrack2(String s ,int len ){
        if( len==s.length()) resultLst.add(new ArrayList(currLst));//注意这个和clone（）相似

        // if(s.length()==1) tmp.add s;
        for(int i = len; i < s.length();i++) {
            if(isPalindrome(s,len,i)){
                    currLst.add(s.substring(len,i+1));
                    backTrack2(s,i+1);
                    currLst.remove(currLst.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }

    public static void main(String[] args) {
        L131PalindromePart ll = new L131PalindromePart() ;
        ll.partition("aab");
        System.out.println(ll.resultLst);

    }
}
