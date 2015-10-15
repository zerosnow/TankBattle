package com.tankteam.tankbattle.core.audio;

/**
 * Created by dengkai on 15/10/13.
 */
public interface Music {
    void play();
    void stop();
    void pause();
    void setLooping(boolean looping);
    void setVolume(float volume);
    boolean isPlaying();
    boolean isStopped();
    boolean isLooping();
    void dispose();
}
