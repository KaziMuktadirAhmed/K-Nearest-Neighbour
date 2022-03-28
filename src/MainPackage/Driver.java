package MainPackage;

import K_Nearest_Neighbour.ImageVector;
import K_Nearest_Neighbour.KNN_Algorithm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {
//    KNN_Algorithm algorithm;

    public void run () throws IOException {
        System.out.println("Run");

        KNN_Algorithm algorithm = new KNN_Algorithm();
        buildTestSet(algorithm);

        String decidedType = algorithm.KNN_decesion("sample.jpg", "Cat", 5);
        System.out.println("Decided type: " + decidedType);
    }

    public void test () {
        System.out.println("Test");
    }

    private void buildTestSet (KNN_Algorithm algorithm) throws IOException {
        ArrayList<ImageVector> datasetType1 = new ArrayList<>();
        ArrayList<ImageVector> datasetType2 = new ArrayList<>();

        File[] FileType1 = new File("ImageSetType1").listFiles();
        for (File file : FileType1) {
            datasetType1.add(new ImageVector(file, "Cat"));
        }

        File[] FileType2 = new File("ImageSetType2").listFiles();
        for (File file : FileType2) {
            datasetType2.add(new ImageVector(file, "Dog"));
        }

        algorithm.setDataset(datasetType1, datasetType2);
    }

}
