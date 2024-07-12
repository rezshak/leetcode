
class ListNode {

    final int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(val) + (next != null ? " -> " + next : "");
    }

    public static void printList(ListNode head) {
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

}
