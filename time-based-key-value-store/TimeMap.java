// https://leetcode.com/problems/time-based-key-value-store/

import java.util.*;

class TimeMap {

    /**
     * Data structure to store time-based key-value pairs.
     * Uses HashMap of TreeMap where:
     * - Outer HashMap maps key to its timeline of values
     * - Inner TreeMap maps timestamps to values for efficient floor/ceiling
     * operations
     * 
     * Time Complexity:
     * - set: O(log n) where n is number of timestamps for a key
     * - get: O(log n) for binary search among timestamps
     * Space Complexity: O(n) where n is total number of key-value pairs
     */
    private Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // Get or create TreeMap for this key
        store.putIfAbsent(key, new TreeMap<>());
        // Store value at given timestamp
        store.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }

        // Get TreeMap for this key
        TreeMap<Integer, String> timeline = store.get(key);

        // Find the greatest key less than or equal to timestamp
        Integer floorKey = timeline.floorKey(timestamp);

        // Return value if found, empty string otherwise
        return floorKey != null ? timeline.get(floorKey) : "";
    }

    public static void main(String[] args) {
        var tm = new TimeMap();
        tm.set("foo", "bar", 1);
        System.out.println(tm.get("foo", 1));
        System.out.println(tm.get("foo", 3));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
