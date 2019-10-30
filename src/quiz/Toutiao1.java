package quiz;

import java.util.Arrays;
import java.util.Scanner;
public class Toutiao1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int [] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        Arrays.sort(arr1);
        for (int a : arr2){
            if(Arrays.binarySearch(arr1,a)>=0){
                System.out.print(a+" ");
            }
        }
    }

}