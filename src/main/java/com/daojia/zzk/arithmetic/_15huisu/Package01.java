package com.daojia.zzk.arithmetic._15huisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@author zhangzk
 * 回溯算法之0-1背包问题
 * 我们可以把物品依次排列，整个问题就分解为了 n 个阶段，每个阶段对应一个物品怎么选择。
 * 先对第一个物品进行处理，选择装进去或者不装进去，然后再递归地处理剩下的物品。
 */
public class Package01 {

    // 存储背包中物品总重量的最大值
    public int maxW = Integer.MIN_VALUE;

    // 下标表示物品序号，值表示是否放进背包:1放，0不放
    private int[] currentAnswer;

    //存储所有解(map key表示放进去的重量，value表示对应重量的物品放法)，
    //最终所有最优解为bestAnswerMap.get(maxW)
    private Map<Integer, List<int[]>> bestAnswerMap = new HashMap();

    /**
     * i: 表示考察到第i个物品
     * cw:表示当前已经装进去的物品的重量和
     * items:表示每个物品的重量数组
     * n:表示物品个数
     * w:表示背包重量
     * 假设背包可以承受重量100，物品个数是10，物品重量存储再数组a中可以调用函数：f(0, 0, a, 10, 100)
     * */
    public void f(int i, int cw, int[] items, int n, int w) {
        // cw==w 表示装满了；i==n表示数组中所有物品都考察完了
        if (cw == w || i == n) {
            if (cw > maxW) maxW = cw;
            return;
        }
        // 第 29 行的递归调用表示不选择当前物品，直接考虑下一个（第 i+1 个），故 cw 不更新
        // 当前物品不装进背包
        f(i+1, cw, items, n, w);
        if (cw + items[i] <= w) {   // 已经超过可以背包承受的重量的时候，就不要再装了
            // 第 13 行的递归调用表示选择了当前物品，故考虑下一个时，cw 通过入参更新为 cw + items[i]
            f(i+1,cw + items[i], items, n, w);
        }
    }

    /**
     *
     * 最终maxW 对应的所有最优解为bestAnswerMap.get(maxW)
     * */
    public void f2 (int i, int cw, int[] items, int n, int w) {
        if(currentAnswer == null){
            currentAnswer = new int[n];
        }

        if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
            if (cw >= maxW) {
                maxW = cw;
                int[] bestAnswer = new int[currentAnswer.length];
                for(int j=0; j<currentAnswer.length; j++){
                    bestAnswer[j] = currentAnswer[j];
                }
                if(bestAnswerMap.containsKey(cw)){
                    bestAnswerMap.get(cw).add(bestAnswer);
                }else{
                    List<int[]> list = new ArrayList<int[]>();
                    list.add(bestAnswer);
                    bestAnswerMap.put(cw, list);
                }
            }
            return;
        }

        currentAnswer[i] = 0;
        f(i+1, cw, items, n, w);
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            currentAnswer[i] = 1;
            f(i+1,cw + items[i], items, n, w);
        }
    }

}
