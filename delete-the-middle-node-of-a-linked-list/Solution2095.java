// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

class Solution2095 {

    // T: O(n), S: O(1)
    public ListNode deleteMiddle(ListNode head) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode prev = fake, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return fake.next;
    }

    public static void main(String[] args) {
        var sol = new Solution2095();
        var head1 = new ListNode(1); // [1,3,4,7,1,2,6]
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(7);
        head1.next.next.next.next = new ListNode(1);
        head1.next.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next.next = new ListNode(6);
        System.out.println(head1);
        head1 = sol.deleteMiddle(head1);
        System.out.println(head1); // [1,3,4,1,2,6]
    }

}
