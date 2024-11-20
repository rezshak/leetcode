# https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/

class Solution1904:

    # T: O(1), S: O(1)
    def numberOfRounds(self, loginTime: str, logoutTime: str) -> int:
        start_minutes = self.get_minutes(loginTime)
        finish_minutes = self.get_minutes(logoutTime)

        if finish_minutes < start_minutes:
            finish_minutes += 24 * 60

        rounded_start = (start_minutes + 14) // 15 * 15
        rounded_finish = finish_minutes // 15 * 15

        return max(0, (rounded_finish - rounded_start) // 15)

    def get_minutes(self, time: str) -> int:
        hrs, min = map(int, time.split(':'))
        return hrs * 60 + min


def main() -> None:
    sol = Solution1904()
    print(sol.numberOfRounds("09:31", "10:14"))  # 1
    print(sol.numberOfRounds("21:30", "03:00"))  # 22


if __name__ == "__main__":
    main()
