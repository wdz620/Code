package LeetCode.ListNode;

import java.util.Scanner;

/**题目：18 删除链表中的节点
     *请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 示例：
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例：
     * 输入: head = [4,5,1,9], node = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class DeleteNode {
    public static ListNode deleteNode(ListNode head, int val) {
        //初始化一个虚拟节点
        ListNode listNode = new ListNode(0);
        //让虚拟节点指向头结点
        listNode.next = head;
        ListNode cur = head;
        ListNode pre = listNode;
        while (cur != null) {
            if (cur.val == val) {
                //如果找到要删除的结点，直接把他删除
                pre.next = cur.next;
                break;
            }
            //如果没找到，pre指针和cur指针都同时往后移一步
            pre = cur;
            cur = cur.next;
        }
        //最后返回虚拟节点的下一个结点即可
        return listNode.next;
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }

    public static void main(String[] args) {

        /** 输入: head = [4,5,1,9], node = 5
         输出: [4,1,9]
         */
        ListNode listNode = new ListNode(0);
        ListNode curr=listNode;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            curr.next= new ListNode(scanner.nextInt());
            curr = curr.next;
        }
         int i = scanner.nextInt();
        ListNode listNode1 = deleteNode(listNode.next, i);
        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }


    }

}
