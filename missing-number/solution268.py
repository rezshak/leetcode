# https://leetcode.com/problems/missing-number/

class Solution268:

    # T: O(n), S: O(1)
    def missingNumberSum(self, nums):
        n = len(nums)
        expected_sum = n * (n + 1) // 2
        actual_sum = sum(nums)
        return expected_sum - actual_sum

    # T: O(n), S: O(1)
    def missingNumberSumXor(self, nums):
        missing = len(nums)
        for i, num in enumerate(nums):
            missing ^= i ^ num
        return missing

    # T: O(n), S: O(n)
    def missingNumberSumSet(self, nums):
        n = len(nums)
        if n == 0:
            return 0
        set_nums = set(nums)
        for i in range(n + 1):
            if i not in set_nums:
                return i
        return -1


def main():
    sol = Solution268()
    nums1 = [3, 0, 1]
    nums2 = [0, 1]
    nums3 = [9, 6, 4, 2, 3, 5, 7, 0, 1]

    print(sol.missingNumberSum(nums1))  # 2
    print(sol.missingNumberSumXor(nums1))  # 2
    print(sol.missingNumberSumSet(nums1))  # 2

    print(sol.missingNumberSum(nums2))  # 2
    print(sol.missingNumberSumXor(nums2))  # 2
    print(sol.missingNumberSumSet(nums2))  # 2

    print(sol.missingNumberSum(nums3))  # 8
    print(sol.missingNumberSumXor(nums3))  # 8
    print(sol.missingNumberSumSet(nums3))  # 8


if __name__ == "__main__":
    main()
