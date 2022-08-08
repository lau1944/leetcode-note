package open_the_lock_752;

import java.util.*;

public class LockSolution {

    public static void main(String[] args) {
        final String[] deads = new String[] { "0201", "0101", "0102", "1212", "2002" };
        final String target = "0202";

        LockSolution lockSolution = new LockSolution();
        int result = lockSolution.openDoubleBfsLock(deads, target);
        //int result = lockSolution.openBfsLock(deads, target);
        System.out.println(result);
    }

    /**
     * 使用bfs遍历
     * 
     * @param deadends
     * @param target
     * @return 转动次数
     */
    public int openBfsLock(String[] deadends, String target) {
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
            int size = buffer.size();
            for (int i = 0; i < size; ++i) {
                String current = buffer.poll();

                if (target.equals(current)) {
                    return step;
                }

                // up and down
                char[] curArr = current.toCharArray();
                for (int j = 0; j < curArr.length; ++j) {
                    char cur = curArr[j];
                    curArr[j] = up(cur);
                    // count up
                    String upString = new String(curArr);
                    if (!visited.contains(upString) && !deadSet.contains(upString)) {
                        buffer.add(upString);
                        visited.add(upString);
                    }
                    // count down
                    curArr[j] = down(cur);
                    String downString = new String(curArr);
                    if (!visited.contains(downString) && !deadSet.contains(downString)) {
                        buffer.add(downString);
                        visited.add(downString);
                    }
                    curArr[j] = cur;
                }
            }
            ++step;
        }

        return -1;
    }

    /**
     * 双向bfs遍历
     * 
     * @param deaStrings
     * @param target
     * @return
     */
    public int openDoubleBfsLock(String[] deadends, String target) {
        if (target == "0000")
            return 0;
        Set<String> visited = new HashSet<>();
        for (String dead : deadends) {
            visited.add(dead);
        }

        if (visited.contains("0000")) {
            return -1;
        }

        int step = 0;
        Set<String> q1 = new HashSet<>();
        q1.add("0000");
        Set<String> q2 = new HashSet<>();
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String cur : q1) {
                if (visited.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }

                visited.add(cur);

                char[] charArr = cur.toCharArray();
                for (int i = 0; i < cur.length(); ++i) {
                    char curCh = charArr[i];
                    charArr[i] = up(curCh);
                    String curStr = new String(charArr);
                    if (!visited.contains(curStr)) {
                        temp.add(curStr);
                    }
                    charArr[i] = down(curCh);
                    curStr = new String(charArr);
                    if (!visited.contains(curStr)) {
                        temp.add(curStr);
                    }
                    charArr[i] = curCh;
                }
            }
            ++step;
            q1 = q2;
            q2 = temp;
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
