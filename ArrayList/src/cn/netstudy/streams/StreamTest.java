package cn.netstudy.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Wdz
 * @Date 2021/1/2 12:11
 * @Description: Stream的使用
 */
public class StreamTest {

    /**
     * 3.1 遍历/匹配（foreach/find/match）
     */
    public static void ffm() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println); //7 9 8
        // 匹配第一个
        Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意(适用于并行流)
        Optional<Integer> any = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        System.out.println("匹配第一个值：" + first.get()); // 7
        System.out.println("匹配任意一个值：" + any.get()); // 8
        System.out.println("是否存在大于6的值：" + anyMatch);// true
    }

    /**
     * 3.2 筛选（filter）
     * 筛选，是按照一定的规则校验流中的元素，将符合条件的元素提取到新的流中的操作
     */
    public static void filter() {
        // 案例一：筛选出Integer集合中大于7的元素，并打印出来
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list.stream();
        stream.filter(x -> x > 7).forEach(System.out::println); // 8 9

        // 案例二： 筛选员工中工资高于8000的人，并形成新的集合。
        // 形成新集合依赖collect（收集），后文有详细介绍。
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        List<String> filterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        System.out.println("高于8000的员工姓名：" + filterList); // Tom Anni Owen
    }

    /**
     * 3.3 聚合（max/min/count)
     * max、min、count这些字眼你一定不陌生，没错，在mysql中我们常用它们进行数据统计。
     * Java stream中也引入了这些概念和用法，极大地方便了我们对集合、数组的数据统计工作。
     */
    public static void mmc() {
        // 案例一：获取String集合中最长/短的元素。
        List<String> list = Arrays.asList("adnm", "wdz", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());
        Optional<String> min = list.stream().min(Comparator.comparing(String::length));
        System.out.println("最短的字符串：" + min.get()); // 注意这里是选择最先出现的最短字符串
    }

    public static void mmc1() {
        // 案例二：获取Integer集合中的最大值。
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        // 自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        // 自定义排序
        Optional<Integer> max1 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值:" + max.get());
        System.out.println("自定排序的最大值:" + max1.get());
    }

    public static void mmc2() {
        // 案例三：获取员工工资最高的人。
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值：" + max.get().getSalary());
    }

    public static void mmc3() {
        // 案例四：计算Integer集合中大于6的元素的个数。
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count = list.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数：" + count);
    }

    /**
     * 3.4 映射(map/flatMap)
     * 映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap：
     * map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
     */
    // 案例一：英文字符串数组的元素全部改为大写。整数数组每个元素+3。
    public static void fm() {
        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
        List<String> stringList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> list = intList.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println("元素大写：" + stringList);
        System.out.println("元素加3：" + list);
    }

    // 案例二：将员工的薪资全部增加1000。
    public static void fm1() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        // 不改变原来员工集合的方式
        List<Person> personListNew = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 1000);
            return personNew;
        }).collect(Collectors.toList());
        System.out.println("一次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        System.out.println("一次改动后：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary());

        System.out.println("======================");

        // 改变原来员工集合的方式
        List<Person> personListNew1 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 1000);
            return person;
        }).collect(Collectors.toList());
        System.out.println("二次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        System.out.println("二次改动前：" + personListNew1.get(0).getName() + "-->" + personListNew1.get(0).getSalary());
    }


    //案例三：将两个字符数组合并成一个新的字符数组。
    public static void fm2() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> list1 = list.stream().flatMap(s -> {
            // 将每一个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());
        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + list1);
    }

    /**
     * 3.5 归约(reduce)
     * 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
     */
    // 案例一：求Integer集合的元素之和、乘积和最大值
    public static void reduce() {
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式一
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        // 求和方式二
        Optional<Integer> sum1 = list.stream().reduce(Integer::sum);
        // 求和方式三
        Integer sum2 = list.stream().reduce(0, Integer::sum);

        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大化方式2
        Integer max1 = list.stream().reduce(1, Integer::max);

        System.out.println("list求和:" + sum.get() + "," + sum1.get() + "," + sum2);
        System.out.println("list求积:" + product.get());
        System.out.println("list最大:" + max.get() + "," + max1);
    }
    // 案例二：求所有员工的工资之和和最高工资。
    public static void reduce1() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        // 求工资之和方式1：
        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        // 求工资之和方式2：
        Integer sumSalary1 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(),
                (sum1, sum2) -> sum1 + sum2);
        // 求工资之和方式3：
        Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);

        // 求最高工资方式1：
        Integer maxSalary = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                Integer::max);
        // 求最高工资方式2:
        Integer maxSalary1 = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (m1, m2) -> m1 > m2 ? m1 : m2);

        System.out.println("工资之和：" + sumSalary.get() + "," + sumSalary1 + "," + sumSalary2);
        System.out.println("最高工资：" + maxSalary + "," + maxSalary1);
    }

    /**TODO
     *  3.6 收集(collect)
     *  3.6.1 归集(toList/toSet/toMap)
     *  3.6.2 统计(count/averaging)
     *  3.6.3 分组(partitioningBy/groupingBy)
     *  3.6.4 接合(joining)
     *  3.6.5 归约(reducing)
     */


    /**
     * 3.7 排序(sorted)
     */

    /**
     * 3.8 提取/组合
     */

    public static void main(String[] args) {
        // 遍历/匹配
//        ffm();
        // 过滤
//        filter();
        // 聚合
//        mmc3();
        // 映射
//        fm2();
        // 归约
        reduce1();
    }


}
