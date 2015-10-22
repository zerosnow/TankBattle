package com.tankteam.tankbattle.testcore;

import android.graphics.Rect;

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
        Assets.music_add = game.getAudio().newSound("music/add.wav");
        Assets.music_blast = game.getAudio().newSound("music/blast.wav");

        //动画加载
        Assets.animation_blast = new Pixmap[8];
        for (int i=1;i<=8;i++)
            Assets.animation_blast[i-1] = game.getGraphics().newPixmap("animation/blast/blast"+i+".png", Graphics.PixmapFormat.RGB565);
        Assets.blast = game.getGraphics().newAnimation(Assets.animation_blast);
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
            loadingText = "加载完毕,按此处继续...";
        loading.drawText(game.getGraphics(), loadingText, game.getGraphics().getWidth()/2, game.getGraphics().getHeight()/2, 50, 0xffff0000);
        super.present();
    }

    private void InputDeal() {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i=0;i<len;i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                Rect rect = new Rect(game.getGraphics().getWidth()/2-200, game.getGraphics().getHeight()/2-50,
                        game.getGraphics().getWidth()/2+200, game.getGraphics().getHeight()/2+50);
                if (game.isInRect(event.x, event.y, rect)) {
                    game.setScene(new testScene(game));
                    Assets.music_add.play(1);
                }
            }
        }
    }
}
