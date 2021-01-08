package realtest;
import java.io.*;
/**
 * @Author: Wdz
 * @Date 2021/1/7 19:38
 * @Description: TODO 搭积木
 * 小明有一袋子长方形的积木，如果一个积木A的长和宽都不大于另外一个积木B的长和宽，则积木A可以搭在积木B的上面。好奇的小明特别想知道这一袋子积木最多可以搭多少层，你能帮他想想办法吗？
 * 定义每一个长方形的长L和宽W都为正整数，并且1 <= W <= L <= INT_MAX, 袋子里面长方形的个数为N, 并且 1 <= N <= 1000000.
 * 假如袋子里共有5个积木分别为 (2, 2), (2, 4), (3, 3), (2, 5), (4, 5), 则不难判断这些积木最多可以搭成4层, 因为(2, 2) < (2, 4) < (2, 5) < (4, 5)。
 *
 * 输入描述：
 * 第一行为积木的总个数 N
 * 之后一共有N行，分别对应于每一个积木的宽W和长L
 * 输出描述：
 * 输出总共可以搭的层数
 *
 * 5
 * 2 2
 * 2 4
 * 3 3
 * 2 5
 * 4 5
 * 输出
 * 4
 */
public class KS_03 {
    // 将所有结果都放入集合，然后找到最下面的，然后根据长宽去找小的。
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());


    }
}
