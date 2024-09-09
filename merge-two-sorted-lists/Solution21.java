// https://leetcode.com/problems/merge-two-sorted-lists/

class Solution21 {

    // T: O(n), S: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var fake = new ListNode(-1);
        var tail = fake;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        return fake.next;
    }

    public static void main(String[] args) {
        var sol = new Solution21();
        var list1 = new ListNode(1, new ListNode(2, new ListNode(4))); // [1,2,4]
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4))); // [1,3,4]
        System.out.println(sol.mergeTwoLists(list1, list2)); // [1,1,2,3,4,4]
        list1 = null;
        list2 = new ListNode(0);
        System.out.println(sol.mergeTwoLists(list1, list2)); // [0]
    }

}
