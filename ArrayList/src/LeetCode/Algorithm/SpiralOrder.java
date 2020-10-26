package LeetCode.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Wdz
 * @Date 2020/10/11 10:31
 * @Description: 顺时针遍历二维数组
 */
public class SpiralOrder {
    //小灰
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        //当二维数组是空或任何一个维度是0，直接返回
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        //m是矩阵的行数
        int m = matrix.length;
        //n是矩阵的列数
        int n = matrix[0].length;
        //大循环，从外向内逐层遍历矩阵
        for (int i = 0; i < (Math.min(m, n) + 1) / 2; i++) {
            //从左到右遍历"上边"
            for (int j = i; j < n - i; j++) {
                list.add(matrix[i][j]);
            }
            //从上到下遍历"右边"
            for (int j = i + 1; j < m - i; j++) {
                list.add(matrix[j][(n - 1) - i]);
            }
            //从右到左遍历"下边"
            for (int j = i + 1; j < n - i; j++) {
                list.add(matrix[(m - 1) - i][(n - 1) - j]);
            }
            //从下到上遍历"左边"
            for (int j = i + 1; j < m - 1 - i; j++) {
                list.add(matrix[(m - 1) - j][i]);
            }
        }
        return list;
    }

    //剑指Offer
    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            //从左往右
            for (int c = c1; c <= c2; c++) {
                res.add(matrix[r1][c]);
            }
            //从上到下
            for (int r = r1 + 1; r <= r2; r++) {
                res.add(matrix[r][c2]);
            }
            //判断是否会重复打印
            if (r1 < r2 && c1 < c2) {
                //从右到左
                for (int c = c2 - 1; c > c1; c--) {
                    res.add(matrix[r2][c]);
                }
                //从下到上
                for (int r = r2; r > r1; r--) {
                    res.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                { 21, 22, 23, 24, 25 }
        };
        List<Integer> res = spiralOrder(matrix);
        System.out.println(Arrays.toString(res.toArray()));
        System.out.println(Arrays.toString(spiralOrder1(matrix).toArray()));
        System.out.println();
        List<Integer> res2 = spiralOrder(matrix2);
        System.out.println(Arrays.toString(res2.toArray()));
        System.out.println(Arrays.toString(spiralOrder1(matrix2).toArray()));
    }


}
