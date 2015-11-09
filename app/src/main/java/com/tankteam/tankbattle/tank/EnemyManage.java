package com.tankteam.tankbattle.tank;

import com.tankteam.tankbattle.Manage;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

import java.util.ArrayList;
import java.util.Random;

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

    private float createCoolTime = 0;

    private ArrayList<EnemyTank> enemyTankList = null;

    private EnemyManage() {
        super();
        currentTank = 0;
        tankInWarehouse = 20;
        enemyTankList = new ArrayList<EnemyTank>(6);
    }

    public ArrayList<EnemyTank> getEnemyTankList() {
        return enemyTankList;
    }

    public EnemyTank CreateEnemy(float deltaTime) {
        if (createCoolTime <= 0) {
            if (currentTank < MAX_EXIST_TANK || tankInWarehouse > 0) {
                if (enemyTankList.size() < 6) {
                    EnemyTank.EnemyType type = EnemyTank.EnemyType.NORMAL;
                    switch ((int)(Math.random()*3)) {
                        case 0: break;
                        case 1:
                            type = EnemyTank.EnemyType.SENIOR;
                            break;
                        case 2:
                            type = EnemyTank.EnemyType.STRONG;
                            break;
                        default:
                            type = EnemyTank.EnemyType.NORMAL;
                            break;
                    }
                    EnemyTank enemyTank = new EnemyTank(type, enemyTankList);
                    enemyTankList.add(enemyTank);
                    currentTank++;
                    tankInWarehouse--;
                    createCoolTime = 3;
                    return enemyTank;
                }
            }
        }
        createCoolTime -= deltaTime;
        return null;
    }
}
