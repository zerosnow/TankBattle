package com.tankteam.tankbattle.tank;

import android.graphics.Rect;

import com.tankteam.tankbattle.bullet.Bullet;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

/**
 * Created by leiyong on 15/10/13.
 */
public abstract class Tank extends Sprite {
    enum Direction{
        UP, DOWN, LEFT, RIGHT
    }
    //血量
    protected int blood;
    //攻击力
    protected int power;
    //方向
    protected Direction direction;
    //当前开火冷却
    protected float currentFireCooling;
    //开火冷却时间
    protected float fireCoolingTime;
    //子弹类型
    protected Bullet.BulletType bulletType;
    //是否存活
    protected boolean isAlive;

    protected Tank(Pixmap pixmap) {
        super(pixmap);
        currentFireCooling = 0;
        isAlive = true;
    }
    //开火
    public abstract void fire();
    //死亡判断
    public boolean isDead() {
        return !isAlive;
    }
    //掉血
    public void LoseBlood(int lose) {
        blood -= lose;
        if (blood <= 0) {
            isAlive = false;
            super.remove();
        }
    }
    //死亡
    public abstract void Dead();

}
