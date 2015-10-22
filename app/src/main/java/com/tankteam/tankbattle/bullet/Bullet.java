package com.tankteam.tankbattle.bullet;

import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;
import com.tankteam.tankbattle.tank.Tank;

/**
 * Created by leiyong on 15/10/13.
 */
public class Bullet extends Sprite{
    public enum BulletType {
        HERO_NORMAL, HERO_STRONG, ENEMY_NORMAL, ENEMY_STRONG,
    }

    BulletType bulletType;
    Tank.Direction direction;

    //添加其他属性

    public Bullet(Pixmap pixmap, BulletType bulletType, Tank tank) {
        super();
        super.setPixmap(pixmap);
        this.bulletType = bulletType;
        this.direction = tank.getDirection();
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public boolean collision(Sprite sprite) {
        return false;
    }

    //添加更多方法

}
