package leetcode;

/**
 * LeetCode 488
 * https://leetcode.com/problems/zuma-game/
 * @author Wangchenge
 * @date 2019-03-18
 **/
public class LT488 {
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for(char c : hand.toCharArray()) {
            handCount[c - 'A'] += 1;
        }
        int res = bp(board + "@", handCount);
        return res == 6 ? -1 : res;
    }

    private int bp(String board, int[] handCount) {
        int res = 6;
        board = remove333(board);
        if (board.equals("@")) return 0;
        for (int i = 0, j = 1; j < board.length(); j++ ) {
            final char c = board.charAt(i);
            if (c == board.charAt(j)) continue;
            else {
                final int need = 3 - (j - i);
                if (handCount[c - 'A'] >= need) {
                    handCount[c - 'A'] -= need;
                    res = Math.min(res, need + bp(board.substring(0,i) + board.substring(j), handCount));
                    handCount[c - 'A'] += need;
                }
                i = j;
            }
        }
        return res;
    }

    private String remove333(String board) {
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(i) == board.charAt(j)) continue;
            if (j - i >= 3) return remove333(board.substring(0,i) + board.substring(j));
            i = j;
        }
        return board;
    }

    public static void main(String[] args) {
//        System.out.println(new LT488().findMinStep("WRRBBW","RB"));
//        System.out.println(new LT488().findMinStep("R","RR"));
        System.out.println(new LT488().findMinStep("YYGGRRYYGGYYGY","RGG"));
    }
}
