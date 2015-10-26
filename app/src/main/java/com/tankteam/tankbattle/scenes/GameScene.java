package com.tankteam.tankbattle.scenes;

import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.game.Scene;

/**
 * Created by leiyong on 15/10/26.
 */
public class GameScene extends Scene {
    private static final int MAIN_LAYER = 4;
    private static final int MAIN_SPRITE = 32;

    private Layer mapLayer;
    private Layer tankLayer;
    private Layer bulletLayer;
    private Layer grassLayer;

    public GameScene(Game game) {
        super(game, MAIN_LAYER, MAIN_SPRITE);
        mapLayer = this.getLayer(0);
        tankLayer = this.getLayer(1);
        bulletLayer = this.getLayer(2);
        grassLayer = this.getLayer(3);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
