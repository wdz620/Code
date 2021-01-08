package leetcode.TreeNode;

import java.util.*;

/**
 * @Author: Wdz
 * @Date 2020/11/11 10:28
 * @Description: 199 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class RightSideView {

    // 先来复习一遍树的遍历
    // DFS前序遍历
    private static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // DFS中序遍历
    private static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.print(pop.val);
                root = pop.right;
            }
        }
    }

    // DFS后序遍历
    private static void postOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode pop = s1.pop();
            s2.push(pop);
            if (pop.left != null)
                s1.push(pop.left);
            if (pop.right != null)
                s1.push(pop.right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val);
        }
    }

    // BFS层序遍历
    private static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每次遍历的数量为队列的长度
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            // 将每一层取出
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.print(tmp);

        }
    }

    // 自答:使用BFS层序遍历的方式，将每一层最后一个元素放入集合可以了。
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每次遍历的数量为队列的长度
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    // 考虑一下左视图呢
    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每次遍历的数量为队列的长度
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if (i == 0) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        t3.right = t4;
        // 前序遍历结果 12534
        preOrder(t1);
        System.out.println();
        // 中序遍历  25134
        inOrder(t1);
        System.out.println();
        // 后序遍历 52431
        postOrder(t1);
        System.out.println();
        // 层序遍历 1 23 54
        levelOrder(t1);
        System.out.println();

        // 测试
        System.out.println(rightSideView(t1)); //134

        RightSideView r = new RightSideView();
        System.out.println(r.rightSideView1(t1)); //134

        System.out.println("左视图"); // 125
        System.out.println(leftSideView(t1));
    }

    // 使用DFS尝试
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root, 0); // 从根节点开始，根节点深度为0
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        // 先访问 当前节点，在递归访问 右子树 和 左子树
        if (depth == res.size())
            //如果当前节点所在深度没有出现在res里，
            // 说明在该深度下当前节点所在深度还没有出现在res里，
            // 说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }

    // 官方的DFS ； 不太友好
    public List<Integer> rightSideView2(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
