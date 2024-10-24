# https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

from typing import List


class Solution1502:

    # T: O(n log n), S: O(1)
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        arr.sort()
        diff = arr[1] - arr[0]
        for i in range(1, len(arr) - 1):
            if arr[i + 1] - arr[i] != diff:
                return False
        return True

    # T: O(n), S: O(n)
    def canMakeArithmeticProgressionSet(self, arr: List[int]) -> bool:
        n = len(arr)
        if n <= 2:
            return True
        min_val = min(arr)
        max_val = max(arr)

        # Calculate the common difference
        if (max_val - min_val) % (n - 1) != 0:
            return False
        diff = (max_val - min_val) // (n - 1)

        # If the difference is zero, all elements must be the same
        if diff == 0:
            return True

        num_set = set()
        for num in arr:
            # Check if each number is in the arithmetic progression sequence
            if (num - min_val) % diff != 0:
                return False
            num_set.add(num)

        # Check if all numbers in the arithmetic sequence are present
        return len(num_set) == n


def main():
    sol = Solution1502()
    arr1 = [3, 5, 1]
    arr2 = [1, 2, 4]
    print(sol.canMakeArithmeticProgression(arr1))  # True
    print(sol.canMakeArithmeticProgressionSet(arr1))  # True
    print(sol.canMakeArithmeticProgression(arr2))  # False
    print(sol.canMakeArithmeticProgressionSet(arr2))  # False


if __name__ == "__main__":
    main()
