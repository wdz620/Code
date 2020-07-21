package LeetCode.Char;

/**题目：有效的字母异位词 -->判断两个字符串包含的字符以及字符出现的次数是否相同
    * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例：
     * 输入: s = "anagram", t = "nagaram"  |      输入: s = "rat", t = "car"
     * 输出: true                          |      输出: false
 *说明：
     * 你可以假设字符串只包含小写字母。
 *思路：定义一个int数组，存储每个字符出现的次数。然后去判断另一个字符串中是否出现一样的次数。
 */
public class IsAnagram {
    public static void main(String[] args) {
        IsAnagram iA = new IsAnagram();
        boolean b = iA.isAnagram("abc", "cbxa");
        System.out.println(b);

    }

    /**
     * 自我：
     */
    public boolean isAnagram(String s, String t) {
        int[] nums1 = new int[26];
        char[] cs1 = s.toCharArray();
        char[] cs2 = t.toCharArray();
        for (int i = 0; i < cs1.length; i++) {
            nums1[cs1[i] - 'a']++;
        }
        for (int i = 0; i < cs2.length; i++) {
            nums1[cs2[i] - 'a']--;
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
