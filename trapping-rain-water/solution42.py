# https://leetcode.com/problems/trapping-rain-water/

class Solution42:

    # T: O(n), S: O(1)
    def trap(self, height):
        if not height or len(height) < 3:
            return 0

        left, right = 0, len(height) - 1
        left_max, right_max = 0, 0
        total_water = 0

        while left < right:
            left_max = max(left_max, height[left])
            right_max = max(right_max, height[right])

            if left_max < right_max:
                total_water += left_max - height[left]
                left += 1
            else:
                total_water += right_max - height[right]
                right -= 1

        return total_water


def main() -> None:
    sol = Solution42()
    height1 = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    height2 = [4, 2, 0, 3, 2, 5]
    print(sol.trap(height1))  # 6
    print(sol.trap(height2))  # 9


if __name__ == "__main__":
    main()
