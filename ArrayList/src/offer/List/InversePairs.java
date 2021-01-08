package offer.List;

/**
 * @Author: Wdz
 * @Date 2020/10/23 9:12
 * @Description: 35. 数组中的逆序对 TODO 归并排序学习
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * 输入描述：
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * <p>
 * 示例：
 * 1,2,3,4,5,6,7,0    ->7
 * 10,20,30,40,50,60,70
 */
public class InversePairs {
    //暴力法
    public static int inversePairs(int[] array) {
        int res = 0;
        if (array == null || array.length <= 1) return res;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) res++;
            }
        }
        return res % 1000000007;
    }

    //分治法：参考1：https://www.cnblogs.com/lishanlei/p/10707683.html
    /*
    把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，合并数组。
    合并时，出现前面的数组值array[i]大于后面数组值array[j]时，则前面数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i　(核心思想)
    其次，测试用例输出结果比较大，对每次返回的count mod (1000000007)求余
     */
    public int times = 0;

    public int InversePairs_2(int[] array) {
        if (array != null && array.length > 0) {
            mergeSortUp2Down(array, 0, array.length - 1);
        }
        return times;

    }

    public void mergeSortUp2Down(int[] elem, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSortUp2Down(elem, start, mid);
        mergeSortUp2Down(elem, mid + 1, end);

        merge(elem, start, mid, end);
    }

    public void merge(int[] elem, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (elem[i] <= elem[j]) {
                temp[k++] = elem[i++];
            } else {
                temp[k++] = elem[j++];
                times += mid - i + 1; // core code, calculate InversePairs
                times %= 1000000007;
            }
        }

        while (i <= mid) {
            temp[k++] = elem[i++];
        }

        while (j <= end) {
            temp[k++] = elem[j++];
        }

        for (i = 0; i < k; i++) {
            elem[start + i] = temp[i];
        }
        temp = null;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println("暴力：" + inversePairs(nums));
        InversePairs pairs = new InversePairs();
        System.out.println("参考1：" + pairs.InversePairs_2(nums));
        System.out.println("LC官方：" + pairs.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) copy[i] = nums[i];
        int[] tmp = new int[len];
        return reversePairs(copy, 0, len - 1, tmp); //方法重载机制
    }

    //nums[left..right] 计算逆序对个数并且排序
    private int reversePairs(int[] nums, int left, int right, int[] tmp) {
        if (left == right) return 0; //递归终结者
        int mid = left + (right - left) / 2;//此处采用此方式是因为(right + left) / 2中的right + left可能产生越界
        int leftPairs = reversePairs(nums, left, mid, tmp);
        int rightPairs = reversePairs(nums, mid + 1, right, tmp);
        if (nums[mid] <= nums[mid + 1]) return leftPairs + rightPairs; // 此时，左边子数组的最大数小于右边子数组的最小数，直接合并即可，不会产生逆序对
        int crossPairs = mergerAndCount(nums, left, mid, right, tmp); //crossPairs是将两个有序子数组归并为一个有序数组产生的逆序对
        return crossPairs + rightPairs + leftPairs;
    }

    //nums[left..mid] 有序，nums[mid + 1..right] 有序
    private int mergerAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
        //全程采用一个数组tmp的原因有二：不必一直创建新的数组，节约资源；每次处理的都是子数组，如果创建新的数组会导致索引的处理很麻烦，容易出错
        for (int i = left; i <= right; i++) tmp[i] = nums[i];
        int i = left;   //左边的有序数组的左边界
        int j = mid + 1;//右边的有序数组的左边界
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = tmp[j]; //此时左边的子数组长度为0
                j++;
            } else if (j == right + 1) {
                nums[k] = tmp[i]; //此时右边的子数组长度为0
                i++;
            } else if (tmp[i] <= tmp[j]) { //这儿必须得是“<=”，如是“<”，则归并排序是不稳定的
                nums[k] = tmp[i]; //左边子数组的值较小，进入有序数组
                i++;
            } else {
                nums[k] = tmp[j]; //此时，右边子数组的值较小，进入有序数组
                j++;
                count += (mid - i + 1);//左边子数组剩余的个数即为逆序对个数
            }
        }
        return count;
    }
}
