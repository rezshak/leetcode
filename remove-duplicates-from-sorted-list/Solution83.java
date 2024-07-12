// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

class Solution83 {

    // T: O(n), S: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        var curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        var sol = new Solution83();
        // [1,1,2]
        var head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        System.out.println(head); // 1 -> 1 -> 2
        sol.deleteDuplicates(head);
        System.out.println(head);
    }

}
