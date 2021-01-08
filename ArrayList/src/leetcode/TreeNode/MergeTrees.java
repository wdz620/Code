package leetcode.TreeNode;

import java.util.LinkedList;

/**
 * @Author: Wdz
 * @Date 2020/10/30 13:45
 * @Description: 617、合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class MergeTrees {
    //递归
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 如果 t1和t2中，只要有一个是null，函数就直接返回
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        //让t1的值等于t1和t2的值累加，再递归的计算两颗树的左节点、右节点
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    //迭代使用广度优先遍历
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        //如果 t1和t2中，只要有一个是null，函数就直接返回
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(t1);
        queue.add(t2);
        while (queue.size() > 0) {
            TreeNode r1 = queue.remove();
            TreeNode r2 = queue.remove();
            r1.val += r2.val;
            //如果r1和r2的左子树都不为空，就放到队列中
            //如果r1的左子树为空，就把r2的左子树挂到r1的左子树上
            if (r1.left != null && r2.left != null) {
                queue.add(r1.left);
                queue.add(r2.left);
            } else if (r1.left == null) {
                r1.left = r2.left;
            }
            //对于右子树也是一样的
            if (r1.right != null && r2.right != null) {
                queue.add(r1.right);
                queue.add(r2.right);
            } else if (r1.right == null) {
                r1.right = r2.right;
            }
        }
        return t1;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
