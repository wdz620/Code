package cn.netstudy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 动态创建对象，通过反射
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获取Class对象
        Class c1 = Class.forName("cn.netstudy.reflection.User");
        //构造一个对象
        User user = (User) c1.newInstance(); //本质是调用了类的无参构造，换言之就是类必须存在一个无参构造器，否则就会报错
        System.out.println(user);

        /**
         * 当然可以解决上述问题，通过调用Class类的getDeclaredConstructor取得本类的指定形参类型的构造器
         * 向构造器的参数中传递一个对象数组进去，里面包含了构造器中需要的各个参数
         * 通过Constructor实例化对象
         */
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) constructor.newInstance("小明", 001, 18);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        //通过反射调取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke 激活
        //（对象，"方法的值"）
        setName.invoke(user3, "康康");
        System.out.println(user3);


        //通过反射操作属性
        System.out.println("--------------------------------");
        User user1 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者方法的setAccessible(true)
        // 默认打开时为false，参数true则指示反射的对象在使用时必须取消Java语言访问检查。如果代码中必须用反射，而该剧代码需要频繁的被调用，则选择true。
        name.setAccessible(true);
        name.set(user1,"丽丽");
        System.out.println(user1.getName());
    }
}
