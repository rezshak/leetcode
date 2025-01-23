// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// T: O(n), S: O(k) where k is the unique characters in the string
function lengthOfLongestSubstring(s: string): number {
    const seen = new Set<string>();
    let left = 0,
        right = 0;
    let result = 0;
    while (right < s.length) {
        if (seen.has(s[right])) {
            seen.delete(s[left]);
            left++;
        } else {
            seen.add(s[right]);
            right++;
            result = Math.max(result, right - left);
        }
    }
    return result;
}

// T: O(n), S: O(k)
function lengthOfLongestSubstringOpt(s: string): number {
    const indices = new Map<string, number>();
    let result: number = 0;
    for (let left = 0, right = 0; right < s.length; right++) {
        const curr = s[right];
        if (indices.has(curr) && indices.get(curr)! >= left) {
            left = indices.get(curr)! + 1;
        }
        indices.set(curr, right);
        result = Math.max(result, right - left + 1);
    }
    return result;
}

const s1: string = "abcabcbb";
const s2: string = "bbbbb";
const s3: string = "pwwkew";
const s4: string = "aab";

console.log(lengthOfLongestSubstring(s1)); // 3
console.log(lengthOfLongestSubstringOpt(s1)); // 3
console.log(lengthOfLongestSubstring(s2)); // 1
console.log(lengthOfLongestSubstringOpt(s2)); // 1
console.log(lengthOfLongestSubstring(s3)); // 3
console.log(lengthOfLongestSubstringOpt(s3)); // 3
console.log(lengthOfLongestSubstring(s4)); // 2
console.log(lengthOfLongestSubstringOpt(s4)); // 2
