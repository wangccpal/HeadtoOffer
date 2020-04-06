package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * leetcode 146
 */
public class LRUCache {
    Map<Integer, Integer> map;
    LinkedHashSet<Integer> list;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        list = new LinkedHashSet();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.add(key);
            return map.get(key);
        } else return -1;
    }

    public void put(int key, int value) {
        if (cap == 0) return;
        if (map.containsKey(key)) {
            map.put(key, value);
            list.remove(key);
            list.add(key);
        } else {
            if (cap == map.size()) {
                Integer old = list.iterator().next();
                list.remove(old);
                map.remove(old);
            }
            map.put(key, value);
            list.add(key);
        }
    }
}
