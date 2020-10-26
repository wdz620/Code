package cn.netstudy;

import java.util.HashSet;

/**
 * @Author: Wdz
 * @Date 2020/10/22 20:10
 * @Description: Java hashCode()和equals()的若干问题解答
 * 1、equals()的作用是什么 -> 用来判断两个对象是否相等。
 *      (01) 若某个类没有覆盖equals()方法，当它的通过equals()比较两个对象时，实际上是比较两个对象是不是同一个对象。
 *           这时，等价于通过“==”去比较这两个对象。
 *      (02) 我们可以覆盖类的equals()方法，来让equals()通过其它方式比较两个对象是否相等。
 *           通常的做法是：若两个对象的内容相等，则equals()方法返回true；否则，返回fasle。
 *
 * 2、equals()与==的区别是什么
 *      == : 它的作用是判断两个对象的地址是不是相等。即，判断两个对象是不试同一个对象。
 *      equals() : 它的作用也是判断两个对象是否相等。但它一般有两种使用情况(前面第1部分已详细介绍过)：
 *                情况1，类没有覆盖equals()方法。则通过equals()比较该类的两个对象时，等价于通过“==”比较这两个对象。
 *                情况2，类覆盖了equals()方法。一般，我们都覆盖equals()方法来两个对象的内容相等；若它们的内容相等，则返回true(即，认为这两个对象相等)。
 *
 * 3、hashCode()的作用是什么 ->获取哈希码，也称为散列码;哈希码的作用是确定该对象在哈希表中的索引位置
 *      1、如果两个对象相等，那么它们的hashCode()值一定要相同；
 *      2、如果两个对象hashCode()相等，它们并不一定相等。
 *
 * 4、hashCode()和equals()之间有什么联系
 *
 *
 * 补充：
 * //问：两个对象值相同(x.equals(y)== true),但却可有不同的hashcode,对不对？  ->显然不对
 *     /*
 *         Java对于equals方法和hashCode方法是这样规定的：
 *             1、如果两个对象相同(equals方法返回true),那么它们的hashCode值一定要相同；
 *             2、如果两个对象的hashCode相同，它们并不一定相同。
 *         扩展：
 *             默认的equals方法等价于 ==
 *             equals方法必须满足自反性、对称性、传递性和一致性。
 *             实现高质量的equals方法的诀窍：
 *                 1、使用==操作符检查"参数是否位这个对象的引用"
 *                 2、使用instanceof操作符检查"参数是否为正确的类型"
 *                 3、对于类中的关键属性，检查参数传入对象的属性是否与之相匹配
 *                 4、编写完equals方法后，是否满足四个性质
 *                 5、重写equals时总是要重写hashCode
 *                 6、不要紧将equals方法参数中的Object对象替换为其他的类型，再重写时不要忘掉@Override注解
 *
 */

public class EqualsAndHashCode {
    public static void main(String[] args) {
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        Person p3 = new Person("aaa", 200);
        HashSet set = new HashSet();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.print("p1.equals(p2):" + p1.equals(p2));
        System.out.print(" p1Code: " + p1.hashCode());
        System.out.println(" p2Code: " + p2.hashCode());
        System.out.println(set);
        /*
        p1.equals(p2):true p1Code: 356573597 p2Code: 1735600054
        [eee - 100, eee - 100, aaa - 200]
        分析：
        我们重写了Person的equals()。但是，很奇怪的发现：HashSet中仍然有重复元素：p1 和 p2。为什么会出现这种情况呢？
        这是因为虽然p1 和 p2的内容相等，但是它们的hashCode()不等；所以，HashSet在添加p1和p2的时候，认为它们不相等。
         */
        //重写hashCode测试
        /*
        p1.equals(p2):true p1Code: 68545 p2Code: 68545
        [eee - 100, aaa - 200]
        分析
        这下，equals()生效了，HashSet中没有重复元素。
        比较p1和p2，我们发现：它们的hashCode()相等，通过equals()比较它们也返回true。所以，p1和p2被视为相等。
        比较p1和p4，我们发现：虽然它们的hashCode()相等；但是，通过equals()比较它们返回false。所以，p1和p4被视为不相等。
         */
    }

    private static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String toString() {
            return name + " - " + age;
        }
        @Override
        public int hashCode(){
            int nameHash = name.toUpperCase().hashCode();
            return nameHash ^ age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj==null) return false;
            if (this==obj) return true;
            if (this.getClass()!=obj.getClass()) return false;
            Person person = (Person) obj;
            return name.equals(person.name) && age == person.age;
        }
    }
}
