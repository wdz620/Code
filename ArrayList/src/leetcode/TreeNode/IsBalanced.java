package leetcode.TreeNode;

/**
 * @Author: Wdz
 * @Date 2020/11/12 13:35
 * @Description: 110、平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * 输入：root = []
 * 输出：true
 *
 * [1,2,2,3,null,null,3,4,null,null,4] false
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        //左右两个子树都是一棵平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t33 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t44 = new TreeNode(4);
        t1.left = t2;
        t1.right = t22;
        t2.left = t3;
        t22.right = t33;
        t3.left = t4;
        t33.right = t44;
        IsBalanced is = new IsBalanced();
        System.out.println(is.isBalanced(t1));
    }


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
}
