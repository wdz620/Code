package Offer.String;

import java.util.*;

/**
 * @Author: Wdz
 * @Date 2020/10/15 8:50
 * @Description:
 */
public class Practise {
    public static void main(String[] args) {
        String s1 = "Person.java";
        String s2 = "Person.java.txt";
        //获取一个文件名的扩展名
        System.out.println(lastName(s1));
        System.out.println(lastName(s2));
        System.out.println();

        //查找一个字符串中子字符串出现的所有位置
        String s3 = "xxxabcxxxabcxxx";
        System.out.println(Arrays.toString(findSubIndex(s3, "abc")));
        System.out.println();

        //查找一个字符串中出现最多的字符:方法1和方法2 如果出现并列最多输出第一词出现的
        String s4 = "abcdefghijklba";
        System.out.println(findCharMost2(s4));
        //查找一个字符串中出现最多的字符（Huawei）
        String s5 = "abcabcba";
        System.out.println(findMapMaxValue(s5));
        System.out.println("**************************************");

        //java中的compareto方法
        //返回为正数表示a1>a2, 返回为负数表示a1<a2, 返回为0表示a1==a2；
        String a1 = "a";
        String a2 = "c";
        System.out.println(a1.compareTo(a2));  //-2
        String a3 = "aa";
        String a4 = "ad";
        System.out.println(a3.compareTo(a4));  //-3
        String a5 = "aa12345678";
        System.out.println(a3.compareTo(a5)); //-8
        System.out.println(a4.compareTo(a5)); //3 ad aa12345678
        System.out.println(a4.compareTo(a3)); //3 ad aa
        //测试
        String b1 = "吴东卓";
        String b2 = "吴东东";
        System.out.println(b1.compareTo(b2));




    }

    //获取一个文件名的扩展名
    public static String lastName(String s) {
        //最后出现.的位置
        int index = s.lastIndexOf(".");
        //截取子字符串
        String substring = s.substring(index);
        return substring;
    }

    //查找一个字符串中子字符串出现的所有位置 TODO 未完！！！
    public static int[] findSubIndex(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        int subLength = p.length();
        res.add(s.indexOf(p));
        res.add(s.indexOf(p, s.indexOf(p) + subLength));
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    //查找一个字符串中出现最多的字符
    /*
    思路：
    首先这道面试题初一看很简单，寻找出字符串中出现次数最多的字符，例如：aaaaaac，输出a；
    如果出现次数一样多，那么输出先达到次数的字符，例如：abcdefghijklba，输出b（变种：输出先出现的字符，其实解决思路一样）。
    我看网上很多回答都是用HashMap，但是找出最大值后，如果有多个最大值你怎么找到最先达到次数的字符呢？
    很多人就会想，再弄一个数组或者HashMap记录下他最后出现的位置，如果你真这么想，那么你的算法就是一坨屎。
    我们在刚开始遍历字符串记录次数的时候，能不能顺便就记下他的位子呢？
    如果你这么想，那么这道题目就迎刃而解了。
    我的想法是，用两个list，一个记他的顺序，另一个记他的次数，他们的index是对应的。话不多说，我们看代码：
     */
    public static char findCharMost1(String s) {
        //记录字符串中的字符
        List<Character> list = new ArrayList<>();
        //记录对应字符出现的次数
        List<Integer> list2 = new ArrayList<>();
        //因为题目要求最先达到次数，那么我就倒着来遍历字符串
        //那么记录顺序的list中就有字符串的顺序了
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!list.contains(s.charAt(i))) {
                //如果字符没有出现过，那么add到list中
                list.add(s.charAt(i));
                //同时在list2对应位置赋值为1
                list2.add(1);
            } else {
                //如果字符出现过，那么找到对应的index
                int index = list.indexOf(s.charAt(i));
                //在list2对应位置将次数++
                list2.set(index, list2.get(index) + 1);
            }
        }
        int max = list2.get(list2.size() - 1);
        int j = list2.size() - 1;
        //记录顺序的list中是按后到的字符放在前面的顺序
        //所以我们只要倒着遍历找到最大值就可以了
        for (int i = list2.size() - 2; i >= 0; i--) {
            if (list2.get(i) > max) {
                max = list2.get(i);
                j = i;
            }
        }
        return list.get(j);
    }
    //查找一个字符串中出现最多的字符
    public static char findCharMost2(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        char ans = ' ';
        for(int i=0;i<str.length();i++){
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            }else {
                //value+1后，覆盖原来的元素
                int count = map.get(str.charAt(i))+1;
                map.put(str.charAt(i), count);
            }
            if (map.get(str.charAt(i))>max) {
                max = map.get(str.charAt(i));
                ans = str.charAt(i);
            }
        }

        return ans;
    }
    //查找一个字符串中出现最多的字符(Huawei上机题)
    public static Character findMapMaxValue(String str) {
        //
        char[] strArr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        if (!(strArr == null || strArr.length == 0)) {
            for (int i = 0; i < strArr.length; i++) {
                if (null != map.get(strArr[i])) {
                    map.put(strArr[i], map.get(strArr[i]) + 1);
                } else {
                    map.put(strArr[i], 1);
                }
            }
        }
        //以上可以抽离成一个方法
        Set<Character> keys = map.keySet();
        Iterator keys_Itera = keys.iterator();
        Character maxkey = (Character) keys_Itera.next();
        int maxvalue = map.get(maxkey);
        while (keys_Itera.hasNext()) {
            Character temp = (Character) keys_Itera.next();
            if (maxvalue < map.get(temp)) {
                maxkey = temp;
                maxvalue = map.get(temp);
            }
        }
        System.out.println("maxkey is --->: " + maxkey + "  " + "maxvalue is ---> :" + maxvalue);
        return maxkey;
    }

    //查找两个字符串中最大相同子串


}
