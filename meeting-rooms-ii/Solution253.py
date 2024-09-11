# https://leetcode.com/problems/meeting-rooms-ii/

import heapq


class Solution253:

    # T: O(nlogn), S: O(n)
    def minMeetingRooms(self, intervals):
        n = len(intervals)
        start = [intervals[i][0] for i in range(n)]
        end = [intervals[i][1] for i in range(n)]

        start.sort()
        end.sort()

        result, count = 0, 0
        s, e = 0, 0

        while s < n:
            if start[s] < end[e]:
                s += 1
                count += 1
            else:
                e += 1
                count -= 1
            result = max(result, count)

        return result

    # T: O(nlogn), S: O(n)
    def minMeetingRoomsPq(self, intervals):
        intervals.sort(key=lambda x: x[0])

        end_times = []
        heapq.heappush(end_times, intervals[0][1])

        for i in range(1, len(intervals)):
            start_time = intervals[i][0]
            if start_time >= end_times[0]:
                heapq.heappop(end_times)
            heapq.heappush(end_times, intervals[i][1])

        return len(end_times)


def main() -> None:
    sol = Solution253()
    intervals1 = [[0, 30], [5, 10], [15, 20]]
    intervals2 = [[7, 10], [2, 4]]
    print(sol.minMeetingRooms(intervals1))  # 2
    print(sol.minMeetingRoomsPq(intervals1))  # 2
    print(sol.minMeetingRooms(intervals2))  # 1
    print(sol.minMeetingRoomsPq(intervals2))  # 1


if __name__ == "__main__":
    main()
