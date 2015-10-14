package com.tankteam.tankbattle.graphics;

import android.graphics.Bitmap;

/**
 * Created by leiyong on 15/10/14.
 */
public class GamePixmap implements Pixmap{
    Bitmap bitmap;

    public GamePixmap(Bitmap bitmap) {
        this.bitmap = bitmap;
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
    public void dispose() {
        bitmap.recycle();
    }
}
