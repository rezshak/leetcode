# https://leetcode.com/problems/meeting-rooms/

from typing import List


class Solution252:

    # T: O(nlogn), S: O(1)
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        intervals.sort(key=lambda x: x[0])
        for i in range(1, len(intervals)):
            prev = intervals[i - 1]
            curr = intervals[i]
            if curr[0] < prev[1]:
                return False

        return True


def main() -> None:
    sol = Solution252()
    intervals1 = [[0, 30], [5, 10], [15, 20]]
    intervals2 = [[7, 10], [2, 4]]
    intervals3 = [[0, 5], [5, 10]]
    intervals4 = []
    print(sol.canAttendMeetings(intervals1))  # false
    print(sol.canAttendMeetings(intervals2))  # true
    print(sol.canAttendMeetings(intervals3))  # true
    print(sol.canAttendMeetings(intervals4))  # true


if __name__ == "__main__":
    main()
