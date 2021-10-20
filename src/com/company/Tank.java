package com.company;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x, y;
    private Dir dir;
    private Image image = ResourceManage.tankD;
    private Color color;
    private Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private Random random = new Random();
    private final int SPEED = 5;
    private boolean isMove = true;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    private boolean live = true;
    private TankFrame tf;


    public Tank(int x, int y, Color color, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.dir = dir;
        this.tf = tf;
    }

    public Tank(int x, int y, Color color, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.enemyTankList.remove(this);
        }
        paint(g, x, y);
        move();
    }

    public void paint(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }

    private void move() {
        if (!isMove) return;
        switch (dir) {
            case UP:
                image = ResourceManage.tankU;
                if(!(y <= 25))
                y -= SPEED;
                break;
            case DOWN:
                image = ResourceManage.tankD;
                if(!(y>=tf.getHeight() - 50))
                y += SPEED;
                break;
            case LEFT:
                image = ResourceManage.tankL;
                if(!(x<=0))
                x -= SPEED;
                break;
            case RIGHT:
                image = ResourceManage.tankR;
                if(!(x >= tf.getWidth() - 50))
                    x += SPEED;
                break;
        }
        if (random.nextInt(100) > 90 && Group.BAD == this.group) {
            fire();
        }
        if(Group.BAD == this.group) {
            randomDir();
        }
    }

    private void randomDir(){
        if(random.nextInt(100) > 85) {
            this.dir = Dir.values()[random.nextInt(4)];
        }
    }
    public void fire() {
        tf.bulletList.add(new Bullet((this.x + 20), (this.y + 20), this.dir, this.group, tf));
    }

    public boolean getIsMove() {
        return isMove;
    }

    public void setIsMove(boolean move) {
        isMove = move;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


}
