package leetcode;

import java.util.*;

/**
 * @author Wangchenge
 * @date 2019-08-14
 **/
public class LT381 {
    static class RandomizedCollection {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Set<Integer>> locMap = new HashMap<>();
        Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {

        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean res = !locMap.containsKey(val);
            Set<Integer> set = locMap.get(val);
            if (set == null) {
                set = new HashSet<Integer>();
            }
            set.add(list.size());
            list.add(val);
            locMap.put(val, set);
            return res;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!locMap.containsKey(val)) return false;
            final Set<Integer> set = locMap.get(val);
            final Integer loc = set.iterator().next();
            set.remove(loc);
            if (loc != list.size() - 1) {
                final Integer end = list.get(list.size() - 1);
                list.set(loc, end);
                locMap.get(end).add(loc);
                locMap.get(end).remove(list.size() - 1);
            }
            list.remove(list.size() - 1);
            if (set.size() == 0) locMap.remove(val);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        final RandomizedCollection collection = new RandomizedCollection();
        collection.insert(0);
        collection.remove(0);
        collection.insert(-1);
        collection.remove(0);
        collection.getRandom();
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
