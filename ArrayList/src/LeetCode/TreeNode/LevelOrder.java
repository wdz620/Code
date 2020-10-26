package LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: Wdz
 * @Date 2020/9/26 11:10
 * @Description:
 */
public class LevelOrder {
    public static void main(String[] args) {
        //创建二叉树
        BiTreeNode t = new BiTreeNode("A");
        t.left = new BiTreeNode("B");
        t.right = new BiTreeNode("C");
        t.left.left = new BiTreeNode("D");
        t.left.left.right = new BiTreeNode("G");
        t.right.left = new BiTreeNode("E");
        t.right.right = new BiTreeNode("F");

        //执行层序遍历方法
//        levelOrder(t);
    }

    //
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        //创建一个队列，将根节点放入其中
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            //每次遍历的数量为队列的长度
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将这一层的元素全部取出，放入到临时数组中，如果节点的左右孩子不为空，继续放入队列
            for(int i=0;i<size;++i) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    /*
     * 层序遍历方法
     * 参数为二叉树的根节点
     */
    public static void levelOrder(BiTreeNode t) {
        if (t == null)
            return;
        Queue<BiTreeNode> queue = new LinkedBlockingQueue<>();
        BiTreeNode curr;
        queue.add(t);
        while (!queue.isEmpty()) {
            curr = queue.remove();
            System.out.print(curr.value);
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }




    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = q.peek();
                q.poll();
                if(cur == null) continue;
                level.add(cur.val);
                q.offer(cur.left);
                q.offer(cur.right);
            }
            if(!level.isEmpty())res.add(level);
        }
        return res;
    }

    //创建二叉树类
    public static class BiTreeNode {

        String value; //结点值
        BiTreeNode left; //左子树结点
        BiTreeNode right; //右子树结点

        public BiTreeNode(String value) { //构造方法
            this.value = value;
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}


