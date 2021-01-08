package leetcode.TreeNode;

import java.sql.SQLException;
import java.util.*;

/**
 * @Author: Wdz
 * @Date 2020/9/11 10:35
 * @Description: input:
 * 15
 * 15 7 20 -1 -1 3 12 -1 -1 -1 -1 14 8 -1 -1
 * 2 4
 * output:
 * 7 20
 * 3 12
 * 14 8
 */
public class TreeDemo {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        //李
        Bst(n,a,a1,a2);
        //赵
//        List<List<Integer>> bfs = bfs(a, a1, a2);
//        for (List<Integer> list : bfs) {
//            for (int i = 0; i < list.size() - 1; i++) {
//                System.out.print(list.get(i) + " ");
//            }
//            System.out.println(list.get(list.size() - 1));
//        }
    }

    /**
     * 李宏达解法
     * @param n
     * @param a
     * @param a1
     * @param a2
     */
    public static void Bst(int n,int[] a,int a1,int a2) {
        int c = 1;      //层数（默认第一层）
        int num = 1;    //该层应该有几个数（默认第一层有一个） 1 2 4 8 所以使用 num = num * 2;
        int cnum = 0;   //当cnum=num时就代表这一层到达最后一个元素。
        for (int i = 0; i < n; i++) {
            if (c >= a1 && c <= a2 && a[i] != -1)
                System.out.print(a[i] + " ");
            cnum++;
            if (cnum == num) {
                cnum = 0;
                num *= 2;
                c++;
                if (c > a1)
                    System.out.println();
                if (c > a2)
                    break;
            }
        }
    }

    //赵雷树的解法(有问题)
    private static List<List<Integer>> bfs(int[] tree, int levelA, int levelB) {
        List<List<Integer>> res = new ArrayList<>();
        if (tree == null || tree.length == 0 || levelA > levelB) return res;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // 存索引
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                int  rootIdx = queue.poll();
                curLevel.add(tree[rootIdx]);
                int leftIdx = 2 * rootIdx + 1;
                int rightIdx = 2 * rootIdx + 1;
                if(leftIdx <= tree.length-1 && tree[leftIdx]!=-1) queue.offer(leftIdx);
                if (rightIdx <= tree.length && tree[rightIdx]!=-1) queue.offer(rightIdx);
            }
            res.add(curLevel);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = levelA; i < levelB + 1; i++) {
            ans.add(res.get(i - 1));
        }
        return ans;
    }

}
