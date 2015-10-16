package com.tankteam.tankbattle.bullet;

import com.tankteam.tankbattle.Manage;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.tank.Tank;

import java.util.ArrayList;

/**
 * Created by leiyong on 15/10/13.
 */
public class BulletManage extends Manage{
    private static BulletManage bulletManage = null;
    public static BulletManage getInstance() {
        if (bulletManage == null) {
            bulletManage = new BulletManage();
        }
        return bulletManage;
    }

    //最大同时存在子弹数
    private static final int MAX_EXIST_BULLET = 100;
    ArrayList<Bullet> bulletList;

    //添加其他属性

    //构造函数
    private BulletManage() {
        super();
        bulletList = new ArrayList<Bullet>(MAX_EXIST_BULLET);
    }

    //创建子弹
    public Bullet CreateBullet(Pixmap pixmap, Bullet.BulletType bulletType, Tank tank) {
        return null;
    }

    //添加更多方法

}
