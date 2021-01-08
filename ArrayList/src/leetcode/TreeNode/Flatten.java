package leetcode.TreeNode;

/**
 * @Author: Wdz
 * @Date 2020/10/28 10:56
 * @Description: TODO 114、二叉树展开为链表
 */
public class Flatten {
    public class TreeNode {
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        //排序完成
        TreeNode left = root.left;
        TreeNode right = root.right;
        //将左子树作为右子树
        root.left = null;
        root.right = left;
        //将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
