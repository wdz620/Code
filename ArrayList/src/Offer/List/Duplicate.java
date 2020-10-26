package Offer.List;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: Wdz
 * @Date 2020/10/21 20:57
 * @Description:
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 返回描述：
 * 如果数组中有重复的数字，函数返回true，否则返回false。
 * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
 */
public class Duplicate {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < length; i++){
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }else{
                set.add(numbers[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {6,3,2,0,2,5,0};
        int[] num = {11};
        boolean b = duplicate1(nums, 7, num);
        System.out.println(b);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(num));


    }

    //网上参考
    /* 三种方法：排序后查找，哈希表，数组重排（此处）
    从头到尾扫描整个数组中的数字，当扫描到下标为i的数字时，首先比较这个数字（用m表示）是不是等于下标i，
    如果是，接着比较下一个数字；
    如果不是，则将其与第m个数字比较，若与第m个数字相同，则说明它就是一个重复数字，
    如果不同，就将其与第m个数字进行交换，也就是把它放到自己应在的位置去。重复这个过程，直到该位置上的数与下标相同为止。

    补充说明：
    (1) 如果只要求判断是否有重复元素，不用找到该值，那么可以使用异或的思路，所有的元素和从0到n-1的下标一起异或，
        那么如果没有重复元素，相当于从0到n-1每个元素都出现了两次（下标和对于的元素），最后的异或结果一定是0，否则说明有重复元素。
    (2) 上述数组重排的思路虽然比较巧妙，但是一个缺点是改变了原来的数组，如果题目要求不能修改原来的数组，
        一个是可以使用哈希表，另一个是可以使用剑指Offer上给出的二分查找思路，但是相对比较麻烦。具体如下：
        以长度为8的数组{2,3,5,4,3,2,6,7}为例，根据题目要求，这个长度为8的数组，所有元素都在1到7的范围内，
        中间的数字4将1—7分成两部分，分别为1—4和5—7，接下来统计1—4在数组中出现的次数，发现是5次，则说明这4个数字中一定有重复数字。
        接下来再把1—4分成1、2和3、4两部分，1和2一共出现了两次，3和4一共出现了3次，说明3和4中有一个重复，再分别统计即可得到是3重复了。
        这并不保证找出所有的重复数字，比如2就没有找到。
        实际上，这种二分查找时间复杂度也达到了O(nlogn)，不如用哈希表空间换时间来的直观。
     */
    //用例{6,3,2,0,2,5,0}出错，输出0，而非第一个重复的2
    public static boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (numbers == null || length < 1){ return false;}
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {//每个元素最多被交换两次就可以找到自己的位置，依次复杂度是O（n）
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    int temp = numbers[numbers[i]]; //交换
                    numbers[numbers[i]] = numbers[i];//将numbers[i]放到属于他的位置上
                    numbers[i] = temp;
                }
            }
        }
        return false;
    }

    //自答尝试双指针


}
