package leetcode.ListNode;

import java.util.Scanner;

/**
 * @Author: Wdz
 * @Date 2020/9/13 15:51
 * @Description: 206. 反转链表
 * <p>
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode curr=listNode;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(scanner.nextInt());
            curr = curr.next;
        }
        ListNode listNode1 = reverseList(listNode.next);
        while (listNode1 != null) {
            System.out.print(listNode1.val);
            listNode1 = listNode1.next;
        }

    }
}
