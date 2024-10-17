# https://leetcode.com/problems/valid-parentheses/

class Solution20:

    OPEN_SYMS = {'{', '[', '('}
    CLOSE_SYMS = {'}': '{', ']': '[', ')': '('}

    # T: O(n), S: O(n)
    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch in self.OPEN_SYMS:
                stack.append(ch)
            elif ch in self.CLOSE_SYMS:
                if not stack or stack.pop() != self.CLOSE_SYMS[ch]:
                    return False
        return len(stack) == 0


def main() -> None:
    sol = Solution20()
    s1 = "()"
    s2 = "()[]{}"
    s3 = "(]"
    print(sol.isValid(s1))  # True
    print(sol.isValid(s2))  # True
    print(sol.isValid(s3))  # False


if __name__ == "__main__":
    main()
