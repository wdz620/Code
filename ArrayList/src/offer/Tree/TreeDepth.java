package offer.Tree;

/**
 * @Author: Wdz
 * @Date 2020/10/28 10:22
 * @Description: 38、二叉树的深度
 */
public class TreeDepth {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public int treeDepth(TreeNode root) {
        if (root==null) return 0;
        else return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

}
