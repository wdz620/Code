package offer.List;

/**
 * @Author: Wdz
 * @Date 2020/7/3 22:09
 * @Description:二维数组中的查找 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] arr1 = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int[][] arr2 = {{}};
        System.out.println(arr2[0].length);
        System.out.println(arr2 == null);
        //18 10 13 6 9 16 12 11
//        System.out.println(arr1.length);

        System.out.println(find0(arr1, 5));
        //行列
//        System.out.println(arr[arr.length-1][0]);
//        System.out.println(find0(arr,5));

    }
    /**
     * 自答 用例    [[-5]]  -5 失败！
     */
    public static boolean find0(int[][] array, int target) {
        // 判空
        if (array == null || array.length == 0) return false;
        // 双指针，从左下角开始查看
        int row = array.length - 1, col = 0;
        while(row >= 0 && col < array.length){
            if(array[row][col] == target){
                return true;
            }
            if(array[row][col] > target){
                row--;
            }else {
                col++;
            }
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
