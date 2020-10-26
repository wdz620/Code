package LeetCode.Algorithm;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2020/10/25 15:56 TODO 归并排序
 * @Description: 归并排序，时间复杂度为O(N*logN)，空间复杂度为O(N)
 * https://zhuanlan.zhihu.com/p/102289147
 */
public class MergeSort {
    public static void MergeSort(int[] arr, int start, int end) {
        //分治的结束条件
        if (start >= end) {
            return;
        }
        //保证不溢出取start和end的中位数
        int mid = start + ((end - start) >> 1);
        //递归排序并且合并
        MergeSort(arr, start, mid);
        MergeSort(arr, mid + 1, end);
        Merge(arr, start, mid, end);
    }

    //合并
    public static void Merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= end) {
            if (arr[p1] > arr[p2]) {
                temp[p++] = arr[p2++];
            } else {
                temp[p++] = arr[p1++];
            }
        }
        while (p1 <= mid) {
            temp[p++] = arr[p1++];
        }
        while (p2 <= end) {
            temp[p++] = arr[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i + start] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 1, 3, 7, 9, 8, 5};
        MergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

}
