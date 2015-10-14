package com.tankteam.tankbattle.audio;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;

/**
 * Created by leiyong on 15/10/14.
 */
public class GameAudio implements Audio{
    AssetManager assets;
    SoundPool soundPool;

    public GameAudio(Activity activity) {
        //设置音量调节方式
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    @Override
    public Music newMusic(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            return new GameMusic(assetDescriptor);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load music '"+filename+"'");
        }
    }

    @Override
    public Sound newSound(String filename) {
        try {
            AssetFileDescriptor assetFileDescriptor = assets.openFd(filename);
            int soundId = soundPool.load(assetFileDescriptor, 0);
            return new GameSound(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load sound '"+filename+"'");
        }
    }
}
