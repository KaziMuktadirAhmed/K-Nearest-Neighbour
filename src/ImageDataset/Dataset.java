package ImageDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Dataset {
    private String filePath;
    private ArrayList<File> ImageSet = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> TrainingImagePoints = new ArrayList();

    public Dataset(String filePath) throws IOException {
        this.filePath = filePath;
        readImageFromFile();
    }

    public void setFilePath(String filePath) throws IOException {
        this.filePath = filePath;
        readImageFromFile();
    }

    private void readImageFromFile () throws IOException {
        ImageSet.addAll(Arrays.asList(Objects.requireNonNull(new File(filePath).listFiles())));

        for (File imageFile : ImageSet) {
            BufferedImage image = ImageIO.read(imageFile);
            ArrayList<Integer> ImageVector = new ArrayList<>();

            for (int i=0; i<image.getHeight(); i++) {
                for (int j=0; j<image.getWidth(); j++) {
                    Color pixel = new Color(image.getRGB(j, i));
                    ImageVector.add(pixel.getRed());
                    ImageVector.add(pixel.getGreen());
                    ImageVector.add(pixel.getBlue());
                }
            }

            TrainingImagePoints.add(ImageVector);
        }
    }
}
