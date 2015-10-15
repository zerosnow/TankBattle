package com.tankteam.tankbattle.testcore;

import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

import java.util.List;

/**
 * Created by leiyong on 15/10/15.
 */
public class MainMenu extends Scene {
    Pixmap pixmap;
    int x;

    public MainMenu(Game game) {
        super(game);
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

    @Override
    public void update(float deltaTime) {
        InputDeal();
        super.update(deltaTime);
    }

    private void InputDeal() {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i=0;i<len;i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                game.setScene(this);
            }
        }
    }
}
