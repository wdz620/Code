package leetcode.List;

import java.util.*;

/**
 * @Author: Wdz
 * @Date 2020/11/2 14:25
 * @Description: 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
public class Intersection {
    //愚蠢如猪的自答
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> a = new ArrayList();
        if (nums1.length > nums2.length){
            for (int i = 0; i <nums2.length; i++) {
                for (int j = 0; j < nums1.length ; j++) {
                    if (nums1[j] == nums2[i] && !a.contains(nums2[i])){
                        a.add(nums2[i]);
                    }
                }
            }
        }else {
            for (int i = 0; i <nums1.length; i++) {
                for (int j = 0; j < nums2.length ; j++) {
                    if (nums1[i] == nums2[j] && !a.contains(nums1[i])){
                        a.add(nums1[i]);
                    }
                }
            }
        }
        int[] list = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            list[i] =a.get(i);
        }
        return list;
    }

    //第二次自我尝试
    public static int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        //生成一个集合，里面放入nums1的非重复数据
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        //如果nums2中有和集合中的元素，就加入最后的res
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] ints = intersection1(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
