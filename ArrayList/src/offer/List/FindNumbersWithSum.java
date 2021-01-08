package offer.List;

import java.util.ArrayList;

/**
 * @Author: Wdz
 * @Date 2020/10/21 20:31
 * @Description:
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 注意：递增
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6};
        ArrayList<Integer> list = findNumbersWithSum(array, 5);
        System.out.println(list);
    }

    //自答
    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = array.length - 1, temp;
        while (i < j) {
            temp = array[i] + array[j];
            if (sum == temp) {
                res.add(array[i]);
                res.add(array[j]);
                return res;
            }
            if (temp < sum) {
                i++;
            }
            if (temp > sum) {
                j--;
            }
        }
        return res;
    }
}
