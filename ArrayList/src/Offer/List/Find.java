package Offer.List;

/**
 * @Author: Wdz
 * @Date 2020/7/3 22:09
 * @Description:二维数组中的查找 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find03(arr, 7));

    }

    /**
     * 网上参考
     */
    public boolean find(int target, int[][] array) {
        /*
        思路：从左下角（或者右上角）开始查找，因为该行右边大于它，上边小于它，每次比较可以删除某一行或者某一列
        注意：左上和右下不可以，因为无法减小问题规模（行和列都无法删除）
        */
        if (array == null)
            return false;
        int row = array.length; //行数
        int col = array[0].length; //列数
        for (int i = row - 1, j = 0; i >= 0 && j < col; ) { //从左下角开始查找
            if (array[i][j] == target) //找到
                return true;
            else if (array[i][j] > target) //不可能在该行，跳过该行
                i--;
            else //不可能在该列，跳过该列
                j++;
        }
        return false;
    }

    /**
     * 剑指Offer：解法一:双指针，时间复杂度：O（mn），空间复杂度：O（1）
     */
    public static boolean find01(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;
        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }
            if (array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * 网上参考：二分法思想，将二维数组转换成一维数组进行二分比较。
     */

    public static boolean find02(int[][] array, int target) {
        if (array.length == 0 || array[0].length == 0) return false;
        for (int i = 0; i < array.length; i++) {
            int left = 0, right = array[0].length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (array[i][mid] > target)
                    right = mid - 1;
                else if (array[i][mid] < target)
                    left = mid + 1;
                else
                    return true;
            }
        }
        return false;
    }
    /**
     * 剑指Offer：解法二:二分法，时间复杂度：O（log mn），空间复杂度：O（1） TODO 有问题！答案不对！！！
     */
    public static boolean find03(int[][] arr,int target){
        int left = 0;
        int right = arr.length * arr[0].length - 1;
        int col = arr[0].length;
        while (left <= right){
            int mid = (left + right) / 2;
            int value = arr[mid / col][mid % col];
            if (value == target) return true;
            else if (value < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }


}