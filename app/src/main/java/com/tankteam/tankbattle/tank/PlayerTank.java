package com.tankteam.tankbattle.tank;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.bullet.Bullet;
import com.tankteam.tankbattle.bullet.BulletManage;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

import static com.tankteam.tankbattle.tank.Tank.Direction.*;

/**
 * Created by leiyong on 15/10/13.
 */
public class PlayerTank extends Tank{
    enum State {//正常,无敌,
        NORMAL, INVINCIBILITY,
    }

    private int rank;
    private State state;
    private boolean isMoving = false;


    private static PlayerTank playerTank=null;
    public static PlayerTank getTank() {
        if (playerTank == null)
            playerTank = new PlayerTank(Assets.playerTank_p1tankU);
        return playerTank;
    }

    private PlayerTank(Pixmap pixmap) {
        super();
        super.setPixmap(pixmap);
        x = 340;
        y = 560;
        this.width = this.height = 60;
        rank = 1;
        state = State.NORMAL;
        blood = 1;
        power = 1;
        direction = UP;
        fireCoolingTime = 1;
        bulletType = Bullet.BulletType.HERO_NORMAL;
    }

    @Override
    public void fire() {
        if (currentFireCooling <= 0) {
            Bullet bullet = BulletManage.getInstance().CreateBullet(Bullet.BulletType.HERO_NORMAL, this);
            bulletLayer.add(bullet);
            currentFireCooling = fireCoolingTime;
        }
    }

    public void kill() {
        super.kill();
    }

    @Override
    public void draw(Graphics g) {
        g.drawPixmap(pixmap, x, y);
    }

    @Override
    public void update(float deltaTime) {
        if (currentFireCooling > 0)
            currentFireCooling -= deltaTime;
        if (isMoving == true) {
            x += vx * deltaTime;
            y += vy * deltaTime;
            System.out.println(x + " " + y + " " + vx + " " + vy + " " + deltaTime);
        }
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void setBulletLayer(Layer bulletLayer) {
        this.bulletLayer = bulletLayer;
    }

    @Override
    public boolean collision(Sprite sprite) {
        return false;
    }
}
