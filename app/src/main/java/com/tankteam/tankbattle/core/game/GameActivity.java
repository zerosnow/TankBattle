package com.tankteam.tankbattle.core.game;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.tankteam.tankbattle.core.Input.GameInput;
import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.audio.Audio;
import com.tankteam.tankbattle.core.audio.GameAudio;
import com.tankteam.tankbattle.core.fileIO.FileIO;
import com.tankteam.tankbattle.core.fileIO.GameFileIO;
import com.tankteam.tankbattle.core.graphics.GameFastRenderView;
import com.tankteam.tankbattle.core.graphics.GameGraphics;
import com.tankteam.tankbattle.core.graphics.Graphics;

/**
 * Created by leiyong on 15/10/15.
 */
public abstract class GameActivity extends Activity implements Game {
    private static final int  designResolutionWidth = 640;
    private static final int designResolutionHeight = 960;
    GameFastRenderView renderView;
    Graphics graphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Scene scene;
    //PowerManager.WakeLock wakeLock;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandscape ? designResolutionHeight:designResolutionWidth;
        int frameBufferHeight = isLandscape ? designResolutionWidth:designResolutionHeight;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight, Bitmap.Config.RGB_565);
        float scaleX = (float) frameBufferWidth/getWindowManager().getDefaultDisplay().getWidth();
        float scaleY = (float) frameBufferHeight/getWindowManager().getDefaultDisplay().getHeight();

        renderView = new GameFastRenderView(this, frameBuffer);
        graphics = new GameGraphics(getAssets(), frameBuffer);
        fileIO = new GameFileIO(this);
        audio = new GameAudio(this);
        input = new GameInput(this, renderView, scaleX, scaleY);
        scene = getStartScene();
        setContentView(renderView);

        //PowerManager powerManager = (PowerManager)getSystemService(Context.POWER_SERVICE);
        //wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "GLGAME");
    }

    @Override
    public void onResume() {
        super.onResume();
        //wakeLock.acquire();
        scene.resume();
        renderView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //wakeLock.release();
        renderView.pause();
        scene.pause();

        if (isFinishing())
            scene.dispose();
    }

    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    @Override
    public void setScene(Scene scene) {
        if (scene == null)
            throw new IllegalArgumentException("Scene must not be null");
        this.scene.pause();
        this.scene.dispose();
        scene.resume();
        scene.update(0);
        this.scene = scene;
    }

    @Override
    public Scene getCurrentScene() {
        return scene;
    }
}
