package cn.netstudy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * * 通过反射获取运行时类的完整结构
 *  * Field、Method、Constructor、Superclass、Interface、Annotation
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("cn.netstudy.reflection.User");
        //获取包名 + 类名
        System.out.println(c1.getName()); //cn.netstudy.reflection.User
        //获取类名
        System.out.println(c1.getSimpleName()); //User

        //获取类的属性
        //注意 getFields只能获取到public属性，getDeclaredFields可以获取全部的属性
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //获取指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);
        //获得类的方法
        System.out.println("====================");

        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("正常："+method);  //获得本类及其父类的全部public方法
        }
        methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("getDeclaredMethods"+method); //获取本类的全部方法
        }

        System.out.println("==================================");
        //获取指定方法

        Method getName = c1.getMethod("getName", null);
        System.out.println(getName);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);


        System.out.println("==================================");
        //获取构造器         同上 前一个获取所有public方法，后一个获取全部方法
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("*"+constructor);
        }

    }
}
