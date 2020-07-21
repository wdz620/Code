package cn.netstudy.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 反射操作泛型
 * Java中的泛型仅仅是给编译器javac使用的，确保数据的安全性和免去强制类型转换问题，但是，一旦编译完成，所有和泛型有关的类型全部擦除
 * 为了通过反射操作这些类型，java新增了ParameterizedType，GenericArrayType，TypeVariable和WildcardType几种类型代表不能被同意到Class类型到那时又和原始类型齐名的类型。
 * ParameterizedType  --> 表示一种参数化类型
 * GenericArrayType   --> 表示一种元素类型时参数化类型或者类型变量的数组类型
 * TypeVariable       --> 时各种类型变量的公共父接口
 * WildcardType       --> 代表一种通配符类型表达式
 */
public class Test05 {
    public void test01(Map<String,User> map, List<User> list){
        System.out.println("test01");
    }
    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test05.class.getMethod("test01", Map.class, List.class);
        //getGenericParameterTypes : 获得泛型参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);
            //　instanceof 严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例，本例中判断是否是一种参数化类型
            if (genericParameterType instanceof ParameterizedType){
                //getActualTypeArguments 获得真实参数信息
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }

            }
        }

        System.out.println("************************");

        Method method1 = Test05.class.getMethod("test02", null);
        Type genericParameterTypes1 = method1.getGenericReturnType();
        if (genericParameterTypes1 instanceof ParameterizedType){
            //getActualTypeArguments 获得真实参数信息
            Type[] actualTypeArguments = ((ParameterizedType) genericParameterTypes1).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }

        }
    }

}
