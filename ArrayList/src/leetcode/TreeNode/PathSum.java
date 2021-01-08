package leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wdz
 * @Date 2020/11/19 14:06
 * @Description: 113、路径总和 II TODO 递归
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum {
    public static void main(String[] args) {
        PathSum pS = new PathSum();
        TreeNode tree = buildTree();
        System.out.println(pS.pathSum(tree, 22));

    }

    // 思路，将所有路径都存入，然后判断是否是目标值
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, int toal, List<Integer> list, List<List<Integer>> res) {
        // 判空
        if (root == null) {
            return;
        }
        // 放入
        list.add(new Integer(root.val));
        // 临时值，为了和sum比较
        toal += root.val;
        // 如果是叶子节点，走不动了记得返回。
        if (root.left == null && root.right == null) {
            // 如果和sum相等，就将路径存入res结果
            if (sum == toal) {
                res.add(new ArrayList(list));
            }
            // 由于最后一个元素不会加入，就return了，所以在这之前把最后的节点remove
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, sum, toal, list, res);
        dfs(root.right, sum, toal, list, res);
        //
        list.remove(list.size() - 1);
    }

    // 生成树
    public static TreeNode buildTree() {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t6.left = t9;
        t6.right = t10;
        return t1;
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
