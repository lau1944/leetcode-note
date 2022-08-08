package sliding_puzzle_773;

import java.util.*;

public class Solution {
    private static final String target = "123450";

    public static final void main(String[] args) {
        int[][] board = new int[][] { { 4, 1, 2 }, { 5, 0, 3} };
        Solution solution = new Solution();
        int result = solution.slidingPuzzle(board);
        System.out.println(result);
    }

    /**·
     * 使用bfs存放状态
     * 
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        Queue<String> buf = new ArrayDeque<>();

        int step = 0;
        String start = toString(board);
        buf.add(start);

        while (!buf.isEmpty()) {
            int size = buf.size();
            for (int i = 0; i < size; ++i) {
                String cur = buf.poll();

                if (visited.contains(cur)) {
                    continue;
                }
                
                if (target.equals(cur)) {
                    return step;
                }

                visited.add(cur);

                char[] curArr = cur.toCharArray();
                for (int j = 0; j < cur.length(); ++j) {
                    if (curArr[j] != '0') {
                        continue;
                    }

                    // go left
                    if (j % 3 - 1 >= 0) {
                        String next = swap(curArr, j, j - 1);
                        buf.add(next);
                    }
                    // go right
                    if (j % 3 + 1 < 3) {
                        String next = swap(curArr, j, j + 1);
                        buf.add(next);
                    }
                    // go top
                    if (j - 3 >= 0) {
                        String next = swap(curArr, j, j - 3);
                        buf.add(next);
                    }
                    // go down
                    if (j + 3 < cur.length()) {
                        String next = swap(curArr, j, j + 3);
                        buf.add(next);
                    }
                }
            }
            ++step;
        }
        return -1;
    }

    private String swap(char[] arr, int ori, int tar) {
        char temp = arr[ori];
        arr[ori] = arr[tar];
        arr[tar] = temp;
        String swaped = new String(arr);
        arr[tar] = arr[ori];
        arr[ori] = temp;
        return  swaped;
    }

    private String toString(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                builder.append(board[i][j]);
            }
        }
        return builder.toString();
    }
}
