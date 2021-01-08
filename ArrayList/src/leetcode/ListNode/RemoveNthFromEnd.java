package leetcode.ListNode;

/**
 * @Author: Wdz
 * @Date 2020/9/13 19:45
 * @Description: 19 删除链表的倒数第N个节点
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode l1 =new ListNode(1);
        ListNode l2 =new ListNode(2);
        ListNode l3 =new ListNode(3);
        ListNode l4 =new ListNode(4);
        ListNode l5 =new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = removeNthFromEnd1(l1, 2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

    }
    //自答 TODO 链表有点小问题
    //思路：第一遍循环找到待删除的前一个位置，第二遍循环进行删除。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        int temp = 0;
        ListNode num = head;
        while(num != null){
            temp++;
            num = num.next;
        }
        int begin = temp-n;
        ListNode cur = head;
        while(begin>0){
            cur= cur.next;
            begin--;
        }
        cur.val = cur.next.val;
        cur.next = cur.next.next;
        return head;
    }
    //参考：使用了两个指针，一个先走了n步，然后在同时进行前进。这样当前面的走到尽头之后，后面一个刚好到达要删除的位置。
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0) {
            start = start.next;
            n--;
        }
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}
