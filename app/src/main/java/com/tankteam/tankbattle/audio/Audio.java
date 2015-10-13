package com.tankteam.tankbattle.audio;

/**
 * Created by dengkai on 15/10/13.
 */
public interface Audio {
    Music newMusic(String filename);
    Sound newSound(String filename);
}
