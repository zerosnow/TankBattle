package com.tankteam.tankbattle.testcore;

import android.graphics.Color;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Sprite;
import com.tankteam.tankbattle.tank.Tank;

/**
 * Created by leiyong on 15/10/22.
 */
public class Tanktest extends Sprite {
    private int x;

    public Tanktest() {
        super();
        x = 0;
        setVelocity(100, 0);
        setPixmap(Assets.enemyTank_enemy1R);
    }

    @Override
    public void draw(Graphics g) {
        g.drawText("按任意键返回", g.getWidth()/2, g.getHeight()/2, 50, 0xff0000ff);
        g.drawPixmap(pixmap, x, 0);
    }

    @Override
    public void update(float deltaTime) {
        x += vx * deltaTime;
    }


    @Override
    public boolean collision(Sprite sprite) {
        return false;
    }
}
