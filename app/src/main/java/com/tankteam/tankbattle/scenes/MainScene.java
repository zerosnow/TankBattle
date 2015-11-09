package com.tankteam.tankbattle.scenes;

import android.graphics.Rect;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.core.Input.Input;
import com.tankteam.tankbattle.core.game.Game;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.core.graphics.CommonSprite;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;

import java.util.List;

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
        //背景图加载
        Assets.background = game.getGraphics().newPixmap("image/background/background.png", Graphics.PixmapFormat.RGB565);
        Assets.background_over = game.getGraphics().newPixmap("image/background/over.png", Graphics.PixmapFormat.RGB565);
        Assets.background_mainmenu = game.getGraphics().newPixmap("image/background/mainmenu.png", Graphics.PixmapFormat.RGB565);


        //子弹加载
        Assets.bullet_enemymissile = game.getGraphics().newPixmap("image/bullet/enemymissile.png", Graphics.PixmapFormat.RGB565);
        Assets.bullet_tankmissile = game.getGraphics().newPixmap("image/bullet/tankmissile.png", Graphics.PixmapFormat.RGB565);

        //按钮加载
        Assets.button_direcitonDown = game.getGraphics().newPixmap("image/button/direction_down.png", Graphics.PixmapFormat.RGB565);
        Assets.button_direcitonLeft = game.getGraphics().newPixmap("image/button/direction_left.png", Graphics.PixmapFormat.RGB565);
        Assets.button_direcitonRight = game.getGraphics().newPixmap("image/button/direction_right.png", Graphics.PixmapFormat.RGB565);
        Assets.button_direcitonUp = game.getGraphics().newPixmap("image/button/direction_up.png", Graphics.PixmapFormat.RGB565);
        Assets.button_fireButton = game.getGraphics().newPixmap("image/button/fire_button.png", Graphics.PixmapFormat.RGB565);


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

        //玩家坦克图加载
        Assets.playerTank_p1tankR = game.getGraphics().newPixmap("image/playerTank/p1tankR.png", Graphics.PixmapFormat.RGB565);
        Assets.playerTank_p1tankL = game.getGraphics().newPixmap("image/playerTank/p1tankL.png", Graphics.PixmapFormat.RGB565);
        Assets.playerTank_p1tankU = game.getGraphics().newPixmap("image/playerTank/p1tankU.png", Graphics.PixmapFormat.RGB565);
        Assets.playerTank_p1tankD = game.getGraphics().newPixmap("image/playerTank/p1tankD.png", Graphics.PixmapFormat.RGB565);

        //地图块加载
        Assets.tileMap_grass = game.getGraphics().newPixmap("image/tileMap/grass.png", Graphics.PixmapFormat.RGB565);
        Assets.tileMap_steel = game.getGraphics().newPixmap("image/tileMap/steel.png", Graphics.PixmapFormat.RGB565);
        Assets.tileMap_symbol = game.getGraphics().newPixmap("image/tileMap/symbol.png", Graphics.PixmapFormat.RGB565);
        Assets.tileMap_wall = game.getGraphics().newPixmap("image/tileMap/wall.png", Graphics.PixmapFormat.RGB565);
        Assets.tileMap_water = game.getGraphics().newPixmap("image/tileMap/water.png", Graphics.PixmapFormat.RGB565);

        //宝物图加载
        Assets.treasure_bomb = game.getGraphics().newPixmap("image/treasure/bomb.png", Graphics.PixmapFormat.RGB565);
        Assets.treasure_destory = game.getGraphics().newPixmap("image/treasure/destory.png", Graphics.PixmapFormat.RGB565);
        Assets.treasure_mintank = game.getGraphics().newPixmap("image/treasure/mintank.png", Graphics.PixmapFormat.RGB565);
        Assets.treasure_star = game.getGraphics().newPixmap("image/treasure/star.png", Graphics.PixmapFormat.RGB565);
        Assets.treasure_timer = game.getGraphics().newPixmap("image/treasure/timer.png", Graphics.PixmapFormat.RGB565);


        //声音加载
        Assets.music_add = game.getAudio().newSound("music/add.wav");
        Assets.music_blast = game.getAudio().newSound("music/blast.wav");
        Assets.music_fire = game.getAudio().newSound("music/fire.wav");
        Assets.music_hit = game.getAudio().newSound("music/hit.wav");
        Assets.music_start = game.getAudio().newSound("music/start.wav");


        //动画加载
        Assets.animation_blast = new Pixmap[8];
        for (int i=1;i<=8;i++)
            Assets.animation_blast[i-1] = game.getGraphics().newPixmap("animation/blast/blast"+i+".png", Graphics.PixmapFormat.RGB565);
        Assets.blast = game.getGraphics().newAnimation(Assets.animation_blast);
        Assets.animation_born = new Pixmap[4];
        for (int i=1;i<=4;i++)
            Assets.animation_born[i-1] = game.getGraphics().newPixmap("animation/born/born"+i+".png", Graphics.PixmapFormat.RGB565);
        Assets.born = game.getGraphics().newAnimation(Assets.animation_born);


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        loadRes();
        backgroundLayer.add(new CommonSprite(Assets.background, 0, 0));
        mainMenuLayer.add(new CommonSprite(Assets.background_mainmenu, 320, 200));
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
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i=0;i<len;i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                Rect rect = new Rect(320, 200, 639, 439);
                if (game.isInRect(event.x, event.y, rect)) {
                    switch ((event.y - 200) / 80) {
                        case 0:
                            game.setScene(new GameScene(game));
                            Assets.music_start.play(1);
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

}
