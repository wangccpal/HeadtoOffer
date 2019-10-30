package leetcode;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Wangchenge
 * @date 2019-08-19
 **/
public class LT715 {
    class RangeModule {
            TreeSet<Interval> treeSet;
        public RangeModule() {
            treeSet = new TreeSet();
        }

        public void addRange(int left, int right) {
            final Iterator<Interval> iterator = treeSet.tailSet(new Interval(0, left - 1)).iterator();
            while (iterator.hasNext()) {
                Interval next = iterator.next();
                if (next.left > right) break;
                left = Math.min(left, next.left);
                right = Math.max(right, next.right);
                iterator.remove();
            }
            treeSet.add(new Interval(left, right));
        }

        public boolean queryRange(int left, int right) {
            final Interval higher = treeSet.higher(new Interval(0, left - 1));
            return higher != null && higher.left <= left && higher.right >= right;
        }

        public void removeRange(int left, int right) {
            final Iterator<Interval> iterator = treeSet.tailSet(new Interval(0, left - 1)).iterator();
            List<Interval> list = new ArrayList<>();
            while (iterator.hasNext()) {
                Interval next = iterator.next();
                if (next.left > right) break;
                if (next.left < left) list.add(new Interval(next.left, left));
                if (next.right > right) list.add(new Interval(right, next.right));
                iterator.remove();
            }
            for (Interval i : list) treeSet.add(i);
        }
    }

    private class Interval implements Comparable<Interval> {
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override public int compareTo(Interval o) {
            return o.right == this.right ? this.left - o.left : this.right - o.right;
        }
    }

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
}
