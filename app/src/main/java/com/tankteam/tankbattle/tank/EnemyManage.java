package com.tankteam.tankbattle.tank;

import com.tankteam.tankbattle.Manage;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

import java.util.ArrayList;

/**
 * Created by leiyong on 15/10/13.
 */
public class EnemyManage extends Manage{
    //单例
    private static EnemyManage enemyManage = null;
    public static EnemyManage getInstance() {
        if (enemyManage == null)
            enemyManage = new EnemyManage();
        return enemyManage;
    }

    //最大同时存在的坦克数量
    private static final int MAX_EXIST_TANK = 6;
    //当前存在的坦克数量
    private int currentTank;
    //剩余的坦克数量
    private int tankInWarehouse;

    ArrayList<EnemyTank> enemyTankList = null;

    private EnemyManage() {
        super();
        currentTank = 0;
        tankInWarehouse = 20;
        enemyTankList = new ArrayList<EnemyTank>(6);
    }

    public EnemyTank CreateEnemy(Pixmap pixmap, EnemyTank.EnemyType type) {
        if (currentTank < MAX_EXIST_TANK || tankInWarehouse > 0) {
            EnemyTank enemyTank = new EnemyTank(pixmap, type);
            if (enemyTankList.size() < 6) {
                enemyTankList.add(enemyTank);
                currentTank++;
                tankInWarehouse--;
                return enemyTank;
            }
            return null;
        }
        return null;
    }
}
