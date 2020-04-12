package algorithm.sort;

import java.util.Arrays;

public class MergeSortImpl implements SortInterFace2020 {
    int[] numTemp;
    @Override
    public void sort(int[] num) {
        numTemp = new int[num.length];
        sort(num, 0, num.length);
    }

    private void sort(int[] num, int i, int length) {
        int mid = (i + length) / 2;
        if (mid == i) return;
        sort(num, i, mid);
        sort(num, mid, length);
        merge(num, i, mid, length);
    }

    private void merge(int[] num, int i, int mid, int length) {
        int l = i;
        int r = mid;

        for (int j = i; j < length; j++) {
            numTemp[j] = num[j];
        }
        for (int j = i; j < length; j++) {
            if (l == mid) num[j] = numTemp[r++];
            else if (r == length) num[j] = numTemp[l++];
            else {
                if (numTemp[l] < numTemp[r]) num[j] = numTemp[l++];
                else num[j] = numTemp[r++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {333, 5, 4, 4, 222, 3, 2, 3, 1, 555};
        new MergeSortImpl().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
