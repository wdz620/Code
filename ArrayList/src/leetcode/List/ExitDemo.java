package leetcode.List;

/**
 * 对数组内数据进行判断，如果有相同的则返回true，反之返回false
 * 方法1：双重for循环，时间复杂度（n2） 超时
 * 方法2：使用Arrays.sort方法，排序之后，判断相邻数据即可
 * 方法3：使用Set集合
 */
public class ExitDemo {
    public static void main(String[] args) {
        //int[] nums = {1,2,3,3};
        //int[] nums = {1, 2, 3, 4};
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        ExitDemo exitDemo = new ExitDemo();
        System.out.println(exitDemo.containsDuplicate(nums));

    }
    public boolean containsDuplicate(int[] nums){
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }


        /**
         *
         *          //排序
         *         Arrays.sort(nums);
         *         for(int i=0;i<nums.length-1;i++){
         *             if(nums[i] == nums[i+1]) return true;
         *
         *         }
         *
         *         //哈希表
         *        Set<Integer> set = new HashSet<>(nums.length);
         *         for (int x: nums) {
         *              if (set.contains(x)) return true;
         *              set.add(x);
         *           }
         *
         *
         */
}
