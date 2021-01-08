package offer.String;

/**
 * @Author: Wdz
 * @Date 2020/7/4 11:16
 * @Description:替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 思路：从后往前复制，数组长度会增加，或使用StringBuilder、StringBuffer类
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(s));

    }

    /**
     * 剑指Offer解法：时间复杂度O(n),空间复杂度O(n)
     */
    public static String  replaceSpace(StringBuffer str){
        if (str == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")){
                sb.append("%20");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return String.valueOf(sb);
    }

    /**
     * 网上参考
     */
    //第一种情况：创建新的字符串实现：时间复杂度O(n2)
    public String replaceSpace01(StringBuffer str) {
        String res="";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c==' ')
                res += "%20";
            else
                res += c;
        }
        return res;
    }

    //第二种情况：原地替换，O(n)的解法
    public String replaceSpace02(StringBuffer str) {
        if(str==null)
            return null;
        int numOfblank = 0;//空格数量
        int len=str.length();
        for(int i=0;i<len;i++){  //计算空格数量
            if(str.charAt(i)==' ')
                numOfblank++;
        }
        str.setLength(len+2*numOfblank); //设置长度
        int oldIndex=len-1;  //两个指针
        int newIndex=(len+2*numOfblank)-1;

        while(oldIndex>=0 && newIndex>oldIndex){
            char c=str.charAt(oldIndex);
            if(c==' '){
                oldIndex--;
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else{
                str.setCharAt(newIndex,c);
                oldIndex--;
                newIndex--;
            }
        }
        return str.toString();
    }

}
