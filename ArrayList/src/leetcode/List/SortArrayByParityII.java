package leetcode.List;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2020/11/12 9:07
 * @Description: 922. 按奇偶排序数组 II
 * <p>
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * 知识点：
 * if ((j&1) != 1) // 判断偶数
 * if ((i&1) == 1) // 判断奇数
 */
public class SortArrayByParityII {
    // 尝试使用双指针，审题的指，奇数偶数各占一半，所以拍好了偶数，奇数自然就排列好了。
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int[] ans = new int[n];

        int i = 0;
        for (int x : A) {
            if (x % 2 == 0) {
                ans[i] = x;
                i += 2;
            }
        }
        i = 1;
        for (int x : A) {
            if (x % 2 == 1) {
                ans[i] = x;
                i += 2;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        SortArrayByParityII s = new SortArrayByParityII();
        System.out.println(Arrays.toString(s.sortArrayByParityII1(nums)));

    }

    // 双指针解法
    public int[] sortArrayByParityII1(int[] A) {
        if (A == null || A.length == 0) return A;
        int odd = 1;
        for (int i = 0; i < A.length; i += 2) {
            //如果是偶数，不操作
            if (A[i] % 2 == 0) continue;
            //如果不是偶数，在奇数位里找一个偶数换过来
            while (A[odd] % 2 != 0) {
                odd += 2;
            }
            swap(A, odd, i);
        }
        return A;
    }
    public void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
