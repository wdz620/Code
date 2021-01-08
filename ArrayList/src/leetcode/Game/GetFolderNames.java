package leetcode.Game;

import java.util.*;

/**
 * @Author: Wdz
 * @Date 2020/11/17 10:02
 * @Description: 1487. 保证文件名唯一
 * 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 *
 * 输入：names = ["pes","fifa","gta","pes(2019)"]
 * 输出：["pes","fifa","gta","pes(2019)"]
 * 解释：文件系统将会这样创建文件名：
 * "pes" --> 之前未分配，仍为 "pes"
 * "fifa" --> 之前未分配，仍为 "fifa"
 * "gta" --> 之前未分配，仍为 "gta"
 * "pes(2019)" --> 之前未分配，仍为 "pes(2019)"
 *
 * 输入：names = ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]
 * 输出：["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"]
 * 解释：当创建最后一个文件夹时，最小的正有效 k 为 4 ，文件名变为 "onepiece(4)"。
 *
 * 输入：names = ["kaido","kaido(1)","kaido","kaido(1)"]
 * 输出：["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]
 * 解释：注意，如果含后缀文件名被占用，那么系统也会按规则在名称后添加新的后缀 (k) 。
 */
public class GetFolderNames {
    // 看到这个重复，第一思路就是想使用Set，失败！！！
    public String[] getFolderNames(String[] names) {
        return names;

    }

    public static void main(String[] args) {
        String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        String[] folderNames1 = getFolderNames1(names);
        System.out.println(Arrays.toString(folderNames1));
    }

    // 参考
    public static String[] getFolderNames1(String[] names) {
        int n = names.length;
        String[] ans = new String[n];
        //文件名及其序列号
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //计数从0开始，所以为了保持操作统一，默认值是-1.
            int k = map.getOrDefault(names[i], -1) + 1;
            //计算当前name
            String name = names[i] + (k == 0 ? "" : "(" + k + ")");
            //如果已经存在，需要增加k的序列号
            while (map.get(name) != null) {
                k++;
                //k更新后，更新name
                name = names[i] + "(" + k + ")";
            }
            //当前name保存，已经计算的name中是唯一的
            ans[i] = name;
            //注意这里保存的是names[i]的序列号，而不是name,因为name可能本身包含序列号，不能确定顺序是否正确,如pes(2019)
            map.put(names[i], map.getOrDefault(names[i], -1) + 1);
            //保存本次唯一的name, 及其序列号0
            map.put(ans[i], 0);
        }
        return ans;
    }

}
