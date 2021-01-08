package leetcode.Algorithm;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Wdz
 * @Date 2020/10/14 10:45
 * @Description: 创建哈夫曼树
 * 知识点：
 *      为了保证节点队列当中的结点始终按照权值升序排序，这里使用了优先队列->PriorityQueue
 *      与此同时，静态内部类Node需要实现比较接口，重写compareTo方法，以此保证Node对象在进入队列按照权值来进行比较。
 */
public class CreateHuffman {
    private Node root;
    private Node[] nodes;

    public void createHuffman(int[] weights) {
        //优先队列，用于辅助构建哈夫曼树
        Queue<Node> nodeQueue = new PriorityQueue<>();
        nodes = new Node[weights.length];
        //构建森林，初始化nodes数组
        for (int i = 0; i < weights.length; i++) {
            nodes[i] = new Node(weights[i]);
            nodeQueue.add(nodes[i]);
        }
        //主循环，当结点队列只剩一个结点时结束
        while (nodeQueue.size() > 1) {
            //从结点队列选择权值最小的两个结点
            Node left = nodeQueue.poll();
            Node right = nodeQueue.poll();
            //创建新结点作为两结点的父节点
            Node parent = new Node(left.weight + right.weight, left, right);
            nodeQueue.add(parent);
        }
        root = nodeQueue.poll();
    }

    //按照前序遍历输出(递归)
    public void output(Node head) {
        if (head == null) return;
        System.out.print(head.weight + " ");
        output(head.lChild);
        output(head.rChild);
    }

    public static class Node implements Comparable<Node> {
        int weight;
        Node lChild;
        Node rChild;

        public Node(int weight) {
            this.weight = weight;
        }

        public Node(int weight, Node lChild, Node rChild) {
            this.weight = weight;
            this.lChild = lChild;
            this.rChild = rChild;
        }
        @Override
        public int compareTo(Node o) {
            return new Integer(this.weight).compareTo(new Integer(o.weight));
        }
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 7, 9, 18, 25};
        CreateHuffman huffmanTree = new CreateHuffman();
        huffmanTree.createHuffman(weights);
        huffmanTree.output(huffmanTree.root);
    }
}
