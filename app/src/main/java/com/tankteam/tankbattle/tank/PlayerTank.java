package com.tankteam.tankbattle.tank;

import com.tankteam.tankbattle.Assets;
import com.tankteam.tankbattle.TankBattle;
import com.tankteam.tankbattle.bullet.Bullet;
import com.tankteam.tankbattle.bullet.BulletManage;
import com.tankteam.tankbattle.core.game.Layer;
import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;
import com.tankteam.tankbattle.map.Map;
import com.tankteam.tankbattle.map.MapManage;

import java.util.ArrayList;

import static com.tankteam.tankbattle.tank.Tank.Direction.*;

/**
 * Created by leiyong on 15/10/13.
 */
public class PlayerTank extends Tank{
    enum State {//正常,无敌,
        NORMAL, INVINCIBILITY,
    }

    private int rank;
    private State state;
    private boolean isMoving = false;
    private Layer tankLayer=null;


    private static PlayerTank playerTank=null;
    public static PlayerTank getTank() {
        if (playerTank == null)
            playerTank = new PlayerTank(Assets.playerTank_p1tankU);
        return playerTank;
    }

    public void clearTank() {
        playerTank = null;
    }


    private PlayerTank(Pixmap pixmap) {
        super();
        super.setPixmap(pixmap);
        x = 360;
        y = 580;
        this.width = this.height = 60;
        rank = 1;
        state = State.NORMAL;
        blood = 1;
        power = 1;
        direction = UP;
        fireCoolingTime = 1;
        bulletType = Bullet.BulletType.HERO_NORMAL;
    }

    @Override
    public void fire() {
        if (currentFireCooling <= 0) {
            Bullet bullet = BulletManage.getInstance().CreateBullet(Bullet.BulletType.HERO_NORMAL, this);
            bulletLayer.add(bullet);
            Assets.music_fire.play(1);
            currentFireCooling = fireCoolingTime;
        }
    }

    public void kill() {
        super.kill();
        if (blood >= 1) {
            blood--;
            playerTank = new PlayerTank(Assets.playerTank_p1tankU);
            tankLayer.add(playerTank);
        }
        else
            TankBattle.getInstance().onFail();

    }

    public void setTankLayer(Layer tankLayer) {
        this.tankLayer = tankLayer;
    }

    @Override
    public void draw(Graphics g) {
        g.drawPixmap(pixmap, x, y);
    }

    @Override
    public void update(float deltaTime) {
        if (currentFireCooling > 0)
            currentFireCooling -= deltaTime;
        if (isMoving == true) {
            x += vx * deltaTime;
            y += vy * deltaTime;
            //System.out.println(x + " " + y + " " + vx + " " + vy + " " + deltaTime);
        }
        if (!canMove()) {
            x -= vx * deltaTime;
            y -= vy * deltaTime;
        }
    }

    private boolean canMove() {
        if (x < 120 || x + width > 840 || y < 0 || y + height > 640)
            return false;
        if (collision(EnemyManage.getInstance()))
            return false;
        if (collision(MapManage.getInstance()))
            return false;
        return true;
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void setBulletLayer(Layer bulletLayer) {
        this.bulletLayer = bulletLayer;
    }

    @Override
    public boolean collision(Sprite sprite) {
        if (x < sprite.x + sprite.width - 2 && x + width > sprite.x + 2
                && y < sprite.y + sprite.height - 2 && y + height > sprite.y + 2)
            return true;
        return false;
    }

    public boolean collision(EnemyManage enemyManage) {
        for (int i=0;i<enemyManage.getEnemyTankList().size();i++)
            if (collision(enemyManage.getEnemyTankList().get(i))) {
                return true;
            }
        return false;
    }

    public boolean collision(MapManage mapManage) {
        ArrayList<Map> mapList = mapManage.getMapList();
        for (int i=0;i<mapList.size();i++)
            if (mapList.get(i).canTankCollition && collision(mapList.get(i))) return true;
        return false;
    }
}
