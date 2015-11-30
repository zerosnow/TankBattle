package com.tankteam.tankbattle.core.audio;

/**
 * Created by leiyong on 15/10/13.
 */
public interface Audio {
    Music newMusic(String filename);
    Sound newSound(String filename);
}