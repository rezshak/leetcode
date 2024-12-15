# https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/

class Solution1904:

    # T: O(1), S: O(1)
    def numberOfRounds(self, loginTime: str, logoutTime: str) -> int:
        def to_minutes(time: str) -> int:
            hours, minutes = map(int, time.split(':'))
            return hours * 60 + minutes

        login_mins = to_minutes(loginTime)
        logout_mins = to_minutes(logoutTime)

        if logout_mins < login_mins:
            logout_mins += 24 * 60

        login_rounded = ((login_mins + 14) // 15) * 15

        logout_rounded = (logout_mins // 15) * 15

        return max(0, (logout_rounded - login_rounded) // 15)


def main() -> None:
    sol = Solution1904()
    print(sol.numberOfRounds("09:31", "10:14"))  # 1
    print(sol.numberOfRounds("21:30", "03:00"))  # 22


if __name__ == "__main__":
    main()
