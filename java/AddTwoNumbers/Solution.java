// https://leetcode.com/problems/add-two-numbers/

package AddTwoNumbers;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class Solution {

    // T: O(max(m, n)), S: O(max(m, n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var fake = new ListNode(-1);
        var tail = fake;
        var carry = 0;
        while (l1 != null || l2 != null) {
            var sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum >= 10 ? 1 : 0;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return fake.next;
    }

    public static void main(String[] args) {
        var l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        var l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        var s = new Solution();
        var l = s.addTwoNumbers(l1, l2);
        System.out.println(l); // 7 -> 0 -> 8
    }

}
