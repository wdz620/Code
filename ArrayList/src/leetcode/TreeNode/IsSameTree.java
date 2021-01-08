package leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wdz
 * @Date 2020/10/27 9:15
 * @Description: 100、相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class IsSameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //脱裤子放屁般的自答
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List pList = new ArrayList();
        List qList = new ArrayList();
        inorder(p, pList);
        inorder(q, qList);
        System.out.println(pList);
        System.out.println(qList);

        if (!qList.equals(pList)) {
            return false;
        }
        return true;
    }
    public static void inorder(TreeNode node, List list) {
        if (node == null) {
            list.add(-1);
            return;
        }
        list.add(node.val);
        inorder(node.left, list);
        inorder(node.right, list);
    }


    public static void main(String[] args) {
        TreeNode p2 = new TreeNode(2);
        TreeNode p = new TreeNode(1, p2, null);
        TreeNode q3 = new TreeNode(3);
        TreeNode q = new TreeNode(1, null, q3);
        System.out.println(isSameTree(p, q));

    }

    //参考答案
    public static boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        if (p==null||q==null) return false; //因为上一步已经判断两个同时等于null，所以这里只有一个为空的情况
        if (p.val!=q.val) return false;
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

}
