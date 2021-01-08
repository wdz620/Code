package offer.List;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2021/1/5 21:52
 * @Description: 51、构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 *
 * [1,2,3,4,5]
 *
 * [120,60,40,30,24]
 */
public class Multiply {
    // 自答
    public static int[] multiply(int[] A) {
        /*
        思路：分成两部分的乘积，第一部分可以自上而下，第二部分自下而上
        */
        if (A == null || A.length < 1)
            return A;
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        for (int i = 1; i < len; i++) //第一部分可以自上而下
            B[i] = B[i - 1] * A[i - 1];

        int temp = 1;  //temp用来保存第二部分
        for (int i = len - 2; i >= 0; i--) { //第二部分可以自下而上
            temp = temp * A[i + 1];
            B[i] = B[i] * temp;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] multiply = multiply(a);
        System.out.println(Arrays.toString(multiply));
    }
}
