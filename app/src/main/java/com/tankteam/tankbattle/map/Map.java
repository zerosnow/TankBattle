package com.tankteam.tankbattle.map;

import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

/**
 * Created by leiyong on 15/10/13.
 */
public class Map extends Sprite{
    public enum  MapType {
        WATER, //其他type
    }
    private MapType mapType;
    //添加其他属性


    public Map(Pixmap pixmap, MapType mapType) {
        super(pixmap);
        this.mapType = mapType;

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
    //添加更多方法




}
