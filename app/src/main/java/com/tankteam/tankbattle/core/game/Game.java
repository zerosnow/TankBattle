package com.tankteam.tankbattle.core.game;

import android.graphics.Rect;

import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.audio.Audio;
import com.tankteam.tankbattle.core.fileIO.FileIO;
import com.tankteam.tankbattle.core.graphics.Graphics;

/**
 * Created by leiyong on 15/10/14.
 */
public interface Game {
    Input getInput();
    FileIO getFileIO();
    Graphics getGraphics();
    Audio getAudio();
    void setScene(Scene scene);
    Scene getCurrentScene();
    Scene getStartScene();
    void onWin();
    void onFail();
    boolean isInRect(int x, int y, Rect rect);
}
