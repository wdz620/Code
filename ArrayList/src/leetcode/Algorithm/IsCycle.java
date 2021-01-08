package leetcode.Algorithm;

import java.util.HashMap;

/**
 * 判断链表中是否有环
 */
public class IsCycle {
    private Node root;

    public static void main(String[] args) {
        //1-5创建一个无环链表
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        //下面注释的两行为有环链表
//		Node n5 =new Node(1);
        Node n6 = new Node(6);
        //指定每个节点的下一个节点的值
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n1;
        System.err.println(hasLoop(n1));//打印结果是false表示是无环链表，ture是有环链表
        System.err.println(hasLoop2(n1));
        //遍历打印整个链表
        System.out.println(n1.name);
        /**
         * 不是环时，可调用此方法
         */
//		while(n1.next!=null){
//			System.out.println("-->"+n1.next.getName());
//			n1=n1.next;
//		}
    }

    public void add(int name) {
        Node newNode = new Node(name);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
    }

    public void print() {
        if (this.root != null) {
            this.root.printNode();
        }
    }

    /**
     * 方法一： 遍历链表，创建两个类似指针的变量，一个指针每次向后移动一个节点，一个指针每次移动两个节点，如果遇到两者相同的情况说明存在环
     */
    public static boolean hasLoop(Node n) {
        Node tmp1 = n;
        Node tmp2 = n.next;
        while (tmp2 != null) {
            if (tmp1 == tmp2) return true;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next.next;
            if (tmp2 == null) return false;
        }
        return true;
    }

    /**
     * 方法二：把每个节点放到hash表中，因为存入的是对象，所有相同的就说明有环
     */
    public static boolean hasLoop2(Node n) {
        Node tmp1 = n;
        HashMap<Node, Node> ns = new HashMap<Node, Node>();
        while (n != null) {
            if (ns.get(tmp1) != null) return true;
            ns.put(tmp1, tmp1);
            tmp1 = tmp1.next;
            if (tmp1 == null) return false;
        }
        return true;
    }

    /**
     * 自建内部类---链表类
     */
    static class Node {
        private int name;//名字，用于标识每个节点的名称
        private Node next;//当前节点的下一个节点，也作为自身的一个属性

        public Node(int name) { //构造函数
            this.name = name;
        }

        public int getName() {
            return this.name;
        }

        /*
         * 增加下一个节点，
         */
        public void addNode(Node newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.addNode(newNode);
            }
        }

        public void printNode() {
            System.out.println(this.name + "-->");
            if (this.next != null) {
                this.next.printNode();
            }
        }
    }

    ;

}
