package com.tankteam.tankbattle.tank;

import com.tankteam.tankbattle.core.graphics.Graphics;
import com.tankteam.tankbattle.core.graphics.Pixmap;
import com.tankteam.tankbattle.core.graphics.Sprite;

/**
 * Created by leiyong on 15/10/13.
 */
public class EnemyTank extends Tank {
    enum EnemyType {
        NORMAL, SENIOR, STRONG,
    }
    private EnemyType type;

    protected EnemyTank(EnemyType type) {
        super();
        this.type = type;
        direction = Direction.DOWN;
        //根据type来设置属性
        switch (type) {
            //位置,贴图,血量,攻击力,状态,开火冷却等
            case NORMAL:

                break;
            case SENIOR:
                break;
            case STRONG:
                break;
            default:
                break;
        }

    }

    @Override
    public void fire() {

    }

    @Override
    public void kill() {
        super.kill();
    }

    @Override
    public void draw(Graphics g) {
        g.drawPixmap(pixmap, x, y);
    }

    @Override
    public void update(float deltaTime) {
        //根据行动策略update
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean collision(Sprite sprite) {
        return false;
    }
}
