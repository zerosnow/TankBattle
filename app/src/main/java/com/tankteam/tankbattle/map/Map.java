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
    private static final short SYMBOL = 5;

    private short mapType;

    //碰撞标志
    public boolean canBulletCollition = true;
    public boolean canTankCollition = true;
    //添加其他属性

    public Map(short mapType, int x, int y) {
        super();
        this.mapType = mapType;
        this.width = this.height = 30;
        this.x = x * this.width+120;
        this.y = y * this.height+40;

        switch (mapType) {
            case WALL:
                pixmap = Assets.tileMap_wall;
                break;
            case STEEL:
                pixmap = Assets.tileMap_steel;
                break;
            case WATER:
                pixmap = Assets.tileMap_water;
                canBulletCollition = false;
                break;
            case GRASS:
                pixmap = Assets.tileMap_grass;
                canBulletCollition = false;
                canTankCollition = false;
                break;
            case SYMBOL:
                pixmap = Assets.tileMap_symbol;
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
