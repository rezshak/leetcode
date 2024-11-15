# https://leetcode.com/problems/exclusive-time-of-functions/

from typing import List


class Solution636:

    # T: O(n), S: O(n)
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        stack = []
        prev_time = 0

        for entry in logs:
            arr = entry.split(":")
            id = int(arr[0])
            type = arr[1]
            time = int(arr[2])

            if type == "start":
                if stack:
                    prev_id = stack[-1]
                    result[prev_id] += time - prev_time
                stack.append(id)
                prev_time = time
            else:
                prev_id = stack.pop()
                result[prev_id] += time - prev_time + 1
                prev_time = time + 1

        return result


def main() -> None:
    sol = Solution636()
    logs1 = ["0:start:0", "1:start:2", "1:end:5", "0:end:6"]
    logs2 = ["0:start:0", "0:start:2", "0:end:5",
             "0:start:6", "0:end:6", "0:end:7"]
    logs3 = ["0:start:0", "0:start:2", "0:end:5",
             "1:start:6", "1:end:6", "0:end:7"]
    print(sol.exclusiveTime(2, logs1))  # [3, 4]
    print(sol.exclusiveTime(1, logs2))  # [8]
    print(sol.exclusiveTime(2, logs3))  # [7, 1]


if __name__ == "__main__":
    main()
