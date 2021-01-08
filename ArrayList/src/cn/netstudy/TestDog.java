package cn.netstudy;

/**
 * @Author: Wdz
 * @Date 2020/10/26 19:09
 * @Description: 继承学习
 */
public class TestDog {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();
        Dog c = new Dog();
        a.move();
        b.move();
        System.out.println();
        c.move();
        c.bark();
    }




}
class Animal{
    public void move(){
        System.out.println("动物可以奔跑");
    }
}
class Dog extends Animal {
    @Override
    public void move() {
        super.move();
        System.out.println("狗自己跑");
    }
    public void bark() {
        System.out.println("垃圾狗叫");
    }
}
