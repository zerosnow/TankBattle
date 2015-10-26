package com.tankteam.tankbattle.map;

import java.util.ArrayList;

/**
 * Created by leiyong on 15/10/26.
 */
public class MapData {
    private static final int SCREEN_WIDTH = 24;
    private static final int SCREEN_HEIGHT = 20;

    private static final int LEVEL = 5;

    private static MapData mapData = null;
    public static MapData getInstance() {
        if (mapData == null)
            mapData = new MapData();
        return mapData;
    }
    ArrayList<char[][]> mapDatas;
    char[][] level1;
    char[][] level2;

    private MapData() {
        mapDatas = new ArrayList<char[][]>();
        //关卡1
        level1 = new char[][]{
                {},
                {},
        };
        mapDatas.add(level1);
        //关卡2
        level2 = new char[][]{
                {},
                {},
                {},
        };
        mapDatas.add(level1);
    }

    public int getLevelSize() {
        return mapDatas.size();
    }

    public char[][] getLevelById(int id) {
        return mapDatas.get(id);
    }




}
