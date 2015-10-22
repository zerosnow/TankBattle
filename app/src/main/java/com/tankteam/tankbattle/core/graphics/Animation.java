package com.tankteam.tankbattle.core.graphics;

/**
 * Created by leiyong on 15/10/22.
 */
public class Animation implements Runnable {
    private Pixmap[] pixmaps;
    private float time;
    //动画播放的位置
    private int x, y;
    private Graphics graphics;

    public Animation(Graphics graphics, Pixmap[] pixmaps) {
        this.pixmaps = pixmaps;
        this.graphics = graphics;
    }

    public void play(float time, int x, int y) {
        this.time = time;
        this.x = x;
        this.y = y;
        Thread playThread = new Thread(this);
        playThread.start();
    }

    @Override
    public void run() {
        int pixmapsCounts = pixmaps.length;
        long startTime = System.nanoTime();
        for (int i=0;i<pixmapsCounts;) {
            float deltaTime = (System.nanoTime() - startTime)/1000000000.0f;
            graphics.drawPixmap(pixmaps[i], x, y);
            if (deltaTime > time / pixmapsCounts) {
                startTime = System.nanoTime();
                i++;
            }
        }
    }
}
