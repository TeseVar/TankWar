package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ImageTest {
    @Test
    public void test1(){
        String projectPath = this.getClass().getResource("/").getPath();
        File file = new File(projectPath + "/images/tankD.gif");
        try {
            BufferedImage read = ImageIO.read(file);
            Assertions.assertNotNull(read);
            BufferedImage read2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            Assertions.assertNotNull(read2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
