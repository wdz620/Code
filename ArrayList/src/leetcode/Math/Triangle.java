package leetcode.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wdz
 * @Date 2020/11/18 10:52
 * @Description: 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Triangle {
    // 学习
    public void demo(int row) {
        int[][] yanghui = new int[row][row];
        for (int i = 0; i < row; i++) {//行
            for (int j = 0; j <= i; j++) {//列
                if (j == 0 || j == i) {
                    yanghui[i][j] = 1;
                } else {
                    yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];
                }
                System.out.print(yanghui[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 自答
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        int[][] data = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) { // 行
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j <= i; j++) { // 列
                if (j == 0 || j == i) {
                    data[i][j] = 1;
                } else {
                    data[i][j] = data[i - 1][j - 1] + data[i - 1][j];
                }
                rowList.add(data[i][j]);
            }
            res.add(rowList);
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    // 119 杨辉三角II
    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> res = new ArrayList<>();
        if (rowIndex == 0)
            return res;
        int[][] data = new int[rowIndex][rowIndex];
        for (int i = 0; i < rowIndex; i++) { // 行
            for (int j = 0; j <= i; j++) { // 列
                if (j == 0 || j == i) {
                    data[i][j] = 1;
                } else {
                    data[i][j] = data[i - 1][j - 1] + data[i - 1][j];
                }
            }
        }
        for (int i = 0; i < rowIndex; i++) {
            System.out.println(data[rowIndex-1][i]);
        }
        return res;
    }
    // 杨辉II 参考 TODO 杨辉II


    // 杨辉I：参考
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    // 杨辉I ：递归方法 参考
    int[][] storage = null;
    public List<List<Integer>> generate2(int numRows) {
        storage = new int[numRows][numRows];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                rows.add(generateX(i, j));
            }
            list.add(rows);
        }
        return list;
    }
    private int generateX(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        }
        if (storage[i][j] == 0) {
            storage[i][j] = generateX(i - 1, j - 1) + generateX(i - 1, j);
        }
        return storage[i][j];
    }

}
