# https://leetcode.com/problems/merge-intervals/

from typing import List


class Solution56:

    # T: O(nlogn), S: O(n)
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        merged = [intervals[0]]
        for i in range(1, len(intervals)):
            prev_interval = merged[-1]
            curr_interval = intervals[i]
            if curr_interval[0] <= prev_interval[1]:
                prev_interval[1] = max(prev_interval[1], curr_interval[1])
            else:
                merged.append(curr_interval)
        return merged


def main():
    sol = Solution56()
    intervals1 = [[1, 3], [2, 6], [8, 10], [15, 18]]
    intervals2 = [[1, 4], [4, 5]]
    print(sol.merge(intervals1))  # [[1, 6], [8, 10], [15, 18]]
    print(sol.merge(intervals2))  # [[1, 5]]


if __name__ == "__main__":
    main()
