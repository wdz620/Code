package leetcode.ListNode;

/**
 * @Author: Wdz
 * @Date 2020/10/27 9:50
 * @Description: 92、反转链表II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。1 ≤ m ≤ n ≤ 链表长度。
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseBetween {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //参考解答
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode slow = pre, fast = pre.next;
        int step = 0;
        while (m - 1 > step) {
            slow = slow.next;
            fast = fast.next;
            step++;
        }
        //此时slow指向1，fast指向2，利用头插法操作(从后往前操作)
        for (int i = 0; i < n - m; i++) {
            ListNode removed = fast.next;
            fast.next = fast.next.next;
            removed.next = slow.next;
            slow.next = removed;
        }
        return pre.next;
    }
    /*
    翻转链表
     */
    public static ListNode reverse(ListNode slow, ListNode fast) {
        ListNode pre = null;
        ListNode curr = slow;
        while (curr != fast) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode node = reverseBetween(l1, 2, 5);
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }


    }

}
