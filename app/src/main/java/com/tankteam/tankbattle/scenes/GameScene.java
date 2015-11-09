package com.tankteam.tankbattle.scenes;

import android.graphics.Rect;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.core.graphics.CommonSprite;
import com.tankteam.tankbattle.core.graphics.Sprite;
import com.tankteam.tankbattle.map.MapManage;
import com.tankteam.tankbattle.tank.EnemyManage;
import com.tankteam.tankbattle.tank.EnemyTank;
import com.tankteam.tankbattle.tank.PlayerTank;
import com.tankteam.tankbattle.tank.Tank;

import java.util.List;

/**
 * Created by leiyong on 15/10/26.
 */
public class GameScene extends Scene {
    private static final int MAIN_LAYER = 4;
    private static final int TANK_SPRITE = 10;
    private static final int BULLET_SPRITE = 50;
    private static final int MAP_SPRITE = 480;
    private static final int INPUT_LAYER = 5;

    private static final int PLAYER_SPEED = 50;

    private Layer tankLayer;
    private Layer bulletLayer;
    private Layer mapLayer;
    private Layer inputLayer;

    private PlayerTank playerTank;

    public GameScene(Game game) {
        super(game, MAIN_LAYER, new int[]{TANK_SPRITE, BULLET_SPRITE, MAP_SPRITE, INPUT_LAYER});
        tankLayer = this.getLayer(0);
        bulletLayer = this.getLayer(1);
        mapLayer = this.getLayer(2);
        inputLayer = this.getLayer(3);

    }

    public void update(float deltaTime) {
        inputDeal();
        EnemyTank enemyTank = EnemyManage.getInstance().CreateEnemy(deltaTime);
        if (enemyTank != null)
            tankLayer.add(enemyTank);
        super.update(deltaTime);
    }

    public void present() {
        super.present();
    }

    private void inputDeal() {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i=0;i<len;i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_DOWN) {
                Rect rect = new Rect(100, 540, 160, 640);
                if (game.isInRect(event.x, event.y, rect)) {
                    playerTank.setMoving(true);
                    playerTank.setVelocity(0, PLAYER_SPEED);
                    playerTank.setDirection(Tank.Direction.DOWN);
                    playerTank.setPixmap(Assets.playerTank_p1tankD);
                }
                rect.set(0, 440, 80, 540);
                if (game.isInRect(event.x, event.y, rect)) {
                    playerTank.setMoving(true);
                    playerTank.setVelocity(-PLAYER_SPEED, 0);
                    playerTank.setDirection(Tank.Direction.LEFT);
                    playerTank.setPixmap(Assets.playerTank_p1tankL);
                }
                rect.set(180, 440, 260, 540);
                if (game.isInRect(event.x, event.y, rect)) {
                    playerTank.setMoving(true);
                    playerTank.setVelocity(PLAYER_SPEED, 0);
                    playerTank.setDirection(Tank.Direction.RIGHT);
                    playerTank.setPixmap(Assets.playerTank_p1tankR);
                }
                rect.set(100, 340, 180, 440);
                if (game.isInRect(event.x, event.y, rect)) {
                    playerTank.setMoving(true);
                    playerTank.setVelocity(0, -PLAYER_SPEED);
                    playerTank.setDirection(Tank.Direction.UP);
                    playerTank.setPixmap(Assets.playerTank_p1tankU);
                }
                rect.set(800, 480, 920, 600);
                if (game.isInRect(event.x, event.y, rect)) {
                    playerTank.fire();
                }
            } else if(event.type == Input.TouchEvent.TOUCH_UP) {
                playerTank.setMoving(false);
            }
        }
    }


    @Override
    public void pause() {
    }

    @Override
    public void resume() {
        MapManage.getInstance().InitMap(0, mapLayer);
        playerTank = PlayerTank.getTank();
        playerTank.setBulletLayer(bulletLayer);
        tankLayer.add(playerTank);
        //添加输入按钮
        inputLayer.add(new CommonSprite(Assets.button_direcitonDown, 100, 540));
        inputLayer.add(new CommonSprite(Assets.button_direcitonLeft, 0, 440));
        inputLayer.add(new CommonSprite(Assets.button_direcitonRight, 180, 440));
        inputLayer.add(new CommonSprite(Assets.button_direcitonUp, 100, 340));
        inputLayer.add(new CommonSprite(Assets.button_fireButton, 800, 480));

    }

    @Override
    public void dispose() {

    }
}
