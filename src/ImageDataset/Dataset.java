package ImageDataset;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Dataset {
    private String filePath;
    private ArrayList<File> ImageSet = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> TrainingImagePoints = new ArrayList();

    public Dataset(String filePath) {
        this.filePath = filePath;
        readImageFromFile();
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        readImageFromFile();
    }

    private void readImageFromFile () {
        ImageSet.addAll(Arrays.asList(Objects.requireNonNull(new File(filePath).listFiles())));

    }
}
