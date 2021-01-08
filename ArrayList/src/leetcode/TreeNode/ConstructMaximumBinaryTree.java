package leetcode.TreeNode;

import java.util.Stack;

/**
 * @Author: Wdz
 * @Date 2020/10/29 8:19
 * @Description: 654. 最大二叉树
 * <p>
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 *      6
 *    /   \
 *   3     5
 *   \    /
 *    2  0
 *     \
 *      1
 */
public class ConstructMaximumBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        // 递归终止
        if (low > high) {
            return null;
        }
        // 找到最大数值的数值和索引
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        // 创建树
        TreeNode root = new TreeNode(maxVal);
        // 递归创建左右子树
        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, high);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        ConstructMaximumBinaryTree c = new ConstructMaximumBinaryTree();
        TreeNode tree = c.constructMaximumBinaryTree(nums); //6 3 2 1 5 0
        /**树的前序遍历*/
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
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
}
