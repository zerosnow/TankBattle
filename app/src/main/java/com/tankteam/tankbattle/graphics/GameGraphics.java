package com.tankteam.tankbattle.graphics;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by leiyong on 15/10/14.
 */
public class GameGraphics implements Graphics {
    //资源读取方式
    AssetManager assets;
    //图片缓冲
    Bitmap frameBuffer;
    //绘制画布
    Canvas canvas;
    //绘制画笔
    Paint paint;
    //源区域
    Rect srcRect = new Rect();
    //目标区域
    Rect dstRect = new Rect();

    public GameGraphics(AssetManager assets, Bitmap frameBuffer) {
        this.assets = assets;
        this.frameBuffer = frameBuffer;
        this.canvas = new Canvas(frameBuffer);
        this.paint = new Paint();
    }

    @Override
    public Pixmap newPixmap(String fileName) {
        InputStream in = null;
        Bitmap bitmap = null;
        try {
            in = assets.open(fileName);
            bitmap = BitmapFactory.decodeStream(in);
            if (bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"+fileName+"'");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load bitmap from asset '"+fileName+"'");
        }finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        return new GamePixmap(bitmap);
    }

    @Override
    public void clear(int color) {
        canvas.drawRGB((color & 0xff0000)>>16, (color & 0x00ff00)>>8, (color & 0x0000ff));
    }

    @Override
    public void drawPixel(int x, int y, int color) {
        paint.setColor(color);
        canvas.drawPoint(x, y, paint);
    }

    @Override
    public void drawLine(int x, int y, int x2, int y2, int color) {
        paint.setColor(color);
        canvas.drawLine(x, y, x2, y2, paint);
    }

    @Override
    public void drawRect(int x, int y, int width, int height, int color) {
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x, y, x+width-1, y+height-1, paint);
    }

    @Override
    public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight) {
        srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX+srcWidth-1;
        srcRect.bottom = srcY+srcHeight-1;
        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x+srcWidth-1;
        dstRect.bottom = y+srcHeight-1;
        canvas.drawBitmap(((GamePixmap)pixmap).bitmap, srcRect, dstRect, null);
    }

    @Override
    public void drawPixmap(Pixmap pixmap, int x, int y) {
        canvas.drawBitmap(((GamePixmap)pixmap).bitmap, x, y, null);
    }

    @Override
    public void drawText(String text, int x, int y, int color) {
        paint.setColor(color);
        canvas.drawText(text, x, y, paint);
    }

    @Override
    public int getWidth() {
        return frameBuffer.getWidth();
    }

    @Override
    public int getHeight() {
        return frameBuffer.getHeight();
    }
}
