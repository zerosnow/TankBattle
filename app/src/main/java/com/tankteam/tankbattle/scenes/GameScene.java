package com.tankteam.tankbattle.scenes;

import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.map.MapManage;

/**
 * Created by leiyong on 15/10/26.
 */
public class GameScene extends Scene {
    private static final int MAIN_LAYER = 3;
    private static final int TANK_SPRITE = 10;
    private static final int BULLET_SPRITE = 50;
    private static final int MAP_SPRITE = 480;

    private Layer tankLayer;
    private Layer bulletLayer;
    private Layer mapLayer;

    public GameScene(Game game) {
        super(game, MAIN_LAYER, new int[]{TANK_SPRITE, BULLET_SPRITE, MAP_SPRITE});
        tankLayer = this.getLayer(0);
        bulletLayer = this.getLayer(1);
        mapLayer = this.getLayer(2);
    }

    public void update(float deltaTime) {
        inputDeal();
        super.update(deltaTime);
    }

    public void present() {
        super.present();
    }

    private void inputDeal() {

    }


    @Override
    public void pause() {
    }

    @Override
    public void resume() {
        MapManage.getInstance().InitMap(0, mapLayer);
    }

    private void initMap() {

    }

    @Override
    public void dispose() {

    }
}
