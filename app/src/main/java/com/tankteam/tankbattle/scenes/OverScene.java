package com.tankteam.tankbattle.scenes;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Sprite;

import java.util.List;

/**
 * Created by leiyong on 15/11/30.
 */
public class OverScene extends Scene {

    public OverScene(Game game, boolean isWin) {
        super(game, 1, 1);
        if (isWin)
            getLayer(0).add(new WinSprite());
        else
            getLayer(0).add(new LoseSprite());
    }

    @Override
    public void update(float deltaTime) {
        inputDeal();
        super.update(deltaTime);
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

    private void inputDeal() {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i=0;i<len;i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                game.setScene(new MainScene(game));
                System.out.println("11111111");
            }
        }
    }

    class WinSprite extends Sprite {

        @Override
        public void draw(Graphics g) {
            g.drawPixmap(Assets.background_win, 360, 260);
        }

        @Override
        public void update(float deltaTime) {

        }

        @Override
        public boolean collision(Sprite sprite) {
            return false;
        }
    }
    class LoseSprite extends Sprite {

        @Override
        public void draw(Graphics g) {
            g.drawPixmap(Assets.background_over, 360, 260);
        }

        @Override
        public void update(float deltaTime) {

        }

        @Override
        public boolean collision(Sprite sprite) {
            return false;
        }
    }

}

