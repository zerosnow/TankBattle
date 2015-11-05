package com.tankteam.tankbattle.tank;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.bullet.Bullet;
import com.tankteam.tankbattle.bullet.BulletManage;
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
        x = 390;
        y = 610;
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
            switch (direction) {
                //根据属性创建子弹
                case UP:
                    break;
                case DOWN:
                    break;
                case LEFT:
                    break;
                case RIGHT:
                    break;
            }
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
            switch (direction) {
                case UP:
                    setVelocity(0, -40);
                    break;
                case DOWN:
                    setVelocity(0, 40);
                    break;
                case LEFT:
                    setVelocity(-40, 0);
                    break;
                case RIGHT:
                    setVelocity(40, 0);
                    break;
            }
            x += vx * deltaTime;
            y += vy * deltaTime;
        }
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean collision(Sprite sprite) {
        return false;
    }
}
