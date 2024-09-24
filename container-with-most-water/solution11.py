# https://leetcode.com/problems/container-with-most-water/

from typing import List


class Solution11:

    # T: O(n), S: O(1)
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        result = 0
        while left < right:
            width = right - left
            area = width * min(height[left], height[right])
            result = max(result, area)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return result


def main() -> None:
    sol = Solution11()
    height1 = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    height2 = [1, 1]
    print(sol.maxArea(height1))  # 49
    print(sol.maxArea(height2))  # 1


if __name__ == "__main__":
    main()
