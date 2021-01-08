package leetcode.TreeNode;

/**
 * @Author: Wdz
 * @Date 2020/10/28 10:08
 * @Description: 116 填充每个节点的下一个右侧节点指针
 */
public class Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    //递归学习
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    // 定义：输入两个节点，将它俩连接起来
    public void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) return;
        /**** 前序遍历位置 ****/
        // 将传入的两个节点连接
        node1.next = node2;
        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }

    //参考
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }

        Node preNode = root;
        Node curNode = null;
        while (preNode.left != null) {  // 完美二叉树 ，左孩子为null，右孩子必为null

            /*
                遍历当前节点 右侧的节点
             */
            curNode = preNode;
            while (curNode != null) {   // 使 curNode的子节点层的所有节点的next赋值
                curNode.left.next = curNode.right;  // 将当前节点的左孩子的next指向右孩子

                if (curNode.next != null) { // 当前节点的next之前被指定过，说明子节点的右侧存在 节点
                    curNode.right.next = curNode.next.left; // 将当前节点的右子节点 指向 右侧的节点
                }
                curNode = curNode.next; // 将当前节点指向 next节点(右侧节点)
            }

            preNode = preNode.left; // 遍历下一层节点
        }
        return root;
    }

}
