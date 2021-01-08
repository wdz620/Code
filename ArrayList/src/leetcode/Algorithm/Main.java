package leetcode.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: Wdz
 * @Date 2020/10/12 11:01
 * @Description:
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = bf.readLine()) != null) {
            int n = Integer.valueOf(str);
            System.out.println(deleteAllOdd02(n));
        }
        bf.close();

    }

    public static int deleteAllOdd02(int n) {
        int i = 1;
        while (true) {

            if (Math.pow(2, i) - 1 > n) {
                break;
            }
            i++;
        }
        return (int) (Math.pow(2, i - 1) - 1);
    }


}
