package com.tankteam.tankbattle.testcore;

import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Scene;

import java.util.List;

/**
 * Created by leiyong on 15/10/22.
 */
public class testScene extends Scene {

    public testScene(Game game) {
        super(game);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        Tanktest tanktest = new Tanktest();
        this.getLayer(0).add(tanktest);
    }

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
                game.setScene(game.getStartScene());
            }
        }
    }

    @Override
    public void dispose() {

    }
}
