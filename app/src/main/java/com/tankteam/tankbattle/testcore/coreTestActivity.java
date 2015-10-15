package com.tankteam.tankbattle.testcore;

import android.os.Bundle;

import com.tankteam.tankbattle.R;
import com.tankteam.tankbattle.core.game.GameActivity;
import com.tankteam.tankbattle.core.game.Scene;

public class coreTestActivity extends GameActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_test);
    }

    @Override
    public Scene getStartScene() {
        return new MainMenu(this);
    }
}
