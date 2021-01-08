package cn.netstudy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: Wdz
 * @Date 2021/1/2 11:44
 * @Description:  学习Java8
 * https://zhuanlan.zhihu.com/p/299064490?utm_source=wechat_session&utm_medium=social&utm_oi=1261441864852430848&utm_content=first
 *
 */
public class First {
    public static void main(String[] args) {
        // 1、通过java.util.Collection.stream() 用集合创建流
        List<Integer> list = Arrays.asList(1, 6, 3, 7, 10);
        List<String> list1 = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        Stream<Integer> stream = list.stream();
        // 创建一个并行流
        Stream<Integer> parallelStream = list.parallelStream();

        // 2、使用java.util.Arrays.stream(T[] array) 方法用数组创建流
        int[] array = {1, 2, 3, 4, 5};
        IntStream stream1 = Arrays.stream(array);

        // 3、使用Stream的静态方法：of()、iterate()、generate()
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 3).limit(5);
        stream3.forEach(System.out::println);

        Stream<Double> stream4 = Stream.generate(Math::random).limit(3);
        stream4.forEach(System.out::println);


        // stream和parallelStream的简单区分：
        // stream是顺序流，由主线程按顺序对流执行操作，
        // 而parallelStream是并行流，内部以多线程并行执行的方式对流进行操作，
        // 但前提是流中的数据处理没有顺序要求
        // 如果流中的数据量足够大，并行流可以加快处速度。
        // 除了直接创建并行流，还可以通过parallel()把顺序流转换成并行流：
        Optional<Integer> first = list.stream().parallel().filter(x -> x > 6).findFirst();
        System.out.println(first.get());
    }
}
