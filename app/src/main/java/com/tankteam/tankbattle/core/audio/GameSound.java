package com.tankteam.tankbattle.core.audio;

import android.media.SoundPool;

/**
 * Created by leiyong on 15/10/14.
 */
public class GameSound implements Sound{
    int SoundId;
    SoundPool soundPool;    //Android API中处理音效的类

    public GameSound(SoundPool soundPool, int soundId) {
        this.SoundId = soundId;
        this.soundPool = soundPool;
    }

    @Override
    public void play(float volume) {
        soundPool.play(SoundId, volume, volume, 0, 0, 1);
    }

    @Override
    public void dispose() {
        soundPool.unload(SoundId);
    }
}
