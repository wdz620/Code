package leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Wdz
 * @Date 2020/10/30 8:21
 * @Description: TODO 652 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *           1
 *        /    \
 *       2      3
 *      /      / \
 *     4      2   4
 *          /
 *         4
 * <p>
 *     2
 *   /          和    4
 * 4
 */
public class FindDuplicateSubtrees {
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

    /**
     * 思路：
     * 以单个结点为突破口，比如说站在2上思考：
     * 1、以我为根的这棵二叉树（子树）长啥样？
     * 我如何才能知道以自己为根的二叉树长啥样？
     * 其实看到这个问题，就可以判断本题要使用「后序遍历」
     * 知道你会问一个为什么 ->很简单呀，我要知道以自己为根的子树长啥样，是不是得先知道我的左右子树长啥样，再加上自己，就构成了整棵子树的样子？
     *
     * 2、以其他节点为根的子树都长啥样？
     * 这很简单呀，我们借助一个外部数据结构，让每个节点把自己子树的序列化结果存进去，这样，对于每个节点，不就可以知道有没有其他节点的子树和自己重复了么？
     *
     * 其实这个题难点在于自己不知道该怎么进行树的序列化
     */

    // 记录所有子树以及出现的次数，当然可以使用HashSet,但是题目要求不要返回重复的子树，只返回一个就可以了，所以改用HashMap
    HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();

    /* 主函数 */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    /* 辅助函数 */
    public String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right+ "," + root.val;
        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }

    //复习后序遍历非递归
    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if (pop.left!=null) stack1.push(pop.left);
            if (pop.right!=null) stack1.push(pop.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val+" ");
        }
    }

    //后序遍历递归
    public void postOrder1(TreeNode root) {
        if (root == null) return;
        postOrder1(root.left);
        postOrder1(root.right);
        System.out.println(root.val + " ");
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t44 = new TreeNode(4);
        TreeNode t444 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t22;
        t3.right = t44;
        t22.left = t444;
        FindDuplicateSubtrees f = new FindDuplicateSubtrees();
        List<TreeNode> list = f.findDuplicateSubtrees(t1);
        for (TreeNode t : list) {
            System.out.println("每个根结点：" + t.val);
        }
    }
    //Another solution 和前面的换汤不换药，吧后序变成了前序
    public LinkedList<TreeNode> result = new LinkedList<>();
    public HashMap<String,Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        if(root == null){
            return result;
        }
        serialize(root);
        return result;
    }

    public String serialize(TreeNode root){
        if(root == null){
            return "null";
        }
        //序列化以当前节点为根节点的二叉树
        String str = serialize(root.left) + ","+ root.val + ","+ serialize(root.right);
        //使用一个HashMap来记录所有的子树的序列
        map.put(str,map.getOrDefault(str,0)+1);
        //当其value为2时，则表示出现了重复结构，将这个子树的根节点放入到结果当中。
        if(map.get(str) == 2){
            result.add(root);
        }
        return str;
    }
}
