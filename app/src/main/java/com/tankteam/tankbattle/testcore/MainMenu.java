package com.tankteam.tankbattle.testcore;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

import java.util.List;

/**
 * Created by leiyong on 15/10/15.
 */
public class MainMenu extends Scene {
    private boolean isLoading;

    public MainMenu(Game game) {
        super(game, 2, 1);
        isLoading = true;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        //以后使用异步加载,新线程
        Assets.enemyTank_enemy1R = game.getGraphics().newPixmap("image/enemyTank/enemy1R.png", Graphics.PixmapFormat.RGB565);
        isLoading = false;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float deltaTime) {
        InputDeal();
        super.update(deltaTime);
    }

    public void present() {
        Layer backgroundLayer = this.getLayer(0);
        backgroundLayer.drawBackGround(game.getGraphics(), 0xffeeeeee);
        Layer loading = this.getLayer(1);
        String loadingText = "加载中...";
        if (!isLoading)
            loadingText = "加载完毕,按任意键继续...";
        loading.drawText(game.getGraphics(), loadingText, game.getGraphics().getWidth()/2, game.getGraphics().getHeight()/2, 50, 0xffff0000);
        super.present();
    }

    private void InputDeal() {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i=0;i<len;i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                game.setScene(new testScene(game));
            }
        }
    }
}
