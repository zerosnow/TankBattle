package com.tankteam.tankbattle.testcore;

import android.os.Bundle;

import com.tankteam.tankbattle.R;
import com.tankteam.tankbattle.core.game.GameActivity;
import com.tankteam.tankbattle.core.game.Scene;

public class coreTestActivity extends GameActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setScene(getStartScene());
    }

    @Override
    public Scene getStartScene() {
        return new MainMenu(this);
    }

    @Override
    public void onWin() {

    }

    @Override
    public void onFail() {

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
