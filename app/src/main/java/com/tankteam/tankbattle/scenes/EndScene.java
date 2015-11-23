package com.tankteam.tankbattle.scenes;

import android.graphics.Rect;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.core.graphics.CommonSprite;
import com.tankteam.tankbattle.core.graphics.Pixmap;

import java.util.List;

/**
 * Created by leiyong on 15/11/23.
 */
public class EndScene extends Scene {

    Pixmap pixmap = null;

    public EndScene(Game game, Pixmap pixmap) {
        super(game, 1, 1);
        this.getLayer(0).add(new CommonSprite(pixmap, 0, 0));
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}

    private void inputDeal() {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i=0;i<len;i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                game.setScene(new MainScene(game));
            }
        }
    }
}
