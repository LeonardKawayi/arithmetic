package com.daojia.zzk.arithmetic._1array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhangzk
 * 扑克牌问题
 * 我手中有一堆扑克牌， 但是观众不知道它的顺序。
 * 1、第一步， 我从牌顶拿出一张牌， 放到桌子上。
 * 2、第二步， 我从牌顶再拿一张牌， 放在手上牌的底部。
 * 3、第三步， 重复第一步、第二步的操作， 直到我手中所有的牌都放到了桌子上。
 * 最后， 观众可以看到桌子上牌的顺序是：(牌底部）1,2,3,4,5,6,7,8,9,10,11,12,13(牌顶部）
 * 请问， 我刚开始拿在手里的牌的顺序是什么？
 */
public class PokerQuestion {

    /**
     *
     * 正向，从手到桌子 t2 = {1,12,2,8,3,11,4,9,5,13,6,10,7};
     * 返回 ｛13,12,11,10,9,8,7,6,5,4,3,2,1};
     * @param pokers
     */
    public static void poker (int[] pokers) {
        //13张牌转换成数组  方便操作，不用考虑太多
        LinkedList<Integer> hands = new LinkedList<>();
        for (int poker : pokers) {
            hands.add(poker);
        }
        //声明一个新的容器，在这里可以理解成桌子
        LinkedList<Integer> desk = new LinkedList<>();

        for (int poker : pokers) {
            //将手牌中的第一张放在桌子上
            desk.add(hands.pollFirst());
            //假如这是最后一次循环手牌已经没有了就不需要进入这个判断了
            if (hands.size() > 0) {
                //将第一张放在牌堆的最后
                hands.addLast(hands.pollFirst());
            }
        }

        desk.forEach(System.out::println);
    }

    /**
     * 这里的操作是从桌子把牌拿回到手上
     * 从桌子 到 手上 int[] t = {13,12,11,10,9,8,7,6,5,4,3,2,1};
     * 返回 {1,12,2,8,3,11,4,9,5,13,6,10,7}
     *
     * @param pokers
     */
    public static void pock2 (int[] pokers) {
        //从数组转换成list,只是为了方便操作，不用考虑其它的
        LinkedList<Integer> desk = new LinkedList<>();
        for (int i = 0; i < pokers.length; i++) {
            desk.add(pokers[i]);
        }
        //声明一个目标容器，理解成手
        LinkedList<Integer> hands = new LinkedList<>();
        for (Integer integer : desk) {

            //判断手上的牌是否大于1张
            if (hands.size() > 1) {
                //如果大于一张，则把手牌的最后一张放在最上面
                hands.addFirst(hands.pollLast());
            }

            //从桌子上拿一张牌放在手上
            hands.addFirst(integer);
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{1,12,2,8,3,11,4,9,5,13,6,10,7};
        poker(array);

        int[] array2 = new int[]{13,12,11,10,9,8,7,6,5,4,3,2,1};
        pock2(array2);

    }

}
