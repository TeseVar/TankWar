package com.company;

import java.awt.*;

public class Boom {
    private int x , y;
    private final int WIDTH = 8,HEIGHT = 8;
    TankFrame tf ;
    private int step = 0;

    public Boom(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }
    public void paint(Graphics g) {
       g.drawImage(ResourceManage.e.get(step++),x,y,null);

       if(step == ResourceManage.e.size() - 1){
           tf.boomList.remove(this);
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
}
