package com.tankteam.tankbattle.core.graphics;

import android.graphics.Bitmap;

/**
 * Created by leiyong on 15/10/14.
 */
public class GamePixmap implements Pixmap{
    Bitmap bitmap;
    private Graphics.PixmapFormat format;

    public GamePixmap(Bitmap bitmap, Graphics.PixmapFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public Graphics.PixmapFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}
