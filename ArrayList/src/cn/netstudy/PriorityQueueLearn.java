package cn.netstudy;

import java.util.*;

/**
 * @Author: Wdz
 * @Date 2020/11/2 9:45
 * @Description: PriorityQueue 优先级队列
 * 在LeetCode.Algorithm.CreateHuffman 中使用过，现在来系统学习一下。主要参考：https://baijiahao.baidu.com/s?id=1665383380422326763&wfr=spider&for=pc
 *
 * 1、概念：
 * 我们都知道队列，队列的核心思想就是先进先出，这个优先级队列有点不太一样。优先级队列中，数据按关键词有序排列，插入新数据的时候，会自动插入到合适的位置保证队列有序。（顺序有两种形式：升序或者是降序）
 */
public class PriorityQueueLearn {
    //测试优先级队列自动排序
    public static List<Integer> insertSort() {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<Integer>(7);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            queue.add(new Integer(random.nextInt(100)));
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    /*
    LC215 在未排序的数组中找到第k个最大的元素。排序后的第k个最大的元素
    方法一：冒泡排序
     */
    public static int findKthLargest(int[] nums, int k) {
        int s = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            if (s++>=k) break;
        }
        return nums[nums.length - k];
    }

    //方法二：使用优先级队列
    public static int findKthLargest1(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    //方法三：调用API的无赖做法
    public static int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(insertSort().toArray()));
        int[] nums = {3, 2, 1, 5, 6, 4};
    }

}
