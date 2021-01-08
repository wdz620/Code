package cn.netstudy.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @Author: Wdz
 * @Date 2020/10/27 20:20
 * @Description: ArrayList常用API学习
 * 扩展：
 *  http://www.cnblogs.com/skywang12345/p/3308762.html TODO ArrayList -> fail-fast
 * fail-fast 机制是java集合(Collection)中的一种错误机制。当多个线程对同一个集合的内容进行操作时，就可能会产生fail-fast事件。
 * 例如：当某一个线程A通过iterator去遍历某集合的过程中，若该集合的内容被其他线程所改变了；那么线程A访问集合时，就会抛出ConcurrentModificationException异常，产生fail-fast事件。
 * fast-fail解决办法：通过util.concurrent集合包下的相应类去处理，则不会产生fast-fail事件。
 *
 *
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //创建ArrayList
        ArrayList list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        //测试random
        Random random = new Random();
        System.out.println("测试" + list.get(random.nextInt(list.size())));

        //将下面的元素添加到第一个位置
        list.add(0, "5");
        System.out.println("原始数组：" + list);
        //获取第一个元素
        System.out.println("the first element is : " + list.get(0));
        //删除3
        list.remove("3");
        //获取ArrayList的大小
        System.out.println("ArrayList size = " + list.size());
        //获取list中是否包含3
        System.out.println("ArrayList contains 3 is:" + list.contains("3"));
        //设置第二个元素为10
        list.set(1, "10");

        //通过Iterator遍历ArrayList
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            System.out.println("next is : " + iter.next());
        }

        //将ArrayList转换成数组
        String[] arr = (String[]) list.toArray(new String[0]);
        for (String str : arr) {
            System.out.println("str:" + str);
        }

        //清空ArrayList
        list.clear();
        //判断ArrayList是否为空
        System.out.println("ArrayList is empty:" + list.isEmpty());

    }

}
