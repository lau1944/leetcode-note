package merge_k_sorted_lists_23;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dump = new ListNode(-1), p = dump;
        Queue<ListNode> queue = new PriorityQueue<>((ori, tar) -> ori.val - tar.val);
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            node.next = null;
            p = p.next;
        }

        return dump.next;
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
