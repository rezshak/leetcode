// https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/

class Solution1904 {

    // T: O(1), S: O(1)
    public int numberOfRounds(String loginTime, String logoutTime) {
        int startMinutes = getMinutes(loginTime);
        int finishMinutes = getMinutes(logoutTime);

        if (finishMinutes < startMinutes) {
            finishMinutes += 24 * 60;
        }

        int roundedStart = (startMinutes + 14) / 15 * 15;
        int roundedFinish = finishMinutes / 15 * 15;

        return Math.max(0, (roundedFinish - roundedStart) / 15);
    }

    private int getMinutes(String time) {
        int hrs = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3));
        return hrs * 60 + min;
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
