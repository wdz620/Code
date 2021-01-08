package leetcode.ListNode;

/**
 * @Author: Wdz
 * @Date 2020/10/26 8:43
 * @Description: 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 实例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) l1 = new ListNode(0);
        if (l2 == null) l2 = new ListNode(0);

        ListNode sum = new ListNode(0);
        sum.val = l1.val + l2.val;
        if (sum.val >= 10) {
            sum.val -= 10;
            if (l1.next != null) {
                l1.next.val++;
            } else {
                l1.next = new ListNode(1);
            }
        }
        sum.next = addTwoNumbers(l1.next, l2.next);
        return sum;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        ListNode listNode = addTwoNumbers(l1, l4);
        while (listNode != null) {
            if (listNode.next != null) {
                System.out.print(listNode.val + "->");
            } else {
                System.out.println(listNode.val + "->null");
            }
            listNode = listNode.next;
        }


    }

}
