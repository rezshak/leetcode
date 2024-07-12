// https://leetcode.com/problems/middle-of-the-linked-list/

class Solution876 {

    // T: O(n), S: O(1)
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        var sol = new Solution876();
        // 1,2,3,4,5
        var head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(head1);
        System.out.println(sol.middleNode(head1).val); // 3
    }

}
