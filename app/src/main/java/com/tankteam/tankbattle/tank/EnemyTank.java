package com.tankteam.tankbattle.tank;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.bullet.Bullet;
import com.tankteam.tankbattle.bullet.BulletManage;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;
import com.tankteam.tankbattle.map.Map;
import com.tankteam.tankbattle.map.MapManage;

import java.util.ArrayList;

import static com.tankteam.tankbattle.tank.Tank.Direction.DOWN;
import static com.tankteam.tankbattle.tank.Tank.Direction.LEFT;
import static com.tankteam.tankbattle.tank.Tank.Direction.RIGHT;
import static com.tankteam.tankbattle.tank.Tank.Direction.UP;

/**
 * Created by leiyong on 15/10/13.
 */
public class EnemyTank extends Tank {
    enum EnemyType {
        NORMAL, SENIOR, STRONG,
    }
    private EnemyType type;
    private float moveTime;

    ArrayList<EnemyTank> enemyTankList;
    int[] moveStrategy;
    int whichStrategy;

    protected EnemyTank(EnemyType type, ArrayList<EnemyTank> enemyTankList) {
        super();
        this.enemyTankList = enemyTankList;
        this.type = type;
        direction = Direction.DOWN;
        power = 1;
        fireCoolingTime = 1;
        moveTime = 1;
        y = 0;
        this.width = this.height = 60;
        whichStrategy = 0;
        moveStrategy = Strategy.getInstance().getStrategy((int)(Math.random()*Strategy.getInstance().getSize()));
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
                x = 780;
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
            Bullet bullet = BulletManage.getInstance().CreateBullet(Bullet.BulletType.ENEMY_NORMAL, this);
            this.bulletLayer.add(bullet);
            Assets.music_fire.play(1);
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
        if (moveTime <= 0) {
            whichStrategy++;
            if (whichStrategy >= moveStrategy.length)
                whichStrategy = 0;                  //循环实行策略
            moveTime = 2;
        }
        moveTime -= deltaTime;
        switch (moveStrategy[whichStrategy]) {
            case 1:
                direction = UP;
                switch (type) {
                    case NORMAL:
                        super.setPixmap(Assets.enemyTank_enemy1U);
                        break;
                    case SENIOR:
                        super.setPixmap(Assets.enemyTank_enemy2U);
                        break;
                    case STRONG:
                        super.setPixmap(Assets.enemyTank_enemy3U);
                        break;
                    default:
                        super.setPixmap(Assets.enemyTank_enemy1U);
                        break;
                }
                setVelocity(0 ,-50);
                break;
            case 2:
                direction = DOWN;
                switch (type) {
                    case NORMAL:
                        super.setPixmap(Assets.enemyTank_enemy1D);
                        break;
                    case SENIOR:
                        super.setPixmap(Assets.enemyTank_enemy2D);
                        break;
                    case STRONG:
                        super.setPixmap(Assets.enemyTank_enemy3D);
                        break;
                    default:
                        super.setPixmap(Assets.enemyTank_enemy1D);
                        break;
                }
                setVelocity(0 ,50);
                break;
            case 3:
                direction = LEFT;
                switch (type) {
                    case NORMAL:
                        super.setPixmap(Assets.enemyTank_enemy1L);
                        break;
                    case SENIOR:
                        super.setPixmap(Assets.enemyTank_enemy2L);
                        break;
                    case STRONG:
                        super.setPixmap(Assets.enemyTank_enemy3L);
                        break;
                    default:
                        super.setPixmap(Assets.enemyTank_enemy1L);
                        break;
                }
                setVelocity(-50 ,0);
                break;
            case 4:
                direction = RIGHT;
                switch (type) {
                    case NORMAL:
                        super.setPixmap(Assets.enemyTank_enemy1R);
                        break;
                    case SENIOR:
                        super.setPixmap(Assets.enemyTank_enemy2R);
                        break;
                    case STRONG:
                        super.setPixmap(Assets.enemyTank_enemy3R);
                        break;
                    default:
                        super.setPixmap(Assets.enemyTank_enemy1R);
                        break;
                }
                setVelocity(50 ,0);
                break;
            case 5:
                fire();
                moveTime = 0;
                break;
            default:
                break;
        }
        x += vx * deltaTime;
        y += vy * deltaTime;
        if (!canMove()) {
            x -= vx * deltaTime;
            y -= vy * deltaTime;
        }
    }

    private boolean canMove() {
        if (x < 120 || x + width > 840 || y < 0 || y + height > 640)
            return false;
        if (collision(EnemyManage.getInstance()))
            return false;
        if (collision(MapManage.getInstance()))
            return false;
        if (collision(PlayerTank.getTank()))
            return false;
        return true;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean collision(Sprite sprite) {
        if (x == sprite.x && y == sprite.y)
            return false;
        if (x < sprite.x + sprite.width - 2 && x + width > sprite.x + 2
                && y < sprite.y + sprite.height - 2 && y + height > sprite.y + 2)
            return true;
        return false;
    }

    public boolean collision(EnemyManage enemyManage) {
        for (int i=0;i<enemyManage.getEnemyTankList().size();i++)
            if (this != enemyManage.getEnemyTankList().get(i) && collision(enemyManage.getEnemyTankList().get(i))) return true;
        return false;
    }

    public boolean collision(MapManage mapManage) {
        ArrayList<Map> mapList = mapManage.getMapList();
        for (int i=0;i<mapList.size();i++)
            if (mapList.get(i).canTankCollition && collision(mapList.get(i))) return true;
        return false;
    }

}
