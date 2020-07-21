package cn.netstudy.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 * 练习ORM ： Object relationship MApping ————>对象映射关系
 */
public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("cn.netstudy.reflection.Student");

        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation); //@cn.netstudy.reflection.Table1(value=db_student)
        }

        //获得注解的value的值
        //方法： 获取指定的注解，强转，然后调用value方法
        Table1 table1 = (Table1) c1.getAnnotation(Table1.class);
        String value = table1.value();
        System.out.println(value); //db_student

        //获得类指定的注解
        Field f = c1.getDeclaredField("id");
        Field1 annotation = f.getAnnotation(Field1.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

    }

}

@Table1("db_student")
class Student{
    //注解对应数据库的字段信息
    @Field1(columnName = "db_id", type = "int" , length = 10)
    private int id;
    @Field1(columnName = "db_age", type = "int" , length = 10)
    private int age;
    @Field1(columnName = "db_name", type = "varchar" , length = 3)
    private String name;

    public Student() {
    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table1{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field1{
    String columnName();
    String type();
    int length();
}