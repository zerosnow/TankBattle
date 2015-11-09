package com.tankteam.tankbattle.tank;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.bullet.Bullet;
import com.tankteam.tankbattle.bullet.BulletManage;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

import java.util.ArrayList;

import static com.tankteam.tankbattle.tank.Tank.Direction.DOWN;
import static com.tankteam.tankbattle.tank.Tank.Direction.UP;

/**
 * Created by leiyong on 15/10/13.
 */
public class EnemyTank extends Tank {
    enum EnemyType {
        NORMAL, SENIOR, STRONG,
    }
    private EnemyType type;
    ArrayList<EnemyTank> enemyTankList;

    protected EnemyTank(EnemyType type, ArrayList<EnemyTank> enemyTankList) {
        super();
        this.enemyTankList = enemyTankList;
        this.type = type;
        direction = Direction.DOWN;
        power = 1;
        fireCoolingTime = 1;
        y = 0;
        //根据type来设置属性
        switch (type) {
            //位置,贴图,血量,攻击力,状态,开火冷却等
            case NORMAL:
                super.setPixmap(Assets.enemyTank_enemy1D);
                bulletType = Bullet.BulletType.ENEMY_NORMAL;
                x = 120;
                blood = 1;
                setVelocity(0, 50);
                break;
            case SENIOR:
                super.setPixmap(Assets.enemyTank_enemy2D);
                bulletType = Bullet.BulletType.ENEMY_NORMAL;
                x = 450;
                blood = 1;
                setVelocity(0, 50);
                break;
            case STRONG:
                super.setPixmap(Assets.enemyTank_enemy3D);
                bulletType = Bullet.BulletType.ENEMY_STRONG;
                x = 810;
                blood = 2;
                setVelocity(0, 50);
                break;
            default:
                super.setPixmap(Assets.enemyTank_enemy1D);
                bulletType = Bullet.BulletType.ENEMY_NORMAL;
                x = 120;
                blood = 1;
                setVelocity(0, 50);
                break;
        }

    }

    @Override
    public void fire() {
        if (currentFireCooling <= 0) {
            Bullet bullet = BulletManage.getInstance().CreateBullet(Bullet.BulletType.HERO_NORMAL, this);
            bulletLayer.add(bullet);
            currentFireCooling = fireCoolingTime;
        }
    }

    @Override
    public void kill() {
        enemyTankList.remove(this);
        super.kill();
    }

    @Override
    public void setBulletLayer(Layer bulletLayer) {
        this.bulletLayer = bulletLayer;
    }

    @Override
    public void draw(Graphics g) {
        g.drawPixmap(pixmap, x, y);
    }

    @Override
    public void update(float deltaTime) {
        if (currentFireCooling > 0)
            currentFireCooling -= deltaTime;
        x += vx * deltaTime;
        y += vy * deltaTime;
        if (y > 540) this.kill();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean collision(Sprite sprite) {
        return false;
    }
}
