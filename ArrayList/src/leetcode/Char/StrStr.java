package leetcode.Char;

/**实现 strStr()
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 *
 *示例：
     * 输入: haystack = "hello", needle = "ll"     输入: haystack = "aaaaa", needle = "bba"
     * 输出: 2                                     输出: -1
 * 思考：利用两个指针进行查看。 TODO 未完成
 */
public class StrStr {
    public static void main(String[] args) {
        String h = "hello";
        String n = "ll";
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr(h,n));

    }

    /**
     * 自答：双指针
     *
     */
    public int strStr(String haystack, String needle) {
            int h = haystack.length();
            int n = needle.length();
            for (int i = 0; i <= h - n; i++){
                int j = 0;
                while (j < n){
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    j++;
                }
                if (j == n){
                    return i;
                }
            }
            return -1;
    }
    /**
     * 官方 ：双指针
     */
    public int strStr01(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == L) return pn - L;

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }

    /**
     * 官方 RK算法
     */
    // function to convert character to integer
    public int charToInt(int idx, String s) {
        return (int)s.charAt(idx) - (int)'a';
    }

    public int strStr02(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        //如果子串大于模式串，则不可能匹配，返回-1
        if (L > n) return -1;

        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 31);

        // compute the hash of strings haystack[:L], needle[:L]
        long h = 0, ref_h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + charToInt(i, haystack)) % modulus;
            ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
        }
        if (h == ref_h) return 0;

        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - charToInt(start - 1, haystack) * aL
                    + charToInt(start + L - 1, haystack)) % modulus;
            if (h == ref_h) return start;
        }
        return -1;
    }

    /**
     *Net_solution RK算法
     */
    public int strStr1(String haystack,String needle){
        //主串长度
        int m = haystack.length();
        //模式串的长度
        int n =needle.length();
        //计算模式串的hash值
        int patternCode = hash(needle);
        //计算主串当中第一个和模式串等长的子串hash值
        int strCode = hash(haystack.substring(0,n));
        //用模式串的hash值和主串的局部hash值比较。
        // 如果匹配，则进行精确比较；如果不匹配，计算主串中相邻子串的hash值。
        for(int i =0;i<m-n+1;i++){
            if(strCode == patternCode &&compareString(i,haystack,needle)){
                return i;
            }
            //如果不是最后一轮，更新主串从i到i+n的hash值
            if(i <m-n){
                strCode = nextHash(haystack,strCode,i,n);
            }
        }
        return - 1;
    }

    public static int hash(String str){
        int hashcode = 0;
        //这里采用最简单的hashcode计算方式：
        //把a当做1，把b当中2，把c当中3.....然后按位相加
        for( int i = 0; i < str.length(); i++){
            hashcode += str.charAt(i)-'a';
        }
        return hashcode;
    }

    public static int nextHash(String str,int hash,int index,int n){
        hash -= str.charAt(index)-'a';
        hash += str.charAt(index + n)-'a';
        return hash;
    }
    public static boolean compareString(int i,String str,String pattern){
        String strSub = str.substring(i,i+pattern.length());
        return strSub.equals(pattern);
    }
}
