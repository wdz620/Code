package leetcode.ListNode;

import java.util.Scanner;

/**
 * @Author: Wdz
 * @Date 2020/10/11 19:47
 * @Description: 奇数位置在前，翻转偶数在后！
 */
public class OddEvenList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int begin = scanner.nextInt();
        int end = scanner.nextInt();
        ListNode listNode = new ListNode(begin);
        ListNode curr = listNode;
        for (int i = begin + 1; i <= end; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        //测试
        ListNode listNode1 = oddEvenList(listNode);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        //再次翻转
        System.out.println();
        System.out.println("再次翻转");
        ListNode listNode2 = reverseList(listNode1);
        while (listNode2 != null) {
            System.out.print(listNode2.val + " ");
            listNode2 = listNode2.next;
        }


    }

    public static ListNode oddEvenList(ListNode head) {
        //这里是因为引入类，所以属于传引用，所以当形参的结果会影响到实参的结果。
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        //翻转后半部分
        ListNode reverse = reverseList(evenHead);
        odd.next = reverse;
        return head;
    }

    //翻转
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

    //找到中间位置
    public static ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
