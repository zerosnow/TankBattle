package com.tankteam.tankbattle.core.game;

import com.tankteam.tankbattle.core.graphics.Graphics;
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
        if (sprite == null) {
            return;
        }
        if (gameObjects.size() == maximumSprite) {
            return;
        }
        gameObjects.add(sprite);
        sprite.onAdd(this);
    }

    //清除已死亡的精灵
    protected void removeDead() {
        for (int i=0;i<gameObjects.size();i++) {
            if(gameObjects.get(i) != null) {
                while (gameObjects.get(i) != null && !gameObjects.get(i).isAlive()) {
                    gameObjects.remove(i);
                }
            }
        }
    }

    //绘制层次中的精灵
    protected void onDraw(Graphics g) {
        removeDead();
        for (int i=0;i<gameObjects.size();i++) {
            if (gameObjects.get(i) != null) {
                try {
                    gameObjects.get(i).Update();
                    if (gameObjects.get(i).isOnScene()) {
                        gameObjects.get(i).draw(g);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
