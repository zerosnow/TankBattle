package com.tankteam.tankbattle.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.tankteam.tankbattle.core.game.GameActivity;

/**
 * Created by leiyong on 15/10/15.
 */
public class GameFastRenderView extends SurfaceView implements Runnable {
    GameActivity game;
    Bitmap framebuffer;
    Thread renderThread = null;
    SurfaceHolder holder;
    volatile boolean running = false;

    public GameFastRenderView(GameActivity game, Bitmap framebuffer) {
        super(game);
        this.game = game;
        this.framebuffer = framebuffer;
        this.holder = getHolder();
    }

    public void resume() {
        running = true;
        renderThread = new Thread(this);
        renderThread.start();
    }

    public void pause() {
        running = false;
        while (true) {
            try {
                renderThread.join();
                break;
            }catch (InterruptedException e) {
                //retry
            }
        }
    }

    @Override
    public void run() {
        Rect dstRect = new Rect();
        long startTime = System.nanoTime();
        while(running) {
            if (!holder.getSurface().isValid())
                continue;
            float deltaTime = (System.nanoTime()-startTime)/1000000000.0f;
            startTime = System.nanoTime();

            game.getCurrentScene().update(deltaTime);
            game.getCurrentScene().present();

            Canvas canvas = holder.lockCanvas();
            canvas.getClipBounds(dstRect);
            canvas.drawBitmap(framebuffer, null, dstRect, null);
            holder.unlockCanvasAndPost(canvas);

        }
    }
}
