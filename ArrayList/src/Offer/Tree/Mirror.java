package Offer.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Wdz
 * @Date 2020/10/11 9:27
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像
 *
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class Mirror {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        treeDFS3(t1); //5 7 6 9 11 10 8


    }

    //BFS解决
    //二叉树的BFS代码如下
    public static void levelOrder(TreeNode tree) {
        if (tree == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree); //相当于把数据加入到队列尾部
        while (!queue.isEmpty()) {
            //poll方法相当于移除队列头部的元素
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //参考上述方法进行改进：每次遍历节点的时候交换子节点
    public static TreeNode invertTreeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    //DFS解决
    //前序遍历
    public static void treeDFS1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            //关键点在于先存右孩子，这样就能返回到上一层（因为前序：根左右。当根和左弹出，不利于右的遍历）！
            if (pop.right!=null) stack.push(pop.right);
            if (pop.left!=null) stack.push(pop.left);
        }
    }
    //按照前序修改
    public static TreeNode invertTreeDFS1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
            if (pop.right!=null) stack.push(pop.right);
            if (pop.left!=null) stack.push(pop.left);
        }
        return root;
    }

    //中序遍历
    public static void treeDFS2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                System.out.print(temp.val + " ");
                //关键点
                root = temp.right;
            }
        }
    }
    //按照中序修改:注意到参数引用的问题！
    public static TreeNode invertTreeDFS2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                //交换
                TreeNode left = pop.left;
                pop.left = pop.right;
                pop.right = left;
                //注意；此时应该使用交换后的
                node = pop.left;
            }
        }
        return root;
    }

    //后续遍历
    public static void treeDFS3(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null) stack1.push(pop.left);
            if (pop.right != null) stack1.push(pop.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val+" ");
        }
    }

    //按照后续遍历修改 TODO 后序实现镜像二叉树！
    public static TreeNode inverTreeDFS3(TreeNode root) {
        return root;
    }




    //自答
    public void mirror(TreeNode root) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                mirror(root.left);
                mirror(root.right);
            }
        }

    }

    public static class TreeNode {
        int val = 0;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
