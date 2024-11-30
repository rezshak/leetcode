# https://leetcode.com/problems/non-overlapping-intervals/

from typing import List


class Solution435:

    # T: O(nlogn), S: O(1)
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: x[1])
        n = len(intervals)
        non_overlapping_count = 1
        prev_end = intervals[0][1]

        for i in range(1, n):
            curr_start = intervals[i][0]
            if curr_start >= prev_end:
                non_overlapping_count += 1
                prev_end = intervals[i][1]

        return n - non_overlapping_count


def main() -> None:
    sol = Solution435()
    intervals1 = [[1, 2], [2, 3], [3, 4], [1, 3]]
    intervals2 = [[1, 2], [1, 2], [1, 2]]
    intervals3 = [[1, 100], [11, 22], [1, 11], [2, 12]]
    print(sol.eraseOverlapIntervals(intervals1))  # 1
    print(sol.eraseOverlapIntervals(intervals2))  # 2
    print(sol.eraseOverlapIntervals(intervals3))  # 2


if __name__ == "__main__":
    main()
