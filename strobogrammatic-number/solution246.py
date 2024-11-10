# https://leetcode.com/problems/strobogrammatic-number/

class Solution246:

    STROB_MAP = {
        '0': '0',
        '1': '1',
        '6': '9',
        '8': '8',
        '9': '6'
    }

    # T: O(n), S: O(1)
    def isStrobogrammatic(self, num: str) -> bool:
        l, r = 0, len(num) - 1
        while l <= r:
            lch, rch = num[l], num[r]
            if lch not in self.STROB_MAP or self.STROB_MAP[lch] != rch:
                return False
            l += 1
            r -= 1
        return True


def main():
    sol = Solution246()
    print(sol.isStrobogrammatic("69"))  # True
    print(sol.isStrobogrammatic("88"))  # True
    print(sol.isStrobogrammatic("962"))  # False
    print(sol.isStrobogrammatic("808"))  # True
    print(sol.isStrobogrammatic("2"))  # False


if __name__ == "__main__":
    main()
