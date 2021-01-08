package leetcode.TreeNode;

import java.util.Stack;

/**
 * @Author: Wdz
 * @Date 2020/10/29 8:54
 * @Description: 105. 从前序与中序遍历序列构造二叉树 TODO 经典构造数(前中)
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *       3
 *     /   \
 *    9    20
 *        /  \
 *       15   7
 */
public class BuildTreeByPI {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /* 主函数 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /*
       若前序遍历数组为 preorder[preStart..preEnd]，
       后续遍历数组为 postorder[postStart..postEnd]，
       构造二叉树，返回该二叉树的根节点
    */
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //递归终止
        if (preStart > preEnd) {
            return null;
        }
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

    public void preRes(TreeNode root) {
        /**前序遍历 */
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop(); //3 9 20 15 7
            System.out.print(pop.val + " ");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BuildTreeByPI tree = new BuildTreeByPI();
        TreeNode node = tree.buildTree(preorder, inorder);

        //前序验证结果  3 9 20 15 7
        tree.preRes(node);

     }
}
