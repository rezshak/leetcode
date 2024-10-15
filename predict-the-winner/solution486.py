# https://leetcode.com/problems/predict-the-winner/

from typing import List


class Solution486:

    # T: (O(n^2)), S: (O(n^2))
    def predictTheWinner(self, nums: List[int]) -> bool:
        memo = {}

        def turn(nums, l, r, player1, memo):
            key = (l, r, player1)
            if key in memo:
                return memo[key]
            if l > r:
                return 0

            if player1:
                result = max(
                    nums[l] + turn(nums, l + 1, r, False, memo),
                    nums[r] + turn(nums, l, r - 1, False, memo)
                )
            else:
                result = min(
                    -nums[l] + turn(nums, l + 1, r, True, memo),
                    -nums[r] + turn(nums, l, r - 1, True, memo)
                )

            memo[key] = result
            return result

        return turn(nums, 0, len(nums) - 1, True, memo) >= 0


def main() -> None:
    sol = Solution486()
    nums1 = [1, 5, 2]
    nums2 = [1, 5, 233, 7]
    print(sol.predictTheWinner(nums1))  # False
    print(sol.predictTheWinner(nums2))  # True


if __name__ == "__main__":
    main()
