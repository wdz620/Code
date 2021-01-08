package leetcode.List;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2020/11/14 8:55
 * @Description: 1122. 数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 */
public class RelativeSortArray {
    // 参考
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        // 思路：注意提示要求小于1000
        int[] temp = new int[1001];

        // 第一步: 将arr1放入暂存记录下来
        for (int i = 0; i < arr1.length; i++) {
            temp[arr1[i]]++;
        }

        // 第二步：将arr2的放入res，更新暂存
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (temp[arr2[i]] > 0) {
                res[index++] = arr2[i];
                temp[arr2[i]]--;
            }
        }

        // 第三步：将arr1独有的加入res，就是将暂存加入其中。
        for (int i = 0; i < 1001; i++) {
            while (temp[i] > 0) {
                res[index++] = i;
                temp[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] sortArray = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(sortArray));
    }

}
