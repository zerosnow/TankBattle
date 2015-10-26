package com.tankteam.tankbattle.map;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

/**
 * Created by leiyong on 15/10/13.
 */
public class Map extends Sprite{
    //地图块种类
    private static final short WALL = 1;
    private static final short STEEL = 2;
    private static final short WATER = 3;
    private static final short GRASS = 4;

    private short mapType;
    //添加其他属性


    public Map(short mapType, int x, int y) {
        super();
        this.mapType = mapType;
        this.width = this.height = 30;
        this.x = x * this.width;
        this.y = y * this.height;

        switch (mapType) {
            case WALL:
                break;
            case STEEL:
                break;
            case WATER:
                break;
            case GRASS:
                break;
        }
        
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
    //添加更多方法




}
