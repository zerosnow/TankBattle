package com.tankteam.tankbattle;

import com.tankteam.tankbattle.core.audio.Sound;
import com.tankteam.tankbattle.core.graphics.Animation;
import com.tankteam.tankbattle.core.graphics.Pixmap;

/**
 * Created by leioooyong on 15/10/22.
 */
public class Assets {
    //背景图
    public static Pixmap background;
    public static Pixmap background1;
    public static Pixmap background2;
    public static Pixmap background_over;
    public static Pixmap background_mainmenu;

    //子弹图
    public static Pixmap bullet_enemymissile;
    public static Pixmap bullet_tankmissile;

    //按钮图
    public static Pixmap button_directionDown;
    public static Pixmap button_directionLeft;
    public static Pixmap button_directionRight;
    public static Pixmap button_directionUp;
    public static Pixmap button_fireButton;

    //敌军坦克图
    //蓝色
    public static Pixmap enemyTank_enemy1D;
    public static Pixmap enemyTank_enemy1L;
    public static Pixmap enemyTank_enemy1R;
    public static Pixmap enemyTank_enemy1U;
    //绿色
    public static Pixmap enemyTank_enemy2D;
    public static Pixmap enemyTank_enemy2L;
    public static Pixmap enemyTank_enemy2R;
    public static Pixmap enemyTank_enemy2U;
    //橙色
    public static Pixmap enemyTank_enemy3D;
    public static Pixmap enemyTank_enemy3L;
    public static Pixmap enemyTank_enemy3R;
    public static Pixmap enemyTank_enemy3U;

    //加强版的敌方坦克（需要中两发子弹才会死亡，并且死亡时会有buff产生）
    //银白色
    public static Pixmap ex_enemyTank_enemy1D;
    public static Pixmap ex_enemyTank_enemy1L;
    public static Pixmap ex_enemyTank_enemy1R;
    public static Pixmap ex_enemyTank_enemy1U;
    //深蓝色
    public static Pixmap ex_enemyTank_enemy2D;
    public static Pixmap ex_enemyTank_enemy2L;
    public static Pixmap ex_enemyTank_enemy2R;
    public static Pixmap ex_enemyTank_enemy2U;
    //粉红色
    public static Pixmap ex_enemyTank_enemy3D;
    public static Pixmap ex_enemyTank_enemy3L;
    public static Pixmap ex_enemyTank_enemy3R;
    public static Pixmap ex_enemyTank_enemy3U;

    //玩家坦克图
    public static Pixmap playerTank_p1tankD;
    public static Pixmap playerTank_p1tankL;
    public static Pixmap playerTank_p1tankR;
    public static Pixmap playerTank_p1tankU;

    //地图
    public static Pixmap tileMap_grass;
    public static Pixmap tileMap_steel;
    public static Pixmap tileMap_symbol;
    public static Pixmap tileMap_wall;
    public static Pixmap tileMap_water;

    //宝物图
    public static Pixmap treasure_bomb;
    public static Pixmap treasure_destory;
    public static Pixmap treasure_mintank;
    public static Pixmap treasure_star;
    public static Pixmap treasure_timer;

    //声音
    public static Sound music_add;
    public static Sound music_blast;
    public static Sound music_fire;
    public static Sound music_hit;
    public static Sound music_start;


    //动画
    public static Pixmap[] animation_blast;
    public static Animation blast;

    public static Pixmap[] animation_born;
    public static Animation born;

}
