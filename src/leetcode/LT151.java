package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class LT151 {
    public String reverseWords(String s) {
        String[] s1 = s.split(" +");
        Collections.reverse(Arrays.asList(s1));
        return String.join(" ",s1);
    }

    public static void main(String[] args) {
        String the_sky_is_blue = new LT151().reverseWords("  hello world!  ");
        System.out.println(the_sky_is_blue);
    }
}
