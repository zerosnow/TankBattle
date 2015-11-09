package com.tankteam.tankbattle.bullet;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;
import com.tankteam.tankbattle.tank.Tank;

import java.util.ArrayList;

/**
 * Created by leiyong on 15/10/13.
 */
public class Bullet extends Sprite{
    public enum BulletType {
        HERO_NORMAL, HERO_STRONG, ENEMY_NORMAL, ENEMY_STRONG,
    }

    private float bulletOffset = -8;

    BulletType bulletType;
    Tank.Direction direction;
    ArrayList<Bullet> bulletList;

    private int bulletSpeed;


    public Bullet(BulletType bulletType, Tank tank, ArrayList<Bullet> bulletList) {
        super();
        this.bulletList = bulletList;
        this.bulletType = bulletType;
        this.width = this.height = 15;
        this.direction = tank.getDirection();
        switch (bulletType) {
            case HERO_NORMAL:
                super.setPixmap(Assets.bullet_tankmissile);
                bulletSpeed = 70;
                break;
            case HERO_STRONG:
                super.setPixmap(Assets.bullet_tankmissile);
                bulletSpeed = 120;
                break;
            case ENEMY_NORMAL:
                super.setPixmap(Assets.bullet_enemymissile);
                bulletSpeed = 70;
                break;
            case ENEMY_STRONG:
                super.setPixmap(Assets.bullet_enemymissile);
                bulletSpeed = 120;
                break;
            default:
                super.setPixmap(Assets.bullet_enemymissile);
                bulletSpeed = 70;
                break;
        }
        switch (direction) {
            case UP:
                x = tank.x + 30 + bulletOffset;
                y = tank.y + bulletOffset;
                setVelocity(0, -bulletSpeed);
                break;
            case DOWN:
                x = tank.x + 30 + bulletOffset;
                y = tank.y + 60 - bulletOffset;
                setVelocity(0, bulletSpeed);
                break;
            case LEFT:
                x = tank.x + bulletOffset;
                y = tank.y + 30 + bulletOffset;
                setVelocity(-bulletSpeed, 0);
                break;
            case RIGHT:
                x = tank.x + 60 - bulletOffset;
                y = tank.y + 30 + bulletOffset;
                setVelocity(bulletSpeed, 0);
                break;
            default:
                x = tank.x + 30 + bulletOffset;
                y = tank.y + bulletOffset;
                setVelocity(0, -bulletSpeed);
                break;
        }
    }

    public void remove() {
        bulletList.remove(this);
        super.remove();
    }

    @Override
    public void draw(Graphics g) {
        g.drawPixmap(pixmap, x, y);
    }

    @Override
    public void update(float deltaTime) {
        x += vx * deltaTime;
        y += vy * deltaTime;
    }

    @Override
    public boolean collision(Sprite sprite) {
        return false;
    }

    //添加更多方法

}
