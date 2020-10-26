package LeetCode.TreeNode;

import java.util.*;

/**
 * @Author: Wdz
 * @Date 2020/10/9 9:02
 * @Description: 树的四种遍历： 前中后+层
 * 前：输出该结点、访问左孩子、访问右孩子
 * 中：访问左孩子、输出该结点、访问右孩子
 * 后：访问左孩子、访问右孩子、输出该结点
 */
public class Order {
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
        System.out.println("前：" + preorderTraversal(t1));
        System.out.println("前1：" + preorderTraversal1(t1));
        System.out.println("中：" + inorderTraversal(t1));
        System.out.println("后：" + postorderTraversal(t1));
        System.out.println("层：" + levelOrder(t1));


    }
    /**
     * 前：输出该结点、访问左孩子、访问右孩子
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    //前中后第一种 递归做法！
    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        inorder(root.left, res);
        inorder(root.right, res);
    }
    //第二种：栈的实现
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * 中:访问左孩子、输出该结点、访问右孩子
     */
    //运用栈的思想
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                res.add(tem.val);
                node = tem.right;
            }
        }
        return res;
    }

    /**
     * 后:访问左孩子、访问右孩子、输出该结点
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
    }


    /**
     * 层
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        //创建一个队列，将根节点放入其中
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //每次遍历的数量为队列的长度
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将这一层的元素全部取出，放入到临时数组中，如果节点的左右孩子不为空，继续放入队列
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
