package cn.netstudy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Wdz
 * @Date 2020/10/11 18:56
 * @Description: 知识记录
 */
public class Test {

    // When I wrote this, only God and I understood what I was doing
    // Now, God only knows
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
    // Scanner和BufferReader简单对比：
    // Scanner的具体用法为Scanner in = new Scanner(System.in);
    // Scanner读取数据是按空格符（这其中包括空格键，Tab键，Enter键）来分割数据的。
    // 只要遇到其中之一，Scanner的方法就会返回下一个输入（当然nextLine()方法的结束符为换行符，它会返回换行符之前的数据）
    // 这也就是我们会面临的另一个问题，当我们的输入数据中有空格时，我们就不会得到我们想要的数据，这样我们就要考虑到BufferReader来读取数据！
    // BufferedReader br = new BufferedReader (newInputStreamReader(System.in));
    // 这个BufferReader对象通过readLine()；方法来读取数据，readLine()是按Enter回车来读取一行数据的，只要在回车键之前的都会被readLine()方法返回。

    // 小结：
    // 由于nextXXX()方法忽略换行符，但是nextLine()并不忽略它。所以如果我们在nextXXX()方法后面使用nextLine()将会出现问题
    // 解决方案是：在使用nextXXX()方法后，在使用nextLine()读取下一行数据前，多使用一个nextLine()用来消耗换行符
    // int intValue = sc.nextInt();
    // sc.nextLine();
    // String strValue = sc.nextLine();
    // 详见：https://blog.csdn.net/zengxiantao1994/article/details/78056243?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.compare&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.compare

