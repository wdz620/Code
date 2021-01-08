package cn.netstudy;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2020/10/28 8:17
 * @Description: 二叉树和快速排序的关系
 * 快速排序 约等于 二叉树的前序遍历
 * 同理：去比较一下归并排序和二叉树的关系
 */
public class TreeAndQuick {
    //基础快速 垃圾 只能排序正数
    public static void dutchFlag(int[] arr, int num) {
        int less = -1;
        int more = arr.length;
        int curr = 0;
        int temp = 0;
        while (curr < more) {
            if (arr[curr] < num) {
                temp = arr[curr];
                arr[curr] = arr[++less];
                arr[less] = temp;
            } else if (arr[curr] > num) {
                temp = arr[curr];
                arr[curr] = arr[--more];
                arr[more] = temp;
            } else {
                curr++;
            }
        }
    }

    //细品，您细品！ 先找基准，然后去左右自数组继续构造，是不是惊奇的发现和二叉树的前序遍历相似！
    public int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int q = partition(array, low, high); //q 基准值
            quickSort(array, low, q - 1);
            quickSort(array, q + 1, high);
        }
        return array;
    }
    /**
     * 算法导论——快速排序
     * @param array
     * @param low
     * @param high  不能超过数组的最大长度，即 0<high<= array.length-1
     * @return
     */
    private int partition(int[] array, int low, int high) {
        int x = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    //另外一种思路的快排的两种实现方式

    /**
     * 左边的都小于等于 pivot，右边的都大于pivot
     * @param arr 待排序数组
     * @param l 数组左边界
     * @param r 数组右边界
     * @return 枢轴索引
     */
    private int partition1(int[] arr, int l, int r) {
        int x = arr[l]; //  选左
        int i = l, j = r;
        while (i < j) {
            while (arr[j] > x && i < j) --j;
            while (arr[i] <= x && i < j) ++i;
            swap(arr, i, j);
        }
        swap(arr, l, i);
        return i;
    }

    /**
     * 左边的都小于等于 pivot，右边的都大于pivot
     * @param arr 待排序数组
     * @param l 数组左边界
     * @param r 数组右边界
     * @return 枢轴索引
     */
    private int partition2(int[] arr, int l, int r) {
        int x = arr[r]; // 选右
        int i = l, j = r;
        while (i < j) {
            while (arr[i] < x && i < j) ++i;
            while (arr[j] >= x && i < j) --j;
            swap(arr, i, j);
        }
        swap(arr, i, r);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    //产生随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] nums = {5, 7, 5, 8, 1, 9, 10};
        int num = 5;
        System.out.println(Arrays.toString(nums));
        dutchFlag(nums, num);
        System.out.println(Arrays.toString(nums));
        System.out.println("======");

        TreeAndQuick treeAndQuick = new TreeAndQuick();
        int[] nums1 = generateRandomArray(20, 30);
        System.out.println(Arrays.toString(nums1));
        int[] ints = treeAndQuick.quickSort(nums1, 0, nums1.length-1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(ints));

    }
}
