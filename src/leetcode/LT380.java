package leetcode;

import java.util.*;

/**
 * @author Wangchenge
 * @date 2019-08-14
 **/
public class LT380 {
    class RandomizedSet {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> locMap = new HashMap<>();
        Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (locMap.containsKey(val)) return false;
            locMap.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!locMap.containsKey(val)) return false;
            final Integer loc = locMap.get(val);
            final Integer end = list.get(list.size() - 1);
            list.set(loc, end);
            locMap.put(end, loc);
            list.remove(list.size() - 1);
            locMap.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
