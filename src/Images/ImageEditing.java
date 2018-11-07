
package Images;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageEditing {

	public static void invertImage(String dir, String imageName) {
        BufferedImage inputFile = null;
        try {
            inputFile = ImageIO.read(new File(dir+imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int x = 0; x < inputFile.getWidth(); x++) {
            for (int y = 0; y < inputFile.getHeight(); y++) {
                int rgba = inputFile.getRGB(x, y);
                Color col = new Color(rgba, true);
                col = new Color(255 - col.getRed(),
                                255 - col.getGreen(),
                                255 - col.getBlue());
                inputFile.setRGB(x, y, col.getRGB());
            }
        }

        try {
            File outputFile = new File(dir+"invert-"+imageName);
            ImageIO.write(inputFile, "jpg", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
