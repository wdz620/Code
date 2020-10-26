package Offer.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: Wdz
 * @Date 2020/7/4 11:42
 * @Description:从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 思路： 借助栈实现，或使用递归的方法
 */
public class PrintListFromTailToHead {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode removeNode = head;
        for (int i = 1; i < 10; i++) {
            ListNode x = new ListNode(i);
            x.next = null;
            removeNode.next = x;
            removeNode = x;
        }
        System.out.println(printListFromToHead02(head));
    }

    /**
     * 剑指Offer：方法一：借用栈
     */
    public static ArrayList<Integer> printListFromToHead01(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode head = listNode;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            list.add(temp.val);
        }
        return list;
    }
    /**
     * 剑指Offer：方式二：递归
     */
    public static ArrayList<Integer> printListFromToHead02(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        getNext(listNode, list);
        return list;
    }

    private static void getNext(ListNode listNode, ArrayList<Integer> list) {
        if (listNode != null) {
            getNext(listNode.next, list); //先递归输出其后的节点
            list.add(listNode.val); //在输出自身
        }
    }
    /**
     * 网上参考：列表的收尾插入
     */
    public static ArrayList<Integer> printListFromToHead03(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        ListNode head = listNode;
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }
        return list;
    }

    private static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

}

