package leetcode.Algorithm;

import java.util.*;

/**
 * @Author: Wdz
 * @Date 2020/10/25 15:14
 * @Description: 学习BFS和DFS https://blog.csdn.net/Gene1994/article/details/85097507
 * BFS（广度优先遍历，Breadth First Search）及DFS（深度优先遍历，Depth First Search）是遍历树或图的两种最常用的方法。
 * 本文简单的讲解在面对树或者图的问题时，使用BFS及DFS解答题目时的思路及实现。
 */
public class BFSAndDFS {

    //使用Queue实现BFS
    public static void BFSWithQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            //在这里处理遍历到的TreeNode节点
            System.out.println(treeNode.val);

            if (treeNode.left != null)
                queue.add(treeNode.left);
            if (treeNode.right != null)
                queue.add(treeNode.right);
        }
    }

    //DFS递归实现
    public void DFSWithRecursion(TreeNode root) {
        if (root == null)
            return;

        //在这里处理遍历到的TreeNode节点

        if (root.left != null)
            DFSWithRecursion(root.left);
        if (root.right != null)
            DFSWithRecursion(root.right);
    }

    //DFS的迭代实现版本（Stack）
    public void DFSWithStack(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();

            //在这里处理遍历到的TreeNode

            if (treeNode.right != null)
                stack.push(treeNode.right);

            if (treeNode.left != null)
                stack.push(treeNode.left);
        }
    }

    //使用Queue实现BFS
    public void BFSWithQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        Set<Node> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited.add(node);

            //在这里处理遍历到的Node节点

            if (node.children != null) {
                for (Node child : node.children) {
                    if (child != null && !visited.contains(child)) {
                        queue.add(child);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        BFSWithQueue(t1);

    }

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
