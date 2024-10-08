# https://leetcode.com/problems/fizz-buzz/

from typing import List


class Solution412:

    # T: O(n), S: O(n)
    def fizzBuzz(self, n: int) -> List[str]:
        res = []
        for i in range(1, n + 1):
            if i % 15 == 0:
                res.append("FizzBuzz")
            elif i % 5 == 0:
                res.append("Buzz")
            elif i % 3 == 0:
                res.append("Fizz")
            else:
                res.append(str(i))

        return res


def main() -> None:
    sol = Solution412()
    print(sol.fizzBuzz(3))
    print(sol.fizzBuzz(5))
    print(sol.fizzBuzz(15))


if __name__ == "__main__":
    main()
