// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

class Solution1491 {

    // T: O(n), S: O(1)
    public double average(int[] salary) {
        int n = salary.length;
        int minSal = salary[0], maxSal = salary[0];
        double sum = 0.0;
        for (int sal : salary) {
            minSal = Math.min(minSal, sal);
            maxSal = Math.max(maxSal, sal);
            sum += sal;
        }
        sum -= minSal;
        sum -= maxSal;
        return sum / (n - 2);
    }

    public static void main(String[] args) {
        var sol = new Solution1491();
        var salary1 = new int[] { 4000, 3000, 1000, 2000 };
        var salary2 = new int[] { 1000, 2000, 3000 };
        System.out.println(sol.average(salary1)); // 2500.0
        System.out.println(sol.average(salary2)); // 2000.0
    }

}
