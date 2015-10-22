package com.tankteam.tankbattle.core.game;

import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

import java.util.ArrayList;

/**
 * Created by leiyong on 15/10/14.
 */
public class Layer {
    //父场景对象
    protected Scene parentScene;
    //层次中的精灵容器
    protected ArrayList<Sprite> gameObjects;
    //精灵容器的最大容量
    protected int maximumSprite;

    //创建一个场景中的层次
    public Layer(Scene parentScene, int maximumSprite) {
        this.parentScene = parentScene;
        this.maximumSprite = maximumSprite;
        gameObjects = new ArrayList<Sprite>(maximumSprite);
    }

    //得到层次中的精灵
    public Sprite getSprite(int index) {
        return gameObjects.get(index);
    }

    //清空所有精灵
    public void clear() {
        gameObjects.clear();
    }

    //在层次中添加精灵
    public void add(Sprite sprite) {
        if (sprite == null)
            return;
        if (gameObjects.size() == maximumSprite)
            return;
        gameObjects.add(sprite);
        sprite.onAdd(this);
    }

    //清除已死亡的精灵
    protected void removeDead() {
        for (int i=0;i<gameObjects.size();i++)
            if (gameObjects.get(i) != null && !gameObjects.get(i).isAlive())
                gameObjects.remove(i);
    }

    //更新层次中的精灵
    protected void update(float deltaTime) {
        for (int i=0;i<gameObjects.size();i++)
            if (gameObjects.get(i) != null)
                gameObjects.get(i).update(deltaTime);
    }

    //使用颜色绘制背景层
    public void drawBackGround(Graphics graphics, int color) {
        graphics.drawRect(0, 0, graphics.getWidth(), graphics.getHeight(), color);
    }

    //使用图片绘制背景层
    public void drawBackGround(Graphics graphics, String fileName) {
        Pixmap pixmap = graphics.newPixmap(fileName, Graphics.PixmapFormat.RGB565);
        graphics.drawPixmap(pixmap, 0, 0);
    }

    public void drawText(Graphics graphics, String text, int x, int y, float size,int color) {
        graphics.drawText(text, x, y, size, color);
    }

    //绘制层次中的精灵
    protected void onDraw(Graphics g) {
        removeDead();
        for (int i=0;i<gameObjects.size();i++)
            if (gameObjects.get(i) != null)
                if (gameObjects.get(i).isOnScene())
                    gameObjects.get(i).draw(g);
    }
}
