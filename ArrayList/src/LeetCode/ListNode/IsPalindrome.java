package LeetCode.ListNode;

/**
 * @Author: Wdz
 * @Date 2020/9/14 21:04
 * @Description:
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode l1 =new ListNode(1);
        ListNode l2 =new ListNode(2);
        ListNode l3 =new ListNode(2);
        ListNode l4 =new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(isPalindrome(l1));
    }
    //自答：有问题 TODO 只能判断出非回文数字，链表地址理解问题，主要想通过先翻转链表，然后两个链表进行比较。
    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    public static ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode pre = reverse(mid);
        while (pre!= null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}
