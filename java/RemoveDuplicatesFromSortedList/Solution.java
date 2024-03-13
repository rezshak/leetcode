// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

package RemoveDuplicatesFromSortedList;

class ListNode {
    final int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class Solution {

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

    private void printList(ListNode head) {
        var sb = new StringBuilder();
        var curr = head;
        sb.append("[ ");
        while (curr != null) {
            sb.append(curr.val).append(" ");
            curr = curr.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var head = new ListNode(1); // [1,1,2]
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        sol.printList(head);
        sol.deleteDuplicates(head); // [1,2]
        sol.printList(head);
    }

}
