/**
 * @author zhangboqing
 * @date 2019-11-20
 * 删除链表中等于给定值 val 的所有节点。
 */

public class Leetcode_203 {


    /*
    示例:
        输入: 1->2->6->3->4->5->6, val = 6
        输出: 1->2->3->4->5
    */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements2(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        while (head.val == val) {
            head = head.next;
        }

        ListNode pre = head;
        while (pre != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return head;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
