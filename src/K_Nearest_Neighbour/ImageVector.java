package K_Nearest_Neighbour;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageVector {
    private String ImageType;
    private final File ImageFile;
    public ArrayList<Integer> Vector = new ArrayList<>();

    public ImageVector (File ImageFile, String ImageType) throws IOException {
        this.ImageFile = ImageFile;
        this.ImageType = ImageType;
        convertToImageVector();
    }

    public void setImageType (String ImageType) {
        this.ImageType = ImageType;
    }

    public String Type () {
        return this.ImageType;
    }

    private void convertToImageVector() throws IOException {
        BufferedImage image = ImageIO.read(ImageFile);
        image = resizeImage(400, 400, image);
        int[] idkkys = image.getRGB(0,0,image.getWidth(),image.getHeight(), null, 0, image.getHeight());
        this.Vector = new ArrayList<>();
        for (int i=0; i<idkkys.length; i++) {

                Color pixel = new Color(idkkys[i]);
                this.Vector.add(pixel.getRed());
                this.Vector.add(pixel.getGreen());
                this.Vector.add(pixel.getBlue());
        }
    }

    private BufferedImage resizeImage (int targetHeight, int targetWidth, BufferedImage originalImage) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
}

