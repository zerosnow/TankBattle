package com.tankteam.tankbattle.core.graphics;

/**
 * Created by leiyong on 15/10/13.
 */
public interface Pixmap {
    //返回Pixmap的宽和高
    int getWidth();

    int getHeight();

    Graphics.PixmapFormat getFormat();

    void dispose();
}
