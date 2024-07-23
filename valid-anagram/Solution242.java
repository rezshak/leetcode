// https://leetcode.com/problems/valid-anagram/

class Solution242 {

    // T: O(n), S: O(1)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var counts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            counts[t.charAt(i)]--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution242();
        var s1 = "anagram";
        var t1 = "nagaram";
        System.out.println(sol.isAnagram(s1, t1)); // true
	    var s2 = "rat";
        var t2 = "car";
        System.out.println(sol.isAnagram(s2, t2)); // false
    }

}
