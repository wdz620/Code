package leetcode.Algorithm;

/**
 * @Author: Wdz
 * @Date 2020/10/23 10:36
 * @Description: 二分法学习 TODO 二分法很细节！
 * 1、需要细细琢磨循环终止条件
 * 2、使用场景有限：
 *    二分查找的底层数据结构必须是数组      ->因为需要根据下标随机访问数组
 *    二分查找针对的是有序数组             ->二分查找只能用在插入、删除操作不频繁，一次排序多次查找的场景中。针对动态变化的数据集合，二分查找将不再适用
 *    数据量太小不适合二分查找             ->数据量太小则不能体现二分查找法的优势，还不如直接顺序遍历
 *    数据量太大也不适合二分查找           ->因为数组必须使用连续的内存进行存储
 * 注意：
 * mid 的取值。因为如果 low 和 high 比较大的话，两者之和就有可能会溢出。写成 low + (high - low) / 2，或改写成位运算 low + ((high - low) >> 1)，或 (low + high) >>> 1。
 *
 * 3、模糊匹配 - 二分法查找法变形
 *  3.1查找第一个值等于给定值的元素
 *  3.2查找最后一个值等于给定值的元素
 *  3.3查找第一个大于等于给定值的元素
 *  3.4查找最后一个小于等于给定值的元素
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch1(nums, 1));
        System.out.println(binarySearch1(nums, 2));
        System.out.println(binarySearch1(nums, 3));
        System.out.println(binarySearch1(nums, 4));
        System.out.println(binarySearch1(nums, 5));
        System.out.println(binarySearch1(nums, 6));
        System.out.println(binarySearch1(nums, 7));
        System.out.println(binarySearch1(nums, 8));
    }
    //标准形式
    public static int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {    //当i>j才停止
            int mid = (low + high) / 2; //low + (high - low) / 2 或 low + ((high - low) >> 1)，或 (low + high) >>> 1
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {    //当i>j才停止
            int mid = (low + high) / 2; //low + (high - low) / 2 或 low + ((high - low) >> 1)，或 (low + high) >>> 1
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return nums[low] == target ? low : -1;
    }

    //3、1查找第一个值等于给定值的元素
    public static int bsearch1(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                //与简单二分法查找不同，如果前一个元素值相等还需要继续递归哦
                if ((mid == 0) || (arr[mid - 1] != target)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }
    //说明：只需要在二分查找的基础上做一点改动即可，如果查找到相等的元素，需要进一步判断前一个元素是否等于要查找的值，如果等于要查找的值，则需要继续递归。
    //上述的二分法查找代码可读性最好，当然还有一种更高效的写法，可读性就稍微差一点了：
    public int bsearch10(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && arr[low] == target) return low;
        else return -1;
    }
    //3、2查找最后一个值等于给定值的元素
    public int bsearch2(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (arr[mid + 1] != target)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
    //3、3查找第一个大于等于给定值的元素
    public int bsearch3(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= target) {
                if ((mid == 0) || (arr[mid - 1] < target)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    //3、4查找最后一个小于等于给定值的元素
    public int bsearch4(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (arr[mid + 1] > target)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
    //扩展旋转排序数组 输入：nums = [4,5,6,7,0,1,2], target = 0 输出：4
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (end + start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {//判断前半段是大数组
                //以后注意：顺序也很有用。因为会短路
                if (target >= nums[start] && target < nums[mid]) {//target在前半段（即target是相对大的数）
                    end = mid - 1;
                } else {//否则target是相对小的数，在后半段找
                    start = mid + 1;
                }
            } else {//后半段是大数组
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


}
