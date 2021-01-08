package leetcode.Char;

/**
 * 给定字符串（合法字符只包括0，1，？），替换字符串中的通配符？为0或者1，生成所有可能的字符串。
 * Example :
 * Input str = “1??0?101”
 * Output:
 * 10000101 10001101
 * 10100101 10101101
 * 11000101 11001101
 * 11100101 11101101
 */
//TODO 将?替换成0和1的所有情况
public class Replace {
    public static void main(String args[]) {
        char key = '?';
        String str = "1??0?101"; //1 2 4
        StringBuilder strBuilder = new StringBuilder(str);
        int a = str.indexOf(key);
        while (a != -1) {
            System.out.print(a + "\t");
            strBuilder.setCharAt(a, '0');
            a = str.indexOf(key, a + 1);
        }
        str=strBuilder.toString();
        System.out.println(str);
    }
}
