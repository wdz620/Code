package realtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: Wdz
 * @Date 2021/1/6 21:41
 * @Description: 将满二叉树转换为求和树
 * 描述：
 * 给出满二叉树，编写算法将其转化为求和树
 * 什么是求和树：二叉树的求和树， 是一颗同样结构的二叉树，其树中的每个节点将包含原始树中的左子树和右子树的和。
 * 二叉树：
 *      10
 *   /      \
 *   -2        6
 * /   \      /  \
 * 8    -4    7    5
 *
 * 求和树：
 *    20(4-2+12+6)
 *     /      \
 *  4(8-4)      12(7+5)
 * /   \      /  \
 * 0      0    0    0
 *
 * 二叉树给出前序和中序输入，求和树要求中序输出；
 * 所有处理数据不会大于int；
 *
 * 输入：2行整数，第1行表示二叉树的前序遍历，第2行表示二叉树的中序遍历，以空格分割
 * 输出：1行整数，表示求和树的中序遍历，以空格分割
 *
 * 输入：
 * 10 -2 8 -4 6 7 5
 * 8 -2 -4 10 7 6 5
 * 输出：
 * 0 4 0 20 0 12 0
 *
 * TODO 为什么给两个呢？是不是可以根据前序和中序的结合简便运算呢？
 */
public class KS_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bf.readLine();
        String s2 = bf.readLine();

        String[] preOrder = s1.split(" ");
        String[] inOrder = s2.split(" ");
        int[] res = new int[inOrder.length];

        for (int i = 0; i < inOrder.length; i++) {
            res[i] = Integer.valueOf(inOrder[i]);
        }

        dfs(res, 0, inOrder.length - 1);

        for (int r : res) System.out.print(r + " ");
    }

    private static int dfs(int[] res, int left, int right) {
        if (left == right) {
            int temp = res[left];
            res[left] = 0;
            return temp;
        }

        int mid = (right - left) / 2 + left;
        int leftSum = dfs(res, left, mid - 1);
        int rightSum = dfs(res, mid + 1, right);
        int temp = res[mid];
        res[mid] = leftSum + rightSum;
        return res[mid] + temp;
    }

}
