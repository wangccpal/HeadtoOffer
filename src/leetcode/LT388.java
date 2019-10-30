package leetcode;

import java.util.Stack;

/**
 * LeetCode388
 * https://leetcode.com/problems/longest-absolute-file-path/
 * @author Wangchenge
 * @date 2019-03-18
 **/
public class LT388 {
    //eg: "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
    public int lengthLongestPath(String input) {
        final String[] ss = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for (String s : ss) {
            int level = s.lastIndexOf("\t") + 1; //num of "\t"
            final int len = s.length() - level + 1; // /teg -> eg/
            while ((level + 1) < stack.size()) stack.pop();//find cur parent, note first is 0
            stack.push(len + stack.peek());
            if (s.contains(".")) {
                max = Math.max(max, stack.peek() - 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LT388().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
