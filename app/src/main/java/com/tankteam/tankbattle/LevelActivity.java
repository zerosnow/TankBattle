package com.tankteam.tankbattle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //绘制背景与关卡列表
        this.initBackGround();
        this.drawLevelList();

        //播放音乐
    }

    private void drawLevelList() {
    }

    private void initBackGround() {
    }

}
