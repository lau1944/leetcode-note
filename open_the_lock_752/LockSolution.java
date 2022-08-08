package open_the_lock_752;

import java.util.*;

public class LockSolution {

    public static void main(String[] args) {
        final String[] deads = new String[] { "0201", "0101", "0102", "1212", "2002" };
        final String target = "0202";

        LockSolution lockSolution = new LockSolution();
        int result = lockSolution.openLock(deads, target);
        System.out.println(result);
    }

    /**
     * 使用bfs遍历
     * 
     * @param deadends
     * @param target
     * @return 转动次数
     */
    public int openLock(String[] deadends, String target) {
        if (target == "0000")
            return 0;
        Set<String> deadSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (final String deads : deadends) {
            deadSet.add(deads);
        }

        if (deadSet.contains("0000")) {
            return -1;
        }

        Queue<String> buffer = new ArrayDeque<>();
        int step = 0;

        buffer.add("0000");
        visited.add("0000");

        while (!buffer.isEmpty()) {
            ++step;
            int size = buffer.size();
            for (int i = 0; i < size; ++i) {
                String current = buffer.poll();
                // up and down
                char[] curArr = current.toCharArray();
                for (int j = 0; j < curArr.length; ++j) {
                    char cur = curArr[j];
                    curArr[j] = up(cur);
                    // count up
                    String upString = new String(curArr);
                    if (target.equals(upString)) {
                        return step;
                    }
                    if (!visited.contains(upString) && !deadSet.contains(upString)) {
                        buffer.add(upString);
                        visited.add(upString);
                    }
                    // count down
                    curArr[j] = down(cur);
                    String downString = new String(curArr);
                    if (target.equals(downString)) {
                        return step;
                    }
                    if (!visited.contains(downString) && !deadSet.contains(downString)) {
                        buffer.add(downString);
                        visited.add(downString);
                    }
                    curArr[j] = cur;
                }
            }
        }

        return -1;
    }

    private char up(char target) {
        return target == '9' ? '0' : (char) (target + 1);
    }

    private char down(char target) {
        return target == '0' ? '9' : (char) (target - 1);
    }
}
