package com.tankteam.tankbattle.bullet;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.TankBattle;
import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;
import com.tankteam.tankbattle.map.Map;
import com.tankteam.tankbattle.map.MapManage;
import com.tankteam.tankbattle.scenes.GameScene;
import com.tankteam.tankbattle.tank.EnemyManage;
import com.tankteam.tankbattle.tank.PlayerTank;
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
        if (hit()) {
            Assets.music_hit.play(1);
            this.remove();
        }
    }

    private boolean hit() {
        if (collision(MapManage.getInstance()))
            return true;
        if (this.bulletType == BulletType.ENEMY_NORMAL || this.bulletType == BulletType.ENEMY_STRONG)
            if (collision(PlayerTank.getTank())) {
                PlayerTank.getTank().kill();
                return true;
            }
        if (this.bulletType == BulletType.HERO_NORMAL || this.bulletType == BulletType.HERO_STRONG)
            if (collision(EnemyManage.getInstance()))
                return true;
        return false;
    }

    @Override
    public boolean collision(Sprite sprite) {
        if (x < sprite.x + sprite.width && x + width > sprite.x
                && y < sprite.y + sprite.height && y + height > sprite.y)
            return true;
        return false;
    }

    public boolean collision(EnemyManage enemyManage) {
        for (int i=0;i<enemyManage.getEnemyTankList().size();i++)
            if (collision(enemyManage.getEnemyTankList().get(i))) {
                enemyManage.getEnemyTankList().get(i).kill();
                return true;
            }
        return false;
    }

    public boolean collision(MapManage mapManage) {
        ArrayList<Map> mapList = mapManage.getMapList();
        for (int i=0;i<mapList.size();i++)
            if (mapList.get(i).canBulletCollition && collision(mapList.get(i))) {
                if (mapList.get(i).getMapType() == 1)   //砖块
                    mapList.get(i).remove();
                else if ((this.bulletType == BulletType.ENEMY_STRONG || this.bulletType == BulletType.HERO_STRONG)
                        && mapList.get(i).getMapType() == 2)    //铁砖块
                    mapList.get(i).remove();
                else if (mapList.get(i).getMapType() == 5) {     //SYMBOL
                    mapList.get(i).remove();
                    TankBattle.getInstance().onFail();
                }
                return true;
            }
        return false;
    }

}
