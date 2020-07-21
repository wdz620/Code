package cn.arraylist.demo;

import java.util.ArrayList;

public class ArrayListStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student one = new Student("黄药师",20);
        Student two = new Student("洪七公",22);
        list.add(one);
        list.add(two);
        System.out.println(list);
        System.out.println("=====================");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println("姓名:" + student.getName() + "，年龄：" + student.getAge());
        }

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("张三丰");
        list1.add("灭绝师太");
        System.out.println(list1);

    }
}
