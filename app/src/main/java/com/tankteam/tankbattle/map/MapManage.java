package com.tankteam.tankbattle.map;

import com.tankteam.tankbattle.Manage;
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

    //最大同时存在地图块数
    private static final int MAX_EXIST_MAP = 100;
    ArrayList<Map> mapList;

    //添加其他属性

    private MapManage() {
        super();
        mapList = new ArrayList<Map>(MAX_EXIST_MAP);
    }

    //创建地图块
    public Map CreateMap(Pixmap pixmap, Map.MapType mapType) {
        Map map = new Map(pixmap, mapType);
        mapList.add(map);
        return map;
    }

    //添加更多方法

}
