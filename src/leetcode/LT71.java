package leetcode;

import java.util.Stack;

/**
 * simply path
 * @author Wangchenge
 * @date 2019-06-19
 **/
public class LT71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        final String[] split = path.split("/");
        for (String s : split) {
            switch (s) {
                case " ": break;
                case "": break;
                case ".": break;
                case "..": if (!stack.isEmpty()) stack.pop(); break;
                default: stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        if (sb.length() == 0) return "/";
        return sb.toString();
    }

    public static void main(String[] args) {
        final String s = new LT71().simplifyPath("/../");
        System.out.println(s);
    }
}
