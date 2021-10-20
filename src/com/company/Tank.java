package com.company;

import java.awt.*;

public class Tank {
    private int x , y;
    private Dir dir ;
    private Image image = ResourceManage.tankD;
    private Color color ;
    private final int SPEED = 5;
    private boolean isMove = false;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    private boolean live = true;
    private TankFrame tf;


    public Tank(int x, int y,Color color, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if(!live){
            tf.enemyTankList.remove(this);
        }
        paint(g,x,y);
        move();
    }

    public void paint(Graphics g,int x, int y) {
//        Color c = g.getColor();
//        g.setColor(color);
//        g.fillRect(x,y,50,50);
//        g.setColor(c);
        g.drawImage(image,x,y,null);
    }

    private void move() {
        if(!isMove) return;
        switch (dir){
            case UP:
                image = ResourceManage.tankU;
                y -= SPEED;
                break;
            case DOWN:
                image = ResourceManage.tankD;
                y += SPEED;
                break;
            case LEFT:
                image = ResourceManage.tankL;
                x -= SPEED;
                break;
            case RIGHT:
                image = ResourceManage.tankR;
                x += SPEED;
                break;
        }
    }
    public void fire() {
        tf.bulletList.add(new Bullet((this.x + 22),(this.y + 22),this.dir,tf));
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
