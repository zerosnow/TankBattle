package com.tankteam.tankbattle.core.world;

import com.tankteam.tankbattle.core.graphics.Graphics;

/**
 * Created by leiyong on 15/10/14.
 */

//游戏中的场景类
public abstract class Scene {
    //默认场景层次
    public static final int DEFAULT_LAYER_COUNT = 1;
    //层次中默认的物体数目
    public static final int DEFAULT_LAYER_OBJECT_COUNT = 32;
    //层次数数组
    protected Layer[] layer;

    protected int layerCount;

    //游戏暂停时调用的方法
    public abstract void onPause();

    //游戏恢复时调用的方法
    public abstract void onResume();

    //使用特定物体数量，固定层次创建游戏场景
    public Scene(int layerCount, int[] layerObjectCount) {
        this.layerCount = layerCount;
        layer = new Layer[layerCount];
        for(int i=0;i<layerCount;i++) {
            layer[i] = new Layer(this, layerObjectCount[i]);
        }
    }

    //使用固定的物体数量与固定的层次创建
    public Scene(int layerCount, int layerObjectCount) {
        this.layerCount = layerCount;
        layer = new Layer[layerCount];
        for(int i=0;i<layerCount;i++) {
            layer[i] = new Layer(this, layerObjectCount);
        }
    }

    //使用默认的物体数量，固定的层次创建
    public Scene(int layerCount) {
        this(layerCount, DEFAULT_LAYER_OBJECT_COUNT);
    }

    //使用默认的物体数量和层次创建
    public Scene() {
        this(DEFAULT_LAYER_COUNT, DEFAULT_LAYER_OBJECT_COUNT);
    }

    //获得指定层次
    public Layer getLayer(int index) {
        if (index < 0 || index > layerCount) {
            return null;
        }
        return layer[index];
    }

    //清除场景中每个层次的物体
    public void clear() {
        for (int i=0;i<layerCount;i++) {
            layer[i].clear();
        }
    }

    //清除场景中指定层次的物体
    public void clearLayer(int index) {
        if (index < 0 || index > layerCount) {
            return ;
        }
        layer[index].clear();
    }

    //移动场景层次
    public void moveLayer(int startIndex, int endIndex) {
        if(startIndex == endIndex) {
            return ;
        }
        if(startIndex < 0 || startIndex > layerCount) {
            return ;
        }
        if(endIndex < 0 || endIndex > layerCount) {
            return;
        }
        Layer tempLayer = layer[startIndex];
        if(endIndex < startIndex) {
            for (int i=endIndex;i<startIndex;i++) {
                layer[i+1] = layer[i];
            }
            layer[endIndex] = tempLayer;
        }
        if (endIndex > startIndex) {
            for (int i=startIndex;i<endIndex;i++) {
                layer[i] = layer[i+1];
            }
            layer[endIndex] = tempLayer;
        }
    }

    //交换场景中层次的顺序
    public void switchLayers(int layer1, int layer2) {
        if (layer1 == layer2) {
            return;
        }
        if (layer1 < 0 || layer1 > layerCount) {
            return;
        }
        if (layer2 < 0 || layer2 > layerCount) {
            return;
        }
        Layer tempLayer = layer[layer1];
        layer[layer1] = layer[layer2];
        layer[layer2] = tempLayer;
    }
    //更换指定的层次
    public void setLayer(int index, Layer layer) {
        if (layer == null) {
            return;
        }
        if (index < 0 || index > layerCount) {
            return;
        }
        this.layer[index] = layer;
    }
    //场景初始化
    protected void onSetScene() {

    }

    //场景结束
    protected void OnEndScene() {

    }

    protected void onDraw(Graphics g) {
        for (int i=0;i<layerCount;i++) {
            layer[i].onDraw(g);
        }
    }
























}
