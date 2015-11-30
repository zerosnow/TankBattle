package com.tankteam.tankbattle;

import android.os.Bundle;

import com.tankteam.tankbattle.bullet.BulletManage;
import com.tankteam.tankbattle.core.game.GameActivity;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.map.Map;
import com.tankteam.tankbattle.map.MapManage;
import com.tankteam.tankbattle.scenes.MainScene;
import com.tankteam.tankbattle.scenes.OverScene;
import com.tankteam.tankbattle.tank.EnemyManage;
import com.tankteam.tankbattle.tank.PlayerTank;

/**
 * Created by leiyong on 15/10/26.
 */
public class TankBattle extends GameActivity {

    private static TankBattle tankBattle = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tankBattle = this;
        this.setScene(getStartScene());
    }

    public static TankBattle getInstance() {
        return tankBattle;
    }

    @Override
    public Scene getStartScene() {
        return new MainScene(this);
    }

    public void onWin() {
        //胜利处理
        PlayerTank.getTank().clearTank();
        EnemyManage.getInstance().clearEnemy();
        MapManage.getInstance().clearMap();
        BulletManage.getInstance().clearBullet();
        this.setScene(new OverScene(this, true));
    }

    public  void onFail() {
        //失败处理
        PlayerTank.getTank().clearTank();
        EnemyManage.getInstance().clearEnemy();
        MapManage.getInstance().clearMap();
        BulletManage.getInstance().clearBullet();
        this.setScene(new OverScene(this, false));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
