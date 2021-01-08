package leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Wdz
 * @Date 2020/11/12 11:01
 * @Description: 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 *   给定有序数组: [-10,-3,0,5,9],
 *
 *   一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *         0
 *        / \
 *      -3   9
 *      /   /
 *    -10  5
 *
 * 变形: 109 数组改成链表
 *      给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *      本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 *      解题思路：
 *         1、 在单独定义一个找中间节点的方法。看看是否可行
 *             或者直接通过遍历链表，将其变成一个数组，然后再调用下面的方法。 可以，但是效率很低
 *         2、考虑使用 TODO 109 、双指针解决
 *            其中还需将链表一分为二的操作，在找到中间节点的时候，断开。
 *            通过快慢指针法找到中间节点
 *            构造树，中间节点，左子树(head到断开处),右子树（断开到结尾)
 *            注意：边界条件，递归终止条件。以及构造树的条件。
 *
 */
public class SortedArrayToBST {
    // 使用二分法思想,确定中间值作为根
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, low, mid - 1);
        root.right = build(nums, mid + 1, high);
        return root;
    }

    // 复习层序遍历
    private void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每次遍历的数量为队列的长度
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            // 将每一层输出
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                temp.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        SortedArrayToBST s = new SortedArrayToBST();
        TreeNode node = s.sortedArrayToBST(nums);
        s.levelOrder(node);
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
