package cn.netstudy;

/**
 * @Author: Wdz
 * @Date 2020/10/27 18:51
 * @Description:  还是没太懂
 */
public class PokerTest {
    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.shuffle(); //洗牌
        Poker.Card c1 = poker.deal(0); //发第一张牌
        //对于非静态内部类Card
        //只有通过其外部类Poker对象才能创建Card对象
        Poker.Card c2 = poker.new Card("红桃", 1);

        System.out.println(c1);
        System.out.println(c2);
    }
}
