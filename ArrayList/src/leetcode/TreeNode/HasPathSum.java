package leetcode.TreeNode;

/**
 * @Author: Wdz
 * @Date 2020/10/30 10:13
 * @Description: 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *  返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2
 */
public class HasPathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //第一种方法是，声明一个变量记录已经经过的节点的值之和，每经过一个节点就加上这个节点的值，在叶子节点判断变量值是否为目标值。
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //判断叶子结点
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        //递归
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    //第二种方法：从根节点开始，每当遇到一个节点的时候，从目标值里扣除节点值，一直到叶子节点判断目标值是不是被扣完。
    public boolean hasPathSum1(TreeNode root, int sum) {
        return  helper(root,0,sum);
    }

    public boolean helper(TreeNode root, int cur, int sum) {
        if (root == null)
            return false;
        cur = cur + root.val;
        if (root.left == null && root.right == null) {
            return cur == sum;
        } else {
            return helper(root.left, cur, sum) || helper(root.right, cur, sum);
        }
    }

    public static void main(String[] args) {
        int i = 1;
    }





}
