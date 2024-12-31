# https://leetcode.com/problems/compare-version-numbers/

class Solution165:

    # T: O(max(n,m)), S: O(n+m)
    def compareVersion(self, version1: str, version2: str) -> int:
        v1_parts = version1.split(".")
        v2_parts = version2.split(".")

        max_length = max(len(v1_parts), len(v2_parts))

        for i in range(max_length):
            v1_val = int(v1_parts[i]) if i < len(v1_parts) else 0
            v2_val = int(v2_parts[i]) if i < len(v2_parts) else 0

            if v1_val > v2_val:
                return 1
            elif v1_val < v2_val:
                return -1

        return 0


def main() -> None:
    sol = Solution165()
    v1 = "1.2"
    v2 = "1.10"
    print(sol.compareVersion(v1, v2))  # -1
    v1 = "1.01"
    v2 = "1.001"
    print(sol.compareVersion(v1, v2))  # 0
    v1 = "1.0"
    v2 = "1.0.0.0"
    print(sol.compareVersion(v1, v2))  # 0


if __name__ == "__main__":
    main()
