package cn.netstudy.lambda;

import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

/**
 * 方法引用：
 *
 * 1、表达式 System.out::println是一个方法的引用，它等价于lambda表达式 x ->System.out.println(x)
 *
 * 2、方法引用等价于提供方法参数的lambda表达式，Math::pow 等价于 (x,y) -> Math.pow(x,y)
 *
 * 3、String::compareTolgnoreCase 等同于 (x,y) -> x.compareTolgnoreCase(y)
 */
public class TestDemo {
    public static void main(String[] args) {
        String[] stars = new String[] {"LBJ","DRose","Owen","KD","AirJordan"};
        System.out.println(Arrays.toString(stars));
        System.out.println("Sort in dicionary order: ");
        Arrays.sort(stars);
        System.out.println(Arrays.toString(stars));
        System.out.println("Sort by length: ");
        Arrays.sort(stars,(first,second) -> first.length() - second.length());
        System.out.println(Arrays.toString(stars));
    }
}
