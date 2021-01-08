package leetcode.TreeNode;

/**
 * @Author: Wdz
 * @Date 2020/11/4 8:24
 * @Description: 101、对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class IsSymmetric {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    /*
    递归结束条件：
        都为空指针则返回 true
        只有一个为空则返回 false
    递归过程：
        判断两个指针当前节点值是否相等
        判断 A 的右子树与 B 的左子树是否对称
        判断 A 的左子树与 B 的右子树是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }
        return (root.val == root1.val) && isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
    }

}
