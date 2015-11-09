package com.tankteam.tankbattle;

import android.os.Bundle;

import com.tankteam.tankbattle.core.game.GameActivity;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.scenes.MainScene;

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
        this.setScene(getStartScene());
    }

    public  void onFail() {
        //失败处理
        this.setScene(getStartScene());
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
