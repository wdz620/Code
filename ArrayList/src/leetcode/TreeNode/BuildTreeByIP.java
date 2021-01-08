package leetcode.TreeNode;

import java.util.Stack;

/**
 * @Author: Wdz
 * @Date 2020/10/29 8:55
 * @Description: 106. 从中序与后序遍历序列构造二叉树 TODO 经典构造树(中后)
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *       3
 *     /   \
 *    9    20
 *        /  \
 *       15   7
 */
public class BuildTreeByIP {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        //递归终止
        if (inStart > inEnd) {
            return null;
        }

        //root结点对应的就是后序遍历的最后一个元素
        int rootVal = postorder[postEnd];
        //rootVal在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        //递归构造
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;

    }

    public void preRes(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
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
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        BuildTreeByIP byIP = new BuildTreeByIP();
        TreeNode tree = byIP.buildTree(inorder, postorder);

        byIP.preRes(tree);//3 9 20 15 7

    }
}
