package com.tankteam.tankbattle.core.graphics;


import com.tankteam.tankbattle.core.game.Layer;

/**
 * Created by leiyong on 15/10/14.
 */
public abstract class Sprite extends Object{
    //屏幕坐标系的x,y坐标
    public int x, y;
    //屏幕坐标系的精灵的大小
    public int width, height;
    //x, y 轴放大后的速度值
    public int vx, vy;
    //扩大后的位移
    protected int x_scale, y_scale;
    //之前的位置
    public int x_old, y_old;
    //默认格式
    protected Graphics.PixmapFormat format = Graphics.PixmapFormat.RGB565;

    //父类层次
    protected Layer parentLayer;
    //消亡的标志
    private boolean killNextUpdate;
    //贴图
    protected Pixmap pixmap = null;
    //碰撞标志
    protected boolean canCollition = false;

    protected Sprite(Pixmap pixmap) {
        super();
        this.pixmap = pixmap;
    }

    //消亡调用的方法
    public void onRemove() {
    }
    //精灵绘制的方法
    public abstract void draw(Graphics g);
    //状态更新
    public abstract void update(float deltaTime);

    //碰撞检测
    public abstract boolean collision(Sprite sprite);

    //精灵移动的方法
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
        this.x_scale = x << 8;
        this.y_scale = y << 8;
        this.x_old = x;
        this.y_old = y;
    }

    //设置速度
    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }

    //是否存活
    public boolean isAlive() {
        if (killNextUpdate) {
            onRemove();
            return false;
        } else {
            return true;
        }
    }

    //是否需要在屏幕中
    public boolean isOnScene() {
        if (parentLayer == null) {
            return false;
        }
        return true;
    }
    //消亡
    public void remove() {
        killNextUpdate = true;
        parentLayer = null;
    }

    //精灵被加入层次
    public void onAdd(Layer layer) {
        parentLayer = layer;
        killNextUpdate = false;
    }
}
