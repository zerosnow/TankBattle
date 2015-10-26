package com.tankteam.tankbattle;

import android.os.Bundle;

import com.tankteam.tankbattle.core.game.GameActivity;
import com.tankteam.tankbattle.core.game.Scene;
import com.tankteam.tankbattle.scenes.MainScene;

/**
 * Created by leiyong on 15/10/26.
 */
public class TankBattle extends GameActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setScene(getStartScene());
    }

    @Override
    public Scene getStartScene() {
        return new MainScene(this);
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
