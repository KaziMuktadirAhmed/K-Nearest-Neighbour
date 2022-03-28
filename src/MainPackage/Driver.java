package MainPackage;

import K_Nearest_Neighbour.ImageVector;
import K_Nearest_Neighbour.KNN_Algorithm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {

    public void run () throws IOException {
        System.out.println("Run");

        KNN_Algorithm algorithm = new KNN_Algorithm();
        buildTestSet(algorithm);

        String decidedType = algorithm.KNN_decesion(new File("sample1.jpg"), "Cat", 6);
        System.out.println("Decided type: " + decidedType);

        double accuracy_percentage = claculateAccuracy(algorithm, "TestSet/Type1", "Cat", "TestSet/Type2", "Dog", 8);
        System.out.println("accuracy: " + accuracy_percentage + "%");
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

    public double claculateAccuracy (KNN_Algorithm algorithm, String type1FilePath, String type1, String type2FilePath, String type2, int K) throws IOException {
        int count = 0;
        double accuracy = 0.0;

        File type1Files[] = new File(type1FilePath).listFiles();
        File type2Files[] = new File(type2FilePath).listFiles();

        //KNN_Algorithm algorithm = new KNN_Algorithm();
        //buildTestSet(algorithm);

        for (File image : type1Files) {
            String decision = algorithm.KNN_decesion(image, type1, K);
            if(decision.equals(type1))
                accuracy++;
            count++;
        }

        for (File image : type2Files) {
            String decision = algorithm.KNN_decesion(image, type2, K);
            if(decision.equals(type2))
                accuracy++;
            count++;
        }

        accuracy = (accuracy/count) * 100;

        return accuracy;
    }
}
