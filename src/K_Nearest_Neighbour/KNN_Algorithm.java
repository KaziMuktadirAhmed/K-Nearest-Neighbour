package K_Nearest_Neighbour;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


class Distance_Pair {
    double distance;
    ImageVector image;

    public Distance_Pair (double distance, ImageVector image) {
        this.distance = distance;
        this.image = image;
    }
}

public class KNN_Algorithm {
    private ArrayList<ImageVector> datasetType1;
    private ArrayList<ImageVector> datasetType2;

    private ArrayList<Distance_Pair> distance_pairs = new ArrayList<>();

    public KNN_Algorithm (ArrayList<ImageVector> datasetType1, ArrayList<ImageVector> datasetType2) {
        this.datasetType1 = datasetType1;
        this.datasetType2 = datasetType2;
    }

    public String KNN_decesion (String filePath, String imageType) throws IOException {
        StringBuilder sb = new StringBuilder();

        File ImageFile = new File(filePath);
        ImageVector image = new ImageVector(ImageFile, imageType);



        return sb.toString();
    }

    private void ManageDistanceFromDataset (ImageVector InputImage) {
        Distance_Pair pair;

        for (ImageVector vector : datasetType1) {
            double distance = CalculateDistance(vector, InputImage);
            pair = new Distance_Pair(distance, vector);
            distance_pairs.add(pair);
        }

        for (ImageVector vector : datasetType2) {
            double distance = CalculateDistance(vector, InputImage);
            pair = new Distance_Pair(distance, vector);
            distance_pairs.add(pair);
        }
    }

    private double CalculateDistance (ImageVector a, ImageVector b) {
        double distance = 0.0;

        for (int i=0; i<a.Vector.size(); i++) {
            distance += (a.Vector.get(i) - b.Vector.get(i)) * (a.Vector.get(i) - b.Vector.get(i));
        }
        distance = Math.sqrt(distance);

        return distance;
    }



}
