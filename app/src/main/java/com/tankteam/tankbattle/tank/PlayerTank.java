package com.tankteam.tankbattle.tank;

import com.tankteam.tankbattle.bullet.Bullet;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

/**
 * Created by leiyong on 15/10/13.
 */
public class PlayerTank extends Tank{
    enum State {//正常,无敌,
        NORMAL ,INVINCIBILITY
    }

    private int rank;
    private State state;



    protected PlayerTank(Pixmap pixmap) {
        super(pixmap);
        rank = 1;
        state = State.NORMAL;
        blood = 1;
        power = 1;
        direction = Direction.UP;
        fireCoolingTime = 1;
        bulletType = Bullet.BulletType.HERO_NORMAL;
    }

    @Override
    public void fire() {

    }

    @Override
    public void Dead() {

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
}
