# https://leetcode.com/problems/add-binary/

class Solution67:

    # T: O(n), S: O(n)
    def addBinary(self, a: str, b: str) -> str:
        i, j = len(a) - 1, len(b) - 1
        carry = 0
        result = []
        while i >= 0 or j >= 0:
            x = int(a[i]) if i >= 0 else 0
            y = int(b[j]) if j >= 0 else 0
            sum = x + y + carry
            digit = sum % 2
            result.append(str(digit))
            carry = sum // 2
            i -= 1
            j -= 1
        if carry > 0:
            result.append(str(carry))
        return ''.join(result[::-1])


def main() -> None:
    sol = Solution67()
    s1 = "11"
    s2 = "1"
    print(sol.addBinary(s1, s2))  # 100


if __name__ == "__main__":
    main()
