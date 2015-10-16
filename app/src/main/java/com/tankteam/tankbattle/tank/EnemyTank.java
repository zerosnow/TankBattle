package com.tankteam.tankbattle.tank;

import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

/**
 * Created by leiyong on 15/10/13.
 */
public class EnemyTank extends Tank {
    enum Type {
        NORMAL, SENIOR, STRONG,
    }
    private Type type;

    protected EnemyTank(Pixmap pixmap, Type type) {
        super(pixmap);
        this.type = type;
        direction = Direction.DOWN;
        //根据type来设置属性

        



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
