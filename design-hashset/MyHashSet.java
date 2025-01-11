// https://leetcode.com/problems/design-hashset/

import java.util.Arrays;

class MyHashSetBoolArray {

    private static final int SIZE = 1_000_001;
    private boolean[] set;

    public MyHashSetBoolArray() {
        set = new boolean[SIZE];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }

    public void clear() {
        Arrays.fill(set, false);
    }

}

class MyHashSetBitArray {

    private static final int SIZE = 1_000_001;
    private final byte[] bits;

    public MyHashSetBitArray() {
        bits = new byte[SIZE / 8 + 1]; // 8 bits per byte +1 to handle division remainder
    }

    public void add(int key) {
        int byteIndex = getByteIndex(key);
        int bitIndex = getBitIndex(key);
        bits[byteIndex] |= (1 << bitIndex); // Set the key'th bit
    }

    public void remove(int key) {
        int byteIndex = getByteIndex(key);
        int bitIndex = getBitIndex(key);
        bits[byteIndex] &= ~(1 << bitIndex); // Clear the key'th bit
    }

    public boolean contains(int key) {
        int byteIndex = getByteIndex(key);
        int bitIndex = getBitIndex(key);
        return (bits[byteIndex] & (1 << bitIndex)) != 0; // Retrieve the key'th bit
    }

    public void clear() {
        Arrays.fill(bits, (byte) 0);
    }

    private int getByteIndex(int key) {
        return key / 8;
    }

    private int getBitIndex(int key) {
        return key % 8;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
