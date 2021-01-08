package offer.List;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2020/10/8 10:38
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void main(String[] args) {
        // 9 1 3 5 7 4 2 0
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        // 找到第一个偶数的位置
        int index = 0;
        while (index < array.length && array[index] % 2 != 0) {
            index++;
        }
        System.out.println(index);

        //1 5 3 2 4
//        int[] array = {2, 4, 1, 5, 3};
        reOrderArray2(array);
//        reOrderArray11(array);

        System.out.println(Arrays.toString(array));
    }

    //自答  牛客不让用ArrayList
    public static void reOrderArray(int[] array) {
        ArrayList<Integer> f = new ArrayList<>();
        ArrayList<Integer> s = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            //偶数
            if (array[i] % 2 != 0) {
                f.add(array[i]);
            } else {
                s.add(array[i]);
            }
        }
        for (int i = 0; i < f.size(); i++) {
            array[i] = f.get(i);
        }
        for (int i = 0; i < s.size(); i++) {
            array[f.size() + i] = s.get(i);
        }
    }

    //参考:
    // 对数组进行遍历，设置两个指针even和odd，even指向当前第一个偶数，odd从这个偶数之后开始查找，
    // 找到第一个奇数，此时为了相对位置不变，不能直接交换even和odd，
    // 而是将从even到odd-1的元素都依次向后移一个位置，将odd指向的那个奇数放到even的位置。
    // 然后再找下一个偶数，重复这一过程，最终就可以将奇数都放到偶数的前面，并且保证了相对位置的不变。
    public static void reOrderArray1(int[] array) {
        int len = array.length;
        int even = 0, odd = 0; //当前序列的第一个奇数和第一个偶数
        while (odd < len && even < len) {
            while (even < len && array[even] % 2 != 0) //找到第一个偶数even
                even++;
            odd = even + 1;
            //找偶数之后的第一个奇数
            while (odd < len && array[odd] % 2 == 0)
                odd++;
            if (odd >= len)  //注意判断，防止溢出
                break;
            //把奇数取出来，从even到odd-1的元素都向后移
            int temp = array[odd];
            for (int i = odd; i > even; i--)
                array[i] = array[i - 1];
            array[even] = temp; //奇数放在原来even的位置
            even++;
        }
    }

    //复现参考
    public static void reOrderArray11(int[] array) {
        int length = array.length;
        int o = 0, j = 0;
        while (o < length && j < length) {
            //找到第一个偶数的位置
            while (o < length && array[o] % 2 != 0) {
                o++;
            }
            //开始找奇数
            j = o + 1;
            while (j < length && array[j] % 2 == 0) {
                j++;
            }
            //如果没找到退出本次循环
            if (j >= length) break;
            //找到奇数，将偶数和奇数之间的都+1，然后换位置
            int temp = array[j];
            for (int i = j; i > o; i--) {
                array[i] = array[i - 1];
            }
            array[o] = temp;
            o++;
        }
    }

    //参考2
    public static void reOrderArray2(int[] array) {
        int length = array.length;
        // 利用双指针
        int odd = 0, even = 0;
        while (odd < length && even < length) {
            // 找第一个偶数的位置（这里有点绕：因为要找到第一个偶数位置 ）
            // 如果判断条件是== 那就是找奇数
            while (even < length && array[even] % 2 != 0) {
                even++;
            }
            // 再去找后面有没有奇数
            odd = even + 1;
            while (odd < length && array[odd] % 2 == 0) {
                odd++;
            }
            // 防止溢出，以为要在移动的时候将+1
            if (odd >= length) {
                break;
            }
            // 将奇数保存，偶奇数之间依次后移
            int temp = array[odd];
            for (int i = odd; i > even; i--) {
                array[i] = array[i - 1];
            }
            // 将奇数放入偶数位置
            array[even] = temp;
            // 继续走，因为现在下一位就是之前的挪位
            even++;
        }
    }


}
