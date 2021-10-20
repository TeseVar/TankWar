package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceManage {
    public static BufferedImage tankL,tankR,tankU,tankD,bulletD,bulletL,bulletR,bulletU;
    public static List<BufferedImage> e = new ArrayList<>();
    static {
        try {
            tankL = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankU = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            bulletD = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletL = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletU = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            for(int i = 0; i < 16; i++){
                e.add(ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/e"+ (i + 1)+".gif")));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
