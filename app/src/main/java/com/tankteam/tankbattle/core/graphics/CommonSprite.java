package com.tankteam.tankbattle.core.graphics;

/**
 * Created by leiyong on 15/10/26.
 */
public class CommonSprite extends Sprite {

    public CommonSprite(Pixmap pixmap, int x, int y) {
        this.pixmap = pixmap;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        g.drawPixmap(pixmap, x, y);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public boolean collision(Sprite sprite) {
        return false;
    }
}
