package com.tankteam.tankbattle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //初始化关卡地图，己方坦克等
        this.initMap();
        this.initPlayer();

        //进入游戏循环
        this.gameRun();

    }

    private void initMap() {
    }

    private void initPlayer() {
    }

    private void gameRun() {
        while(true) {
            //游戏逻辑处理
            if (false == this.logicDealing())
                return;

            //游戏界面绘制
            this.drawScene();
        }
    }

    private boolean logicDealing() {
        //敌军坦克管理类制造坦克

        //敌军坦克更新位置

        //敌军判断是否开火

        //己方坦克根据当前状态运动

        //己方坦克根据当前状态开火

        //子弹运动

        //if(子弹碰撞检测==true)
        //    处理碰撞检测结果

        //如果死亡重新开始本关，如果获胜且存在下一关则进入下一关。
        return false;
    }

    private void drawScene() {
        //绘制地图

        //绘制坦克

        //绘制子弹

        //绘制子弹碰撞结果

    }

}
