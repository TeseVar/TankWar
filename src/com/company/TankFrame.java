package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    private final int GAME_WIDTH = 800,GAME_HEIGHT = 600;

    Tank myTank = new Tank(200,200,Color.BLUE,Dir.DOWN,Group.GOOD,this);
    List<Bullet> bulletList = new ArrayList<>();
    List<Tank> enemyTankList = new ArrayList<>();
    List<Boom> boomList = new ArrayList<>();
    public TankFrame(){
        for(int i = 0; i < 5; i++){
            enemyTankList.add(new Tank (700,500 - i * 70,Color.YELLOW,Dir.RIGHT,this));
        }
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setTitle("坦克大战");
        setResizable(false);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        addKeyListener(new MyKeyListener());
        setVisible(true);
    }
    Dir dir = Dir.DOWN;


    Image offScreenImage = null;

    /**
     * 解决了屏幕上坦克闪烁的问题
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
    @Override
    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:"+bulletList.size(),10,60);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0;i < bulletList.size();i++) {
            bulletList.get(i).paint(g);
        }
        for (int i = 0;i < enemyTankList.size();i++) {
            enemyTankList.get(i).paint(g);
        }
        for (int i = 0;i < boomList.size();i++) {
            boomList.get(i).paint(g);
        }
    }

    class MyKeyListener extends KeyAdapter{
        boolean bl = false;
        boolean br = false;
        boolean bd = false;
        boolean bu = false;

        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bu && !bd && !bl && !br){
                myTank.setIsMove(false);
            }else {
                if (bu) myTank.setDir(Dir.UP);
                if (bd) myTank.setDir(Dir.DOWN);
                if (bl) myTank.setDir(Dir.LEFT);
                if (br) myTank.setDir(Dir.RIGHT);
                myTank.setIsMove(true);
            }


        }

        @Override
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_SPACE:
                    myTank.fire();
                    break;

                default:
                    break;
            }
            setMainTankDir();
        }
    }
}
