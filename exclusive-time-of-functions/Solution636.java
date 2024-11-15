// https://leetcode.com/problems/exclusive-time-of-functions/

import java.util.*;

class Solution636 {

    // T: O(n), S: O(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        var result = new int[n];
        var stack = new Stack<Integer>();
        int prevTime = 0;

        for (var entry : logs) {
            var arr = entry.split(":");
            int id = Integer.parseInt(arr[0]);
            var type = arr[1];
            int time = Integer.parseInt(arr[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    int prevId = stack.peek();
                    result[prevId] += time - prevTime;
                }
                stack.push(id);
                prevTime = time;
            } else {
                int prevId = stack.pop();
                result[prevId] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution636();
        var logs1 = List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        var logs2 = List.of("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
        var logs3 = List.of("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7");
        System.out.println(Arrays.toString(sol.exclusiveTime(2, logs1))); // [3,4]
        System.out.println(Arrays.toString(sol.exclusiveTime(1, logs2))); // [8]
        System.out.println(Arrays.toString(sol.exclusiveTime(2, logs3))); // [7,1]
    }

}
