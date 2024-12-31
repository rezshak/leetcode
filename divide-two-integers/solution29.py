# https://leetcode.com/problems/divide-two-integers/

class Solution29:

    # T: O(log n), S: O(1)
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend == -2**31 and divisor == -1:
            return 2**31 - 1  # Overflow case
        if divisor == 1:
            return dividend
        if divisor == -1:
            return -dividend

        is_negative = (dividend < 0) != (divisor < 0)

        abs_dividend = abs(dividend)
        abs_divisor = abs(divisor)

        result = 0

        while abs_dividend >= abs_divisor:
            temp = abs_divisor
            multiple = 1

            while abs_dividend >= (temp << 1):
                temp <<= 1  # Double the temp value
                multiple <<= 1  # Double the multiple

            abs_dividend -= temp
            result += multiple

        return -result if is_negative else result


def main() -> None:
    sol = Solution29()
    print(sol.divide(10, 3))  # 3
    print(sol.divide(7, -3))  # -2


if __name__ == "__main__":
    main()
