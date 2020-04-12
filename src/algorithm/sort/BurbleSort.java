package algorithm.sort;

import java.util.Arrays;

import static util.Swap.swap;

public class BurbleSort implements SortInterFace2020{
    @Override
    public void sort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] > num[j+1]) swap(num, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 4, 3, 2, 3, 1};
        new BurbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
