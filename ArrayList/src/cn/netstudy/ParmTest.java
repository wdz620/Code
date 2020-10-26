package cn.netstudy;

/**
 * @Author: Wdz
 * @Date 2020/10/13 9:21
 * @Description: 参数的传递机制--形参和实参
 * 形参：
 *   -- 用来接收调用该方法时传递的参数。只有在被调用的时候才分配内存空间，一旦调用结束，就释放内存空间。
 *   -- 因此仅仅在方法内有效。
 *
 * 实参：
 *  -- 传递给被调用方法的值，预先创建并赋予确定值。
 *
 * 传递调用：
 *  -- 传递调用中传递的参数为基本数据类型，参数视为形参。
 *
 * 传引用调用：
 *  -- 传引用调用中，如果传递的参数是引用数据类型，参数视为实参。在调用的过程中，将实参的地址传递给了形参，形参上的改变都发生在实参上。
 *
 * 注意：
 *  -- 基本数据类型时属于传值调用，当我们要实现交换时，方法内可以完成交换，只是实参进行了交换，方法结束，栈空间中就会销毁方法内的局部变量。
 *  -- 所以当调用swap()时,最终值还是实参的初始化值，并没有被修改。值改变作用到了形参，而不会到实参。
 *
 *  总结：
 *  -- 形参是基本数据类型的: 将实参的值传递给实参的基本数据类型的变量，--->即在函数中形参改变，调用处的实参不变。
 *  -- 形参是引用数据类型的: 将实参的引用类型的值(即在堆空间中生成的首地址的值)传递给形参的引用类型的变量 --->函数中形参改变，调用处的实参改变。
 */
public class ParmTest {
    public static void main(String[] args) {
        int i = 1, j = 2;
        System.out.println("i:" + i + " j:" + j);
        swap(i, j);
        System.out.println("i:" + i + " j:" + j);

        System.out.println("==========================");
        Data data = new Data();
        System.out.println("i:" + data.i + " j:" + data.j);
        change(data);
        System.out.println("i:" + data.i + " j:" + data.j);

    }

    //基本数据类型测试
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a:" + a + " b:" + b);
    }
    //引用数据类型测试
    public static void change(Data data){
        int temp = data.i;
        data.i = data.j;
        data.j = temp;
        System.out.println("ss1:" + data.i + " ss2:" + data.j);
    }

    static class Data {
        int i = 10;
        int j = 5;
    }

}
