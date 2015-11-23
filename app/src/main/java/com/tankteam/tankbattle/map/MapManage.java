package com.tankteam.tankbattle.map;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.Manage;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.graphics.CommonSprite;
import com.tankteam.tankbattle.core.graphics.Pixmap;

import java.util.ArrayList;

/**
 * Created by leiyong on 15/10/13.
 */
public class MapManage extends Manage {
    private static MapManage mapManage = null;
    public static MapManage getInstance() {
        if (mapManage == null) {
            mapManage = new MapManage();
        }
        return mapManage;
    }

    public void clearMap() {
        mapManage = null;
    }
    //当前关卡信息
    private short[][] level;

    //最大同时存在地图块数
    private static final int MAX_EXIST_MAP = 100;

    private ArrayList<Map> mapList;

    //添加其他属性

    private MapManage() {
        super();
        mapList = new ArrayList<Map>(MAX_EXIST_MAP);
    }

    public ArrayList<Map> getMapList() {
        return mapList;
    }

    public void InitMap(int id, Layer maplayer) {
        int width = MapData.getInstance().getScreenWidth();
        int height = MapData.getInstance().getScreenHeight();
        level = MapData.getInstance().getLevelById(id);

        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                if (level[i][j] != 0) {
                    maplayer.add(CreateMap(level[i][j], j, i));
                }
            }
        }
        maplayer.add(new CommonSprite(Assets.background1, 0, 0));
        maplayer.add(new CommonSprite(Assets.background2, 840, 0));
    }



    //创建地图块
    public Map CreateMap(short mapType, int x, int y) {
        Map map = new Map(mapType, x, y, mapList);
        mapList.add(map);
        return map;
    }

    //添加更多方法

}
