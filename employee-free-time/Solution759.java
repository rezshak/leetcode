// https://leetcode.com/problems/employee-free-time/

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

class Solution759 {

    // T: O(nlogn), S: O(n)
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        var allIntervals = new ArrayList<Interval>();

        for (var empSchedule : schedule) {
            allIntervals.addAll(empSchedule);
        }

        Collections.sort(allIntervals, ((a, b) -> a.start - b.start));

        var result = new ArrayList<Interval>();
        int prevEnd = allIntervals.get(0).end;

        for (int i = 1; i < allIntervals.size(); i++) {
            var curr = allIntervals.get(i);
            if (curr.start > prevEnd) {
                result.add(new Interval(prevEnd, curr.start));
            }
            prevEnd = Math.max(prevEnd, curr.end);
        }

        return result;
    }

    // T: O(nm(lognm)), S: O(n)
    public List<Interval> employeeFreeTimePq(List<List<Interval>> schedule) {
        var res = new ArrayList<Interval>();
        var pq = new PriorityQueue<Interval>((a, b) -> (a.start - b.start));

        for (var empSchedule : schedule) {
            for (var interval : empSchedule) {
                pq.offer(interval);
            }
        }

        var curr = pq.poll();

        while (!pq.isEmpty()) {
            var next = pq.poll();
            if (curr.end >= next.start) {
                next.end = Math.max(curr.end, next.end);
            } else {
                res.add(new Interval(curr.end, next.start));
            }
            curr = next;
        }

        return res;
    }

    public static void main(String[] args) {
        var sol = new Solution759();
        var schedule1 = new ArrayList<List<Interval>>();
        schedule1.add(Arrays.asList(new Interval(1, 2), new Interval(5, 6)));
        schedule1.add(Arrays.asList(new Interval(1, 3)));
        schedule1.add(Arrays.asList(new Interval(4, 10)));
        System.out.println(sol.employeeFreeTime(schedule1)); // [[3,4]]
        System.out.println(sol.employeeFreeTimePq(schedule1)); // [[3,4]]
        var schedule2 = new ArrayList<List<Interval>>();
        schedule2.add(Arrays.asList(new Interval(1, 3), new Interval(6, 7)));
        schedule2.add(Arrays.asList(new Interval(2, 4)));
        schedule2.add(Arrays.asList(new Interval(2, 5), new Interval(9, 12)));
        System.out.println(sol.employeeFreeTime(schedule2)); // [[5,6],[7,9]]
        System.out.println(sol.employeeFreeTimePq(schedule2)); // [[5,6],[7,9]]
    }

}
