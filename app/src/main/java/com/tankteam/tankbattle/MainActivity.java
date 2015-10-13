package com.tankteam.tankbattle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绘制背景与主菜单并对主菜单的操作进行处理
        this.initBackGround();
        this.initMainMenu();

        //播放音乐


        //加载图片纹理，声音等
        this.loadRes();
    }

    private void loadRes() {
    }

    private void initMainMenu() {
    }

    private void initBackGround() {

    }

    //进入选择关卡界面
    private void enterLevelSelect() {
    }
}
