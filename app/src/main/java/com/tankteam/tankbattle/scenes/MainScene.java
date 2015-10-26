package com.tankteam.tankbattle.scenes;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;

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
        //敌方坦克加载
        Assets.enemyTank_enemy1R = game.getGraphics().newPixmap("image/enemyTank/enemy1R.png", Graphics.PixmapFormat.RGB565);
        Assets.enemyTank_enemy1L = game.getGraphics().newPixmap("image/enemyTank/enemy1L.png", Graphics.PixmapFormat.RGB565);
        Assets.enemyTank_enemy1U = game.getGraphics().newPixmap("image/enemyTank/enemy1U.png", Graphics.PixmapFormat.RGB565);
        Assets.enemyTank_enemy1D = game.getGraphics().newPixmap("image/enemyTank/enemy1D.png", Graphics.PixmapFormat.RGB565);

        Assets.enemyTank_enemy2R = game.getGraphics().newPixmap("image/enemyTank/enemy2R.png", Graphics.PixmapFormat.RGB565);
        Assets.enemyTank_enemy2L = game.getGraphics().newPixmap("image/enemyTank/enemy2L.png", Graphics.PixmapFormat.RGB565);
        Assets.enemyTank_enemy2U = game.getGraphics().newPixmap("image/enemyTank/enemy2U.png", Graphics.PixmapFormat.RGB565);
        Assets.enemyTank_enemy2D = game.getGraphics().newPixmap("image/enemyTank/enemy2D.png", Graphics.PixmapFormat.RGB565);

        Assets.enemyTank_enemy3R = game.getGraphics().newPixmap("image/enemyTank/enemy3R.png", Graphics.PixmapFormat.RGB565);
        Assets.enemyTank_enemy3L = game.getGraphics().newPixmap("image/enemyTank/enemy3L.png", Graphics.PixmapFormat.RGB565);
        Assets.enemyTank_enemy3U = game.getGraphics().newPixmap("image/enemyTank/enemy3U.png", Graphics.PixmapFormat.RGB565);
        Assets.enemyTank_enemy3D = game.getGraphics().newPixmap("image/enemyTank/enemy3D.png", Graphics.PixmapFormat.RGB565);

        //加强版坦克加载
        Assets.ex_enemyTank_enemy1R = game.getGraphics().newPixmap("image/enemyTank/exenemy1R.png", Graphics.PixmapFormat.RGB565);
        Assets.ex_enemyTank_enemy1L = game.getGraphics().newPixmap("image/enemyTank/exenemy1L.png", Graphics.PixmapFormat.RGB565);
        Assets.ex_enemyTank_enemy1U = game.getGraphics().newPixmap("image/enemyTank/exenemy1U.png", Graphics.PixmapFormat.RGB565);
        Assets.ex_enemyTank_enemy1D = game.getGraphics().newPixmap("image/enemyTank/exenemy1D.png", Graphics.PixmapFormat.RGB565);

        Assets.ex_enemyTank_enemy2R = game.getGraphics().newPixmap("image/enemyTank/exenemy2R.png", Graphics.PixmapFormat.RGB565);
        Assets.ex_enemyTank_enemy2L = game.getGraphics().newPixmap("image/enemyTank/exenemy2L.png", Graphics.PixmapFormat.RGB565);
        Assets.ex_enemyTank_enemy2U = game.getGraphics().newPixmap("image/enemyTank/exenemy2U.png", Graphics.PixmapFormat.RGB565);
        Assets.ex_enemyTank_enemy2D = game.getGraphics().newPixmap("image/enemyTank/exenemy2D.png", Graphics.PixmapFormat.RGB565);

        Assets.ex_enemyTank_enemy3R = game.getGraphics().newPixmap("image/enemyTank/exenemy3R.png", Graphics.PixmapFormat.RGB565);
        Assets.ex_enemyTank_enemy3L = game.getGraphics().newPixmap("image/enemyTank/exenemy3L.png", Graphics.PixmapFormat.RGB565);
        Assets.ex_enemyTank_enemy3U = game.getGraphics().newPixmap("image/enemyTank/exenemy3U.png", Graphics.PixmapFormat.RGB565);
        Assets.ex_enemyTank_enemy3D = game.getGraphics().newPixmap("image/enemyTank/exenemy3D.png", Graphics.PixmapFormat.RGB565);

        //声音加载
        Assets.music_add = game.getAudio().newSound("music/add.wav");
        Assets.music_blast = game.getAudio().newSound("music/blast.wav");

        //动画加载
        Assets.animation_blast = new Pixmap[8];
        for (int i=1;i<=8;i++)
            Assets.animation_blast[i-1] = game.getGraphics().newPixmap("animation/blast/blast"+i+".png", Graphics.PixmapFormat.RGB565);
        Assets.blast = game.getGraphics().newAnimation(Assets.animation_blast);
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

    public void present() {
        super.present();
    }

    public void update(float deltaTime) {
        inputDeal();
        super.update(deltaTime);
    }

    private void inputDeal() {

    }

}
