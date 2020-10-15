package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LT3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] sc = s.toCharArray();
        Set<Character> set = new HashSet();
        int res = 0;
        int r = 0;
        for(int l = 0; l < sc.length; l++) {
            if(l > 0) set.remove(sc[l-1]);
            while(r < sc.length && !set.contains(sc[r])) {
                set.add(sc[r]);
                r++;
            }
            int cur = r - l;
            if(cur > res) res = cur;
            if(r == sc.length) return res;
        }
        return res;
    }

    public static void main(String[] args) {
        new LT3().lengthOfLongestSubstring("pwwkew");
    }
}
