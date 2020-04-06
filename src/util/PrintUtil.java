package util;

/**
 * @author Wangchenge
 * @date 2019-02-28
 **/
public class PrintUtil {
    public static <T> String printMatrix(T[][] m) {
        StringBuilder sb =new StringBuilder();
        for (T[] n:m) {
            for (T x:n) {
                sb.append(x + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String printMatrix(int[][] m) {
        StringBuilder sb =new StringBuilder();
        for (int[] n:m) {
            for (int x:n) {
                sb.append(x + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String printMatrix(boolean[][] m) {
        StringBuilder sb =new StringBuilder();
        for (boolean[] n:m) {
            for (boolean x:n) {
                sb.append(x + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[][] input = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        final String s = printMatrix(input);
        System.out.println(s);
    }
}
