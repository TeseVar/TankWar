package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManage {
    public static BufferedImage tankL,tankR,tankU,tankD,bulletD,bulletL,bulletR,bulletU;

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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
