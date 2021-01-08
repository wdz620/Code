package cn.netstudy;

/**
 * @Author: Wdz
 * @Date 2020/10/28 9:41
 * @Description: 归并排序和二叉树的关系
 * 归并排序 约等于 二叉树的后序遍历
 */
public class TreeAndMerge {
    //细品，您细品。 是不是发现先对左右子数组排序，然后在进行合并，是不是有点二叉树的后序遍历的味道。
    public static int[] mergeSort(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
        return array;
    }
    private static int[] merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low; // 左指针
        int j = mid + 1; // 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = array[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            array[k2 + low] = temp[k2];
        }
        return array;
    }


}
