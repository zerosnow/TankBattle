package com.tankteam.tankbattle.core.graphics;

/**
 * Created by leiyong on 15/10/13.
 */
public interface Graphics {
    enum PixmapFormat {
        ARGB8888, ARGB4444, RGB565
    }
    //使用JPEG或png加载一个图像
    Pixmap newPixmap(String fileName, PixmapFormat format);
    //使用Pixmap数组构造一个动画
    Animation newAnimation(Pixmap[] pixmaps);

    //使用给定color清除整个缓冲区的颜色
    void clear(int color);

    void drawPixel(int x, int y, int color);

    void drawLine(int x, int y, int x2, int y2, int color);

    void drawRect(int x, int y, int width, int height, int color);

    void drawColor(int color);

    //x,y为相对屏幕左上角的坐标，src为pixmap中指定的矩形区域
    void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight);

    //默认为整个pixmap
    void drawPixmap(Pixmap pixmap, int x, int y);

    //扩展
    void drawPixmap(Pixmap pixmap, float x, float y);

    void drawText(String text, int x, int y, float size, int color);

    int getWidth();

    int getHeight();

}
