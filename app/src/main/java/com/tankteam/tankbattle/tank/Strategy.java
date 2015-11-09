package com.tankteam.tankbattle.tank;

import java.util.ArrayList;

/**
 * Created by leiyong on 15/11/9.
 */
public class Strategy {
    boolean hasInit = false;
    private ArrayList<int[]> strategyList;

    private static Strategy strategy=null;
    private Strategy() {
        InitStrategy();
    }

    public static Strategy getInstance() {
        if (strategy == null)
            strategy = new Strategy();
        return strategy;
    }

    public void InitStrategy() {
        if (!hasInit) {
            strategyList = new ArrayList<int[]>();
            int[] newStrategy1 = {2, 2, 5, 3, 4, 5, 1, 5, 4, 5, 2, 3, 5, 1, 5};      //1,2,3,4,5分别表示上下左右开火,持续时间1秒
            strategyList.add(newStrategy1);
            int[] newStrategy2 = {3, 2, 5, 3, 4, 5, 1, 5, 4, 5, 3, 3, 5, 1, 5};      //1,2,3,4,5分别表示上下左右开火,持续时间1秒
            strategyList.add(newStrategy2);
            int[] newStrategy3 = {2, 5, 4, 3, 4, 5, 1, 5, 4, 3, 2, 2, 5, 1, 5};      //1,2,3,4,5分别表示上下左右开火,持续时间1秒
            strategyList.add(newStrategy3);
            int[] newStrategy4 = {3, 2, 5, 3, 3, 5, 1, 5, 4, 5, 3, 3, 5, 1, 5};      //1,2,3,4,5分别表示上下左右开火,持续时间1秒
            strategyList.add(newStrategy4);
            hasInit = true;
        }
    }

    public int[] getStrategy(int i) {
        return strategyList.get(i);
    }

    public int getSize() {
        return strategyList.size();
    }
}
