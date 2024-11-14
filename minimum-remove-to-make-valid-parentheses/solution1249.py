# https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

class Solution1249:

    # T: O(n), S: O(n)
    def minRemoveToMakeValid(self, s: str) -> str:
        n = len(s)
        stack = []  # (ch, i)
        arr = list(s)
        for i in range(n):
            ch = arr[i]
            if stack and stack[-1][0] == '(' and ch == ')':
                stack.pop()
            elif ch == '(' or ch == ')':
                stack.append((ch, i))

        sb = []
        for i in range(n - 1, -1, -1):
            if stack and stack[-1][1] == i:
                stack.pop()
            else:
                sb.append(arr[i])

        return ''.join(reversed(sb))


def main() -> None:
    sol = Solution1249()
    s1 = "lee(t(c)o)de)"
    s2 = "a)b(c)d"
    s3 = "))(("
    print(sol.minRemoveToMakeValid(s1))  # "lee(t(c)o)de"
    print(sol.minRemoveToMakeValid(s2))  # "ab(c)d"
    print(sol.minRemoveToMakeValid(s3))  # ""


if __name__ == "__main__":
    main()
