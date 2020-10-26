package Offer.Tree;

import java.util.Stack;

/**
 * @Author: Wdz
 * @Date 2020/10/11 9:26 TODO
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubTree {

    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        return false;

    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
