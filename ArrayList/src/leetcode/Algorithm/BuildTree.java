package leetcode.Algorithm;

import java.util.Scanner;

/**
 * @Author: Wdz
 * @Date 2020/11/1 10:09
 * @Description: 根据二叉树的前序遍历，构建二叉树
 */
public class BuildTree {
    public static String[] str;
    public static int count;
    /**
     * 静态内部类，定义二叉树节点
     */
    static class TreeNode {
        public String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String x) {
            this.val = x;
        }
    }
    /**
     * 根据前序序列递归构建二叉树
     *
     * @return
     */
    public static TreeNode createBtree() {
        TreeNode root = null;

        if (count >= str.length || str[count++].equals("#")) {
            root = null;
        } else {
            root = new TreeNode(str[count - 1]);
            root.left = createBtree();
            root.right = createBtree();
        }

        return root;
    }
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String s = cin.nextLine();
            str = s.split(",");

            count = 0;

            TreeNode root = createBtree();

            // 前序遍历
            preTraverse(root);
            System.out.println();

            // 中序遍历
            inTraverse(root);
            System.out.println();

            // 后序遍历
            postTraverse(root);
            System.out.println();
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public static void preTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inTraverse(TreeNode root) {
        if (root != null) {
            inTraverse(root.left);
            System.out.print(root.val + " ");
            inTraverse(root.right);
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static void postTraverse(TreeNode root) {
        if (root != null) {
            postTraverse(root.left);
            postTraverse(root.right);
            System.out.print(root.val + " ");
        }
    }




}
