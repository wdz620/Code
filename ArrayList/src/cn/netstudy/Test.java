package cn.netstudy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: Wdz
 * @Date 2020/10/11 18:56
 * @Description:
 */
public class Test {

    //
    public void test01() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String in = null;
        while ((in = bf.readLine()) != null) {
            String[] nums = in.split(",");
            int left = 0, right = nums.length - 1;
            StringBuilder sb = new StringBuilder();
            while (left < right) {
                sb.append(nums[left++]).append(",").append(nums[right--]).append(",");
            }
            if (left == right) sb.append(nums[left]).append(",");
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
        bf.close();
    }

    //关于Integer常量池
    public void test02() {
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        System.out.println(a);
        System.out.println(b);
        System.out.println("ab:" + (a == b));
        System.out.println("ac:" + (a == c));
        System.out.println("bc:" + (b == c));
        //如果字面量的值在-128~127之间，那么就不会new新的Integer对象，而是直接引用常量池中的Integer对象。
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }

    //学习左右移， 2<<3 相当于 2*2^3 = 16
    public void test03() {
        int i = 2;
        int j = 9;
        double j1 = 9.0;
        System.out.println((i << 3)); //2<<3 相当于 2*2^3 = 16
        System.out.println((j/i)); //9>>1 相当于 9/2 = 4.5 向下取整4
        System.out.println(Math.ceil(j1/i)); // 9.0/2=4.5 向上取整的 5.0
    }

    //length()
    //  数组没有length()方法，但是含有length属性
    //  String有length()方法
    public void test04() {
        int[] nums = {1, 2, 3};
        String str = "hello";
        System.out.println(nums.length); //数组长度 -> 3
        System.out.println(str.length());//字符串长度 -> 5
    }

    //向上/向下取整问题
    public void test05() {
        System.out.println(Math.round(11.5)); // 12
        System.out.println(Math.round(-11.5));// -11
        //综上的出Math.round() 应该是+0.5之后在取整

    }

    //Java基本数据类型
    // byte short int      long float double boolean char
    // Byte Short Integer  Long Float Double Boolean Character
    // https://blog.csdn.net/qq_37688023/article/details/85106894
    /*
        int数值范围[-2^31 ~ 2^32-1] 也就是 [-2147483648, 2147483647] 也可以通过包装类来找到最大小值。
        当超过最大值，比如到2147483647+1 就变成 -2147483648,即循环赋值，一旦超出就循环到最小的值，以此类推。
        long数值范围[-2^63 ~ 2^63-1] 也就是[-9223372036854775808,9223372036854775807]
        可以应用到通过long判断int是否越界。
        注意：Java基本数据类型直接比较大小。
     */
    public void test06() {
        //找大小
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println("=================");
        long l1 = 2147483647;
        Long l2 = 2147483647L;
        System.out.println(l1 == l2); // true 两种定义形式，如果是long类型更推荐第二种，因为大写的避免混淆。
        System.out.println("~~~~~~~~~");

        int i1 = 2147483647;
        long l3 = 2147483647;
        System.out.println(i1);     //2147483647
        System.out.println(i1 + 1); //-2147483648
        System.out.println(i1 + 2); //-2147483647
        //总结：超过最大值，开始循环赋值

        System.out.println("+++++++++");
        System.out.println(i1 == l2); //true
        System.out.println(i1 == l3); //true
        System.out.println((i1 + 10) == (l3 + 10)); //false
        //总结:两种定义形式的long都和int相等。
        //当int越界之后就会循环赋值，导致和long不一样。可以应用到通过long判断int是否越界。

    }

    //String、StringBuffer、StringBuilder
    //尝试自己先判断一下、
    // ==        比较的是引用的变量地址是否相等
    // equals    比较的是内容是否相等
    // compareTo 比较数据的大小 TODO 还需详细深究
    public void test07() {
        String a = "HelloWorld";
        String b = new String("HelloWorld");
        String c = "Hello" + "World";

        System.out.println(a == b);
        System.out.println(a == c); //true 因为直接进行赋值的方法创建的，所以都在常量池中
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.intern() == b.intern());
        System.out.println("===============");
        String c1 = "Hello";
        String c2 = "World";
        System.out.println(c == c1 + c2);   //c1+c2先开空间在拼接
        System.out.println(c.equals((c1 + c2)));
        System.out.println(c == "Hello" + "World");
        System.out.println(c.equals("Hello" + "World"));

    }

    //Java只有值传递 通过两个例子来解释
    // 进一步学习 cn.netstudy.ParmTest
    static class Demo{
        int val;
        public Demo(int val) {
            this.val = val;
        }
    }
    static class Quote{
        //实例一：注意这个并非是引用传递
        public void function1(Demo d1, Demo d2) {
            int temp;
            temp = d1.val;
            d1.val = d2.val;
            d2.val = temp;
        }
        //实例二
        public void function2(Demo d1, Demo d2) {
            Demo temp;
            temp = d1;
            d1 = d2;
            d2 = temp;
        }
        /*
        主方法中：
        Quote quote = new Quote();
        Demo d1 = new Demo(1);
        Demo d2 = new Demo(2);
        System.out.print(d1.val);   //1
        System.out.println(d2.val); //2
        quote.function1(d1, d2);
        System.out.print(d1.val);   //2   //1
        System.out.println(d2.val); //1   //2
        小结：
        执行上面的代码，调用function2()前后程序输出的都是1、2，此程序试图通过调用function()交换d1和d2，但是没有成功，为什么呢？
        因为d1和d2是值传递，function()中的d1和d2是main()函数中d1和d2的副本，调用完function()不会对main()中的变量产生影响。
        再看示例一中，function1()函数内改变的并不是d1和d2本身的值，而是d1和d2指向的对象的值，调用完function1()后d1和d2仍然指向函数调用前的堆地址，
        即函数参数是栈中的d1和d2，而不是堆中d1和d2指向的对象，即使你在函数中改变了堆中的对象，但没有改变函数参数的值。
        所以示例一并不是什么引用传递；可见java中只有值传递。
         */
    }

    //== 和hashCode equals方法 详见cn.netstudy.EqualsAndHashCode





    public static void main(String[] args) throws IOException {
        Test t = new Test();

    }


}
