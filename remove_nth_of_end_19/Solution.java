package remove_nth_of_end_19;

public class Solution {
    /**
     * 记录前一个指向target的node和target node
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode target = findLast(dump, n + 1);
        target.next = target.next.next;
        return dump.next;
    }

    ListNode findLast(ListNode head, int n) {
        ListNode p = head;
        for (int i = 0; i < n; ++i) {
            p = p.next;
        }

        ListNode target = head;
        while (p != null) {
            target = target.next;
            p = p.next;
        }

        return target;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}