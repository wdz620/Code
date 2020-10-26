package Offer.List;

/**
 * @Author: Wdz
 * @Date 2020/10/23 8:53
 * @Description: 37、数字在排序数组中出现的次数
 * 二分法：如果找到这个值，因为可能出现连续的重复，所以需要判断前面和后面是否还有相同的值
 */
public class GetNumberOfK {
    //暴力法
    public static int getNumberOfK(int [] array , int k) {
        int res=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==k) res++;
        }
        return res;
    }

    //二分法
    public int getNumberOfK1(int[] array, int k) {
        int first = getFirst(array, k);
        int last = getLast(array, k);
        if (first == -1 || last == -1) return 0;
        return last - first + 1;

    }

    //找第一个重复的位置
    public int getFirst(int[] array, int k) {
        int res = -1;
        if (array == null || array.length ==0 ) return res;
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else {//关键点
                mid = mid - 1;
                if (mid < low || array[mid] != k) {//记得短路效果，所以如果越界在前面
                    return mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return res;
    }
    //找到最后一个位置
    public int getLast(int[] array, int k) {
        int res = -1;
        if (array == null || array.length ==0 ) return res;
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else {
                mid = mid + 1;
                if (mid > high || array[mid] != k) {
                    return mid - 1;
                } else {
                    low = mid;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4};
        //暴力法
        System.out.println(getNumberOfK(nums, 3));
        //二分法
        GetNumberOfK g = new GetNumberOfK();
        System.out.println(g.getNumberOfK1(nums, 3));

    }
}
