package Offer.List;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2020/7/21 10:04
 * @Description: 旋转数组的最小数字 题目：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 思路：
 * 利用二分法，找到数组的中间元素mid。如果中间元素 > 数组的第一个元素，在mid右边搜索变化点。如果中间元素 < 数组第一个元素，我们需要在mid
 * 左边搜素变化点。当找到变换点时停止搜索，满足nums[mid] > nmus[mid+1] (mind+1是最小值) 或nums[mid-1]>nums[mid] (mid是最小值)即可。
  冲突测试
 */
public class MinNum {
    public static void main(String[] args) {
        int[] nums = {6501,6828,6963,7036,7422,
                      7674,8146,8468,8704,8717,
                      9170,9359,9719,9895,9896,
                      9913,9962,154,293,334,492,
                      1323,1479,1539,1727,1870,
                      1943,2383,2392,2996,3282,
                      3812,3903,4465,4605,4665,
                      4772,4828,5142,5437,5448,
                      5668,5706,5725,6300,6335};
        int[] nums1 = {1,2,3,4,5,6};
        System.out.println(min(nums));

    }

    //二分学后检验(LC能过，牛客超时)
    public static int min(int[] array) {
        int low = 0, high = array.length - 1;
        while (low < high) {
            int m = (low + high) / 2;
            ////中点大于尾点，说明最小点在后半段 mid < i <= right
            if (array[m] > array[high]) {
                low = m + 1;
            }
            //说明最小点在前半段 left < i <= mid
            else {
                high = m;
            }
        }
        return array[low];
    }
    //自答
    public static int minNumberInRotateArray0(int [] array) {
        if(array == null || array.length == 0) return 0;
        int l = 0,r = array.length -1;
        while(l < r){
            int mid = (l+r)/2;
//            System.out.println(array[mid]);
            //中间元素大于第一个
            if(array[mid] > array[r]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return array[l];
    }

    //方法1：二分查找  时间复杂度O（log n） 空间复杂度O（1）
    public static int minNumberInRotateArray01(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array.length == 1 || array[array.length - 1] > array[0]) {
            return array[0];
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            if (array[mid - 1] > array[mid]) {
                return array[mid];
            }
            if (array[mid] > array[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //方法2：二分查找（最左下标） ->LC能过，牛客超时
    public static int minNumberInRotateArray02(int[] array) {
        if (array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (array[mid] > array[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return array[left];
    }
    //网上学习
    public int minNumberInRotateArray03(int [] array) {
        /*
        三种情况：
        （1）把前面0个元素搬到末尾，也就是排序数组本身，第一个就是最小值
        （2）一般情况二分查找，当high-low=1时，high就是最小值
        （3）如果首尾元素和中间元素都相等时，只能顺序查找
        */
        int len=array.length;
        if(len==0)
            return 0;
        int low=0,high=len-1;
        if(array[low]<array[high]) //排序数组本身
            return array[low];
        while(low<high){
            int mid=low+(high-low)/2;
            if(array[low]==array[mid] && array[high]==array[mid])
                return minInOrder(array);
            if(array[mid]>=array[low])
                low=mid;
            else if(array[mid]<=array[high])
                high=mid;
            if(high-low==1)
                return array[high];
        }
        return -1;
    }
    public int minInOrder(int [] array) { //顺序查找
        int min=array[0];
        for(int num:array){
            if(num<min)
                min=num;
        }
        return min;
    }
    public static int test(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

}
