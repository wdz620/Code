package offer.List;

/**
 * @Author: Wdz
 * @Date 2021/1/6 16:01
 * @Description: 67、减绳子
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。
 * 请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {
    // 自打尝试
    public static int cutRope(int target) {
        if (target <= 3) return target - 1;
        int a = target / 3, b = target % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }
}
