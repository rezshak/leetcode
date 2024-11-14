# https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class Solution1047:

    # T: O(n), S: O(n)
    def removeDuplicates(self, s: str) -> str:
        stack = []
        for ch in s:
            if stack and stack[-1] == ch:
                stack.pop()
            else:
                stack.append(ch)
        return ''.join(stack)

    # T: O(n), S: O(n)
    def removeDuplicates2(self, s: str) -> str:
        st = []  # Use list as stack
        for ch in s:
            if st and st[-1] == ch:
                st.pop()
            else:
                st.append(ch)
        return ''.join(st)


def main() -> None:
    sol = Solution1047()
    s1 = "abbaca"
    s2 = "azxxzy"
    print(sol.removeDuplicates(s1))  # "ca"
    print(sol.removeDuplicates2(s1))  # "ca"
    print(sol.removeDuplicates(s2))  # "ay"
    print(sol.removeDuplicates2(s2))  # "ay"


if __name__ == "__main__":
    main()
