package javapuzzle;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StackTest {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().forEach(stack::push);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
