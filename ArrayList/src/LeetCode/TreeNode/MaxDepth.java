package LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Wdz
 * @Date 2020/9/26 11:03
 * @Description: 二叉树的最大深度
 */
public class MaxDepth {
    public static void main(String[] args) {


    }

    public int maxDepth(TreeNode root) {
        // if(root == null) return 0;
        // return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        // 判空处理
        if (root == null) {
            return lists;
        }
        // 这里存放树的节点
        List<TreeNode> nodes = new ArrayList<>();
        // 先把root节点加入节点集合
        nodes.add(root);
        // 如果节点集合有节点需要遍历
        while (!nodes.isEmpty()) {
            // 设置遍历集合大小
            int size = nodes.size();
            // 存放数据
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 取出第一集合元素，按照加入集合顺序打印
                TreeNode remove = nodes.remove(0);
                // 把节点（类似于根节点）信息加入信息集合
                list.add(remove.val);
                if (remove.left != null) {
                    // 如果有左孩子先加左孩子
                    nodes.add(remove.left);
                }
                if (remove.right != null) {
                    // 如果有右孩子加入右孩子
                    nodes.add(remove.right);
                }
            }
            // 本次数据加入总的数据集合中
            lists.add(list);
        }
        return lists;
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
