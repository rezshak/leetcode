// https://leetcode.com/problems/group-anagrams/

import java.util.*;

class Solution49 {

    // T: O(nk log k), S: O(nk)
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (var str : strs) {
            var key = makeKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String makeKey(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        var sol = new Solution49();
        var strs1 = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        var strs2 = new String[] { "" };
        var strs3 = new String[] { "a" };
        System.out.println(sol.groupAnagrams(strs1));
        System.out.println(sol.groupAnagrams(strs2));
        System.out.println(sol.groupAnagrams(strs3));
    }
}