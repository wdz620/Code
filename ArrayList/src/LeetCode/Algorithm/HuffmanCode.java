package LeetCode.Algorithm;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Wdz
 * @Date 2020/10/21 9:33
 * @Description: 哈夫曼编码
 */
public class HuffmanCode extends CreateHuffman {
    private Node root;
    private Node[] nodes;

    //构建哈夫曼树代码见前一个类
    public void createHuffmanTree(int[] weights) {
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

    //输入字符下表，输出对应的哈夫曼编码
    public String converHuffmanCode(int index) {
        return nodes[index].code;
    }

    //用递归的方式，填充各个结点的二进制编码
    public void encode(Node node, String code) {
        if (node == null) return;
        node.code = code;
        encode(node.lChild, node.code + "0");
        encode(node.rChild, node.code + "1");
    }

    public static class Node implements Comparable<Node> {
        int weight;
        //结点对应的二进制编码
        String code;
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
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};
        int[] weights = {2, 3, 7, 9, 18, 25};
        HuffmanCode huffmanCode = new HuffmanCode();
        huffmanCode.createHuffmanTree(weights);
        huffmanCode.encode(huffmanCode.root, "");
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i] + ":" + huffmanCode.converHuffmanCode(i));
        }

    }
}
