package leetcode.List;

/**
 * @Author: Wdz
 * @Date 2020/11/3 8:22
 * @Description: 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * 输入：[2,1]
 * 输出：false
 *
 * 输入：[3,5,5]
 * 输出：false
 *
 * 输入：[0,3,2,1]
 * 输出：true
 */
public class ValidMountainArray {
    //自答:找到转折点，转折点前面的都小，转折之后都是大的
    //法一：暴力,考虑相等的情况了吗,转折点前后必须都有值
    //考虑不全，1、转折点寻找；2、相等的情况；3、转折点左右是否是否有值；4、是否递增和递减
    //解决：抓住一点，最后是否遍历到数组末尾！就可以解决124这三种；然后在加上3就完成了！！！
    public static boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }
    //考虑使用双指针
    //思路：头尾指针分别向中间行进，最后是否能在山顶相遇
    public static boolean validMountainArray1(int[] A) {
        if(A.length < 3) return false;
        int left = 0, right = A.length - 1;
        while (left < A.length - 2 && A[left] < A[left + 1])//注意循环完毕后,left指针只能到数组倒数第二个数位置
            left++;
        while (right > 1 && A[right] < A[right - 1])//和left指针条件一样
            right--;
        //是否能在山顶相遇
        return left == right;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 2, 1, 0};
        System.out.println(validMountainArray1(nums));

    }

}
