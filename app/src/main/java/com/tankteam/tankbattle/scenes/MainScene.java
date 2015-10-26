package com.tankteam.tankbattle.scenes;

import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.game.Scene;

/**
 * Created by leiyong on 15/10/26.
 */
public class MainScene extends Scene {
    private static final int MAIN_LAYER = 2;
    private static final int MAIN_SPRITE = 1;

    private Layer backgroundLayer;
    private Layer mainMenuLayer;

    public MainScene(Game game) {
        super(game, MAIN_LAYER, MAIN_SPRITE);
        backgroundLayer = this.getLayer(0);
        mainMenuLayer = this.getLayer(1);
    }

    //加载图片,声音等
    private void loadRes() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        loadRes();
        
    }

    @Override
    public void dispose() {

    }



}
