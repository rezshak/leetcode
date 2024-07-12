// https://leetcode.com/problems/number-of-recent-calls/

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter933 {

    private static final int WIN = 3000;
    private Queue<Integer> reqs;

    public RecentCounter933() {
        reqs = new LinkedList<>();
    }

    // T: O(n), S: O(1)
    int ping(int t) {
        reqs.add(t);
        while (reqs.peek() < t - WIN) {
            reqs.poll();
        }
        return reqs.size();
    }

    public static void main(String[] args) {
        var rc = new RecentCounter933();
        System.out.println(rc.ping(1)); // 1
        System.out.println(rc.ping(100)); // 2
        System.out.println(rc.ping(3001)); // 3
        System.out.println(rc.ping(3002)); // 3
    }

}
