// https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/

class Solution1904 {

    // T: O(1), S: O(1)
    public int numberOfRounds(String loginTime, String logoutTime) {
        // Convert times to minutes
        int loginMins = toMinutes(loginTime);
        int logoutMins = toMinutes(logoutTime);

        // Handle cases where logout time is before login time (next day)
        if (logoutMins < loginMins) {
            logoutMins += 24 * 60;
        }

        // Round login time up to the next full 15-minute interval
        int loginRounded = ((loginMins + 14) / 15) * 15;

        // Round logout time down to the previous full 15-minute interval
        int logoutRounded = (logoutMins / 15) * 15;

        // Calculate full rounds
        return Math.max(0, (logoutRounded - loginRounded) / 15);
    }

    // Helper method to convert time to minutes
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    public static void main(String[] args) {
        var sol = new Solution1904();
        String loginTime1 = "09:31";
        String logoutTime1 = "10:14";
        System.out.println(sol.numberOfRounds(loginTime1, logoutTime1)); // 1
        String loginTime2 = "21:30";
        String logoutTime2 = "03:00";
        System.out.println(sol.numberOfRounds(loginTime2, logoutTime2)); // 22
    }

}
