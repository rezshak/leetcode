# https://leetcode.com/problems/happy-number/

class Solution202:

    # T: O(log n), S: O(log n)
    def isHappy(self, n: int) -> bool:
        seen = set()
        while n not in seen and n != 1:
            seen.add(n)
            n = self.squared_digits_sum(n)
        return n == 1

    # T: O(log n), S: O(1)
    def isHappyOpt(self, n: int) -> bool:
        slow, fast = n, self.squared_digits_sum(n)
        while fast != 1 and fast != slow:
            slow = self.squared_digits_sum(slow)
            fast = self.squared_digits_sum(self.squared_digits_sum(fast))
        return fast == 1

    # T: O(log n), S: O(1)
    def squared_digits_sum(self, num: int) -> int:
        result = 0
        while num > 0:
            digit = num % 10
            squared = digit * digit
            result += squared
            num //= 10
        return result


def main() -> None:
    sol = Solution202()
    print(sol.isHappy(19))  # true
    print(sol.isHappy(2))   # false
    print(sol.isHappyOpt(19))  # true
    print(sol.isHappyOpt(2))   # false


if __name__ == "__main__":
    main()
