package algorithm.sort;

import java.util.Arrays;

import static util.Swap.swap;

public class QuikSortImpl implements SortInterFace2020{
    @Override
    public void sort(int[] num) {
        quick(num, 0, num.length);

    }

    private void quick(int[] num, int i, int length) {
        if(i == length) return;
        int mid = select(num, i, length);
        quick(num, i, mid);
        quick(num, mid + 1, length);
    }

    private int select(int[] num, int i, int length) {
        int p = length - 1;
        int l = i-1;
        int r = length - 1;
        while(true) {
            while(num[++l] < num[p]);
            while(num[--r] > num[p]) if (r == 0) break;
            if (l >= r) break;
            swap(num, l, r);
        }
        swap(num, p, l);
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 4, 3, 2, 3, 1};
        new QuikSortImpl().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
