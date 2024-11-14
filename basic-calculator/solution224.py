# https://leetcode.com/problems/basic-calculator/

class Solution224:

    # T: O(n), S: O(n)
    def calculate(self, s: str) -> int:
        st = []
        num, result, sign = 0, 0, 1

        for ch in s:
            if ch.isdigit():
                digit = int(ch)
                num = num * 10 + digit
            elif ch == '+':
                result += num * sign
                sign = 1
                num = 0
            elif ch == '-':
                result += num * sign
                sign = -1
                num = 0
            elif ch == '(':
                st.append(result)
                st.append(sign)
                result = 0
                sign = 1
            elif ch == ')':
                result += num * sign
                result *= st.pop()
                result += st.pop()
                num = 0

        result += num * sign
        return result


def main() -> None:
    sol = Solution224()
    s1 = "1 + 1"
    s2 = " 2-1 + 2 "
    s3 = "(1+(4+5+2)-3)+(6+8)"
    print(sol.calculate(s1))  # 2
    print(sol.calculate(s2))  # 3
    print(sol.calculate(s3))  # 23


if __name__ == "__main__":
    main()