    // 关于Integer常量池
    public void test02() {
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        System.out.println(a);
        System.out.println(b);
        System.out.println("ab:" + (a == b));   //false
        System.out.println("ac:" + (a == c));   //true? 自动拆箱
        System.out.println("bc:" + (b == c));   //true
        //如果字面量的值在-128~127之间，那么就不会new新的Integer对象，而是直接引用常量池中的Integer对象。
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);   //true
        System.out.println(f3 == f4);   //false
    }

    // 学习左右移， 2<<3 相当于 2*2^3 = 16
    // 或者另一种说法：最有效率的方法计算2乘以8
    public void test03() {
        int i = 2;
        int j = 9;
        double j1 = 9.0;
        System.out.println((i << 3));               // 2<<3 相当于 2*2^3 = 16
        System.out.println((16 >> 3));              // 16>>3 相当于 16/2^3 = 16/8 =2
        System.out.println((j / i));                // 9>>1 相当于 9/2 = 4.5 向下取整4
        System.out.println(Math.ceil(j1 / i));      // 9.0/2=4.5 向上取整的 5.0
    }

    // length() size()
    // 数组没有length()方法，但是含有length属性
    // String有length()方法
    // 集合使用size()来确定大小，但是通过源码发现吗，底层也是使用length进行判断
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
        System.out.println(Integer.MAX_VALUE);  //2147483647
        System.out.println(Long.MAX_VALUE);     //9223372036854775807
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

    // String、StringBuffer、StringBuilder
    // 尝试自己先判断一下、
    // ==        比较的是引用的变量地址是否相等 内存地址学习：https://blog.csdn.net/weixin_45500051/article/details/106518360
    // equals    比较的是内容是否相等
    // compareTo 比较数据的大小
    // intern()  对于任意两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true。
    public void test07() {
        String a = "HelloWorld";
        String b = new String("HelloWorld");
        String c = "Hello" + "World";

        System.out.println(a == b);                     // false 在堆内存中新开辟一个空间
        System.out.println(a == c);                     // true 因为直接进行赋值的方法创建的，所以都在常量池中
        System.out.println(a.equals(b));                // true
        System.out.println(a.equals(c));                // true
        System.out.println(a.intern() == b.intern());   // true
        System.out.println("===============");
        String c1 = "Hello";
        String c2 = "World";
        System.out.println(c == c1 + c2);               // c1+c2先开空间在拼接 false
        System.out.println(c.equals((c1 + c2)));        // true
        System.out.println(c == "Hello" + "World");     // true !!!!
        System.out.println(c.equals("Hello" + "World"));// true

    }

    // Java只有值传递 通过两个例子来解释
    // 进一步学习 cn.netstudy.ParmTest
    static class Demo {
        int val;

        public Demo(int val) {
            this.val = val;
        }
    }

    static class Quote {
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

    //构造器(constructor)不能被集成，因此不能被重写，但可以被重载

    //== 和hashCode equals方法 详见cn.netstudy.EqualsAndHashCode

    //String类是final类，不可以被继承。

    /*
    JVM中类的装载是由类加载器（ClassLoader）和它的子类来实现的，Java中的类加载器是一个重要的Java运行时系统组件，它负责在运行时查找和装入类文件中的类。
    其中类加载器包括：跟加载器(BootStrap)、扩展加载器(Extension)、系统加载器(System)和用户自定义类加载器。
    进一步说明：
        BootStrap:一般用本地代码实现，负责加载JVM基础核心类库
        Extension:从java.ext.dirs系统属性所指定的目录中加载类库，它的父加载器时BootStrap
        System：又叫应用类加载器，其父类是Extension，是应用最广泛的类加载器。他从环境变量classpath或者系统属性java.class.path所指定
                的目录中记载类，是用户自定义加载器的默认父加载器。
    */

    //char类型可以存储一个中文汉字，因为Java中使用的编码是Unicode，一个char类型占2个字节(16bit),所以放一个中文是没问题的。

    //静态嵌套类(Static Nested Class)和内部类（Inner Class）的不同？ 详见cn.netstudy.Poker

    /*
    对象的克隆是如何实现的？
        答：有两种方式
            1、实现Cloneable接口并重写Object类中的clone()方法;
            2、实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆。
     */

    //抽象的方法是否可同时是静态的，是否可同时是本地方法，是否可同时被synchronized修饰
    //答：都不能。抽象方法需要子类重写，而静态的方法是无法被重写的，因此二者是矛盾的。
    //本地方法是由本地代码实现的方法，而抽象方法是没有实现的，也是矛盾的。synchronized和方法的实现细节有关，抽象方法不涉及实现细节。因此也是矛盾的。

    //问：内部类可以引用它的包含类(外部类)的成员吗？有没有什么限制？
    //答：一个内部类对象可以访问创建它的外部类对象的成员，包括私有成员。

    //问：匿名内部类(Anonymous Inner Class)是否可以继承其他类？是否可以实现接口？
    //答：可以继承其他类或实现其他接口。

    //问：一个".java"源文件中是否可以包含多个类(不是内部类)？有什么限制？
    //答：可以，单一个源文件中最多有一个公开类(public class)而且文件名必须和公开类的类名保持一致。

    //问：接口是否可继承(extends)接口？抽象类是否可实现接口(implements)接口？抽象类是否可继承具体类(concrete class)?
    //答：接口可以继承接口。抽象类可以实现接口，抽象类可继承具体类，但前提是具体类必须由明确的构造函数。

    //问：String s = new String("xyz"); 创建了几个字符串对象
    //两个对象，一个是静态存储区的"xyz"，一个是用new创建在堆上的对象。

    //输出二维数组测试
    /*
    int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
        };
     */
    private void test08(int[][] grid) {
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 怎么将GB2312编码的字符串转换为ISO-8859-1编码的字符串
    private void test09() throws UnsupportedEncodingException {
        String s = "你好";
        String s1 = new String(s.getBytes("GB2312"), "ISO-8859-1");
    }

    // 字符串反转(递归实现)
    private String test10(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return test10(originStr.substring(1)) + originStr.charAt(0);
    }
    // 使用StringBuffer的reverse()方法
    private String test11(String origin) {
        StringBuffer sb = new StringBuffer(origin);
        String string = sb.reverse().toString();
        return string;
    }
    //常用的拼接
    private String test12(String s) {
        int length = s.length();
        String res = "";
        for (int i = 0; i < length; i++) {
            res = s.charAt(i) + res;//在新字符串前面添加读取字符，实现翻转
        }
        return res;
    }

    //如何将字符串转换为基本数据类型 -> 调用基本数据类型对应的包装类中的方法 praseXXX(String)或valueOf(String)即可返回相应的基本数据类型；
    //eg: int i = Integer.parseInt("45"); valueOf()方法同理
    //如何将基本数据类型转换为字符串 -> 一种方法将基本数据类型与空字符串连接(+)；另一种调用String类中的valueOf(...)方法返回相应的字符串

    /*Java中的final关键字用法
    1、修饰类：表示该类不能被继承
    2、修饰方法：表示方法不能被重写
    3、修饰变量：表示变量只能一次赋值以后值不能被修改(常量)
     */

    /* Error和Exception的区别
        Error表示系统级的错误和程序不必处理的异常，是恢复不是不可能但很困难的情况下的一种严重问题；比如内存溢出，不可能指望程序能处理这样的情况
        Exception表示需要捕捉或者需要程序进行处理的异常，是一种设计或实现问题，也就是说，表示如果程序运行正常，从不会发生的情况。
     */

    /* try{}里面有一个return语句，那么紧跟在这个try后的finally{}里的code会不会执行，什么时候被执行，在return前还是后？
        答：一定会执行，而且是在方法返回调用前执行。
            Java允许在finally中改变返回值的做法是不好的，因为如果存在finally代码块，try中的return语句不会立马返回给调用者，而是记录下返回值，
            等待finally代码块执行完毕之后在向调用者返回其值，然后如果在finally中修改了返回值，这对程序将造成很大的困扰。
     */

    /*  运行异常与受检异常有何异同？
        异常表示程序在运行过程中可能出现的非正常状态。
        运行异常表示虚拟机的通常操作中可能遇到的异常，是一种常用的运行异常，只要程序设计的没有问题通常不会发生。
        受检异常和程序的上下文环境有一定的关系，即使程序设计的无误，仍可能因使用的问题而引发。

     */

    /*
    常见的运行异常
    ArithmeticException         (算术异常)
    ClassCastException          (类转换异常)
    IllegalArgumentException    (非法参数异常)
    IndexOutOfBoundsException   (下标越界异常)
    NullPointerException        (空指针异常)
    SecurityException           (安全异常)
     */

    /*final、finally、finalize的区别？
        final：
            修饰符(关键字)有三种用法：如果一个类呗声明为final，意味着它不能在派生出新的子类，不能被继承。
            将变量声明为final，可以保证他们在使用中不被改变，被声明的final变量必须在声明时给定初值，在今后的引用中只能读取不能修改。
            被final声明的方法，同样也只能使用，不能在子类中被重新改写。
        finaly:
            通常放在try...catch的后面总是执行的代码块。这就意味着不管程序无论正常还是发生异常，都必须执行。一般在finally中写释放资源的代码。
        finalize：
            Java中允许使用finalize()方法在垃圾收集器将对象从内存中清除之前做必要的清理工作。

     */

    //日期相关
    private void test13() {
        Calendar cal = Calendar.getInstance();
        System.out.println("年" + cal.get(Calendar.YEAR));
        System.out.println("月" + (cal.get(Calendar.MONTH) + 1) + "");
        System.out.println("日" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分" + cal.get(Calendar.MINUTE));
        System.out.println("当前毫秒数：" + cal.getTimeInMillis());
        cal.add(Calendar.DATE, -1); //去年时间
        System.out.println(cal.getTime());
        Date newTime = new Date();
        System.out.println(newTime);    //当前时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println(format.format(cal.getTime()));   //格式化去年
        System.out.println(format.format(newTime));         //格式化当前
    }


    public static void main(String[] args) throws IOException {
        Test t = new Test();
        t.test07();


    }




}
