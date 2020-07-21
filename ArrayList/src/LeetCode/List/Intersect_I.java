package LeetCode.List;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * eg1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 我解决思路：
 * 方法1：双重for循环，可以用短的数组去匹配长的，如过相等就将该值放入一个数组返回
 *    问题：1、不知道怎么确定新的数组的长度
 *         2、重复的数据怎么放入，因为包括重复一次的 两次的。
 *
 * 官方解答：两个set
 */
public class Intersect_I {

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        Intersect_I l = new Intersect_I();
        int[] s = l.intersect(num1, num2);
        System.out.println(Arrays.toString(s));
//        int[] ints = l.intersection2(num1, num2);
//        System.out.println(Arrays.toString(ints));
    }

    /**
     * 官方
     */
    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1)
            if (set2.contains(s)) output[idx++] = s;

        return Arrays.copyOf(output, idx);
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);
        if (set1.size() < set2.size()) return set_intersection(set1, set2);
        else return set_intersection(set2, set1);
    }


    /**
     * 我的方法 ：
     */
    public int[] intersect(int[] nums1,int[] nums2){
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
}
