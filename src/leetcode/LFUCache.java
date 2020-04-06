package leetcode;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * leetcode 460
 */
public class LFUCache {
    //用linkedHashSet而不用LinkedList是因为set插入删除是o(1)的, 如果要使用链表的话需要node里保存当前node的前序与后序节点来实现o(1)的插入删除。
    Map<Integer, Node> cache;
    Map<Integer, LinkedHashSet<Node>> freqMap;
    int min;
    int cap;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        min = 0;
        cap = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (null == node) {
            return -1;
        } else {
            LinkedHashSet<Node> list = freqMap.get(node.freq);
            list.remove(node);
            if (node.freq == min && list.isEmpty()) {
                min = node.freq + 1;
            }
            node.freq++;
            LinkedHashSet<Node> listNew = freqMap.get(node.freq);
            if (null == listNew) {
                listNew = new LinkedHashSet<>();
                freqMap.put(node.freq, listNew);
            }
            listNew.add(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        if (cap == 0) return;
        Node node1 = cache.get(key);
        if (node1 != null) {
            LinkedHashSet<Node> list = freqMap.get(node1.freq);
            list.remove(node1);
            node1.value = value;
            if (node1.freq == min && list.isEmpty()) {
                min = node1.freq + 1;
            }
            node1.freq++;
            LinkedHashSet<Node> nodes = freqMap.get(node1.freq);
            if (nodes == null) {
                nodes = new LinkedHashSet<>();
                freqMap.put(node1.freq, nodes);
            }
            nodes.add(node1);
        } else {
            if (cache.size() == cap) {
                LinkedHashSet<Node> nodes = freqMap.get(min);
                Node nodeRemoved = nodes.iterator().next();
                nodes.remove(nodeRemoved);
                cache.remove(nodeRemoved.key);
            }
            LinkedHashSet<Node> nodes = freqMap.get(1);
            if (nodes == null) {
                nodes = new LinkedHashSet<>();
                freqMap.put(1, nodes);
            }
            Node e = new Node(key, value, 1);
            nodes.add(e);
            cache.put(key, e);
            min = 1;
        }
    }

    class Node {
        public Node(int key,int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
        int key;
        int value;
        int freq;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        System.out.println(cache);
        cache.put(2,2);
        System.out.println(cache);

        cache.get(1);
        System.out.println(cache);

        cache.put(3,3);
        System.out.println(cache);

        cache.get(2);
        System.out.println(cache);

        cache.get(3);
        System.out.println(cache);

        cache.put(4,4);
        System.out.println(cache);

        cache.get(1);
        System.out.println(cache);

        cache.get(3);
        System.out.println(cache);

        cache.get(4);
        System.out.println(cache);
        cache.put(3,1);
        System.out.println(cache);
        cache.put(2,1);
        System.out.println(cache);



        cache.put(2,2);
        System.out.println(cache);

        cache.put(4,4);
        System.out.println(cache);
        cache.get(2);
        System.out.println(cache);
    }
}
