// https://leetcode.com/problems/intersection-of-two-linked-lists/

import java.util.HashSet;

class Solution160 {

    // T: O(n+m), S: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        var currA = headA;
        var currB = headB;
        while (currA != currB) {
            currA = currA != null ? currA.next : headB;
            currB = currB != null ? currB.next : headA;
        }
        return currA;
    }

    // T: O(n+m), S: O(1)
    public ListNode getIntersectionNodeTwoPtr(ListNode headA, ListNode headB) {
        int countA = 0;
        var currA = headA;
        while (currA != null) {
            currA = currA.next;
            countA++;
        }
        int countB = 0;
        var currB = headB;
        while (currB != null) {
            currB = currB.next;
            countB++;
        }
        int diff = Math.abs(countA - countB);
        currA = headA;
        currB = headB;
        if (countA > countB) {
            for (int i = 0; i < diff; i++) {
                currA = currA.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                currB = currB.next;
            }
        }
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }

    // T: O(n+m), S: O(n)
    public ListNode getIntersectionNodeSet(ListNode headA, ListNode headB) {
        var set = new HashSet<ListNode>();
        var currA = headA;
        while (currA != null) {
            set.add(currA);
            currA = currA.next;
        }
        var currB = headB;
        while (currB != null) {
            if (set.contains(currB)) {
                return currB;
            }
            currB = currB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        var sol = new Solution160();
        // [4,1,8,4,5]
        var headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        // [5,6,1,8,4,5]
        var headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;
        System.out.println(sol.getIntersectionNodeSet(headA, headB).val); // 8
        System.out.println(sol.getIntersectionNodeTwoPtr(headA, headB).val); // 8
    }

}
