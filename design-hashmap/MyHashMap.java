// https://leetcode.com/problems/design-hashmap/

import java.util.*;

class MyHashMap {

    class Entry {
        final int key;
        int val;

        Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(key) + ": " + String.valueOf(val);
        }
    }

    final int CAP = 20;
    List<LinkedList<Entry>> buckets;

    public MyHashMap() {
        buckets = new ArrayList<>(CAP);
        for (int i = 0; i < CAP; i++) {
            buckets.add(new LinkedList<Entry>());
        }
    }

    // T: O(n), S: O(1)
    public void put(int key, int value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.val = value;
            return;
        }
        getBucket(key).addLast(new Entry(key, value));
    }

    // T: O(n), S: O(1)
    public int get(int key) {
        var entry = getEntry(key);
        return entry == null ? -1 : entry.val;
    }

    // T: O(n), S: O(1)
    public void remove(int key) {
        var bucket = getBucket(key);
        var iterator = bucket.iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.key == key) {
                iterator.remove();
                break;
            }
        }
    }

    // T: O(1), S: O(1)
    private int hash(int key) {
        return Math.abs(key) % buckets.size();
    }

    // T: O(1), S: O(1)
    private List<Entry> getBucket(int key) {
        return buckets.get(hash(key));
    }

    // T: O(n), S: O(1)
    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        for (var entry : bucket) {
            if (entry.key == key) {
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        String[] commands = { "MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get" };
        int[][] arguments = { {}, { 1, 1 }, { 2, 2 }, { 1 }, { 3 }, { 2, 1 }, { 2 }, { 2 }, { 2 } };

        for (int i = 1; i < commands.length; i++) {
            switch (commands[i]) {
                case "put":
                    myHashMap.put(arguments[i][0], arguments[i][1]);
                    System.out.println("Put (" + arguments[i][0] + ", " + arguments[i][1] + ")");
                    break;
                case "get":
                    int getResult = myHashMap.get(arguments[i][0]);
                    System.out.println("Get " + arguments[i][0] + ": " + getResult);
                    break;
                case "remove":
                    myHashMap.remove(arguments[i][0]);
                    System.out.println("Removed key " + arguments[i][0]);
                    break;
            }
        }
    }

}
