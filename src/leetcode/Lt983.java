package leetcode;

import java.util.*;

/**
 * @author Wangchenge
 * @date 2019-07-04
 **/
public class Lt983 {
    Map<String, PriorityQueue<Integer>> timeMap;
    Map<String, String> valMap;
    public Lt983() {
        timeMap = new HashMap<>();
        valMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (key == null) return;
        PriorityQueue<Integer> integers = timeMap.get(key);
        if (null == integers) {
            integers = new PriorityQueue<>(Comparator.reverseOrder());
            timeMap.put(key,integers);
        }
        integers.offer(timestamp);
        valMap.put(key+timestamp, value);
    }

    public String get(String key, int timestamp) {
        PriorityQueue<Integer> integers = timeMap.get(key);
        if (integers == null) return "";
        final Iterator<Integer> iterator = integers.iterator();
        int r = -1;
        while (iterator.hasNext()) {
            final Integer next = iterator.next();
            if (next <= timestamp) {
                r = next;break;
            }
        }
        if (r == -1) return "";
        return valMap.get(key+r);
    }
}
