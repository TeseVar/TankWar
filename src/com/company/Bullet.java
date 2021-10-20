package com.company;

import java.awt.*;

public class Bullet {
    private int x , y;
    private Dir dir ;
    private boolean live = true;
    private final int SPEED = 10;
    private final int WIDTH = 8,HEIGHT = 8;
    TankFrame tf ;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g) {
        if(!live){
            tf.bulletList.remove(this);
        }
        switch (dir){
            case UP:
                g.drawImage(ResourceManage.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceManage.bulletD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceManage.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceManage.bulletR,x,y,null);
                break;
        }

        move();
    }
    private void move() {
        switch (dir){
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }
        if(x<0 || y<0 || x>800 || y>600){
            live = false;
        }
        for(int i = 0; i < tf.enemyTankList.size(); i++){
            Tank t = tf.enemyTankList.get(i);
            if( x - t.getX() < 50 && y-t.getY() < 50 && x - t.getX() > 0 && y-t.getY() > 0){
                t.setLive(false);
                live = false;
            }
        }

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
