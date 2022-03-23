package K_Nearest_Neighbour;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

class Distance_Pair {
    public double distance;
    public ImageVector image;

    public Distance_Pair (double distance, ImageVector image) {
        this.distance = distance;
        this.image = image;
    }
}

class Distance_Comparator implements Comparator<Distance_Pair> {
    @Override
    public int compare(Distance_Pair o1, Distance_Pair o2) {
        return Double.compare(o2.distance, o1.distance);
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

    public String KNN_decesion (String filePath, String imageType, int KthVal) throws IOException {
        int k, count_type1 = 0, count_type2 = 0;
        StringBuilder sb = new StringBuilder();

        File ImageFile = new File(filePath);
        ImageVector image = new ImageVector(ImageFile, imageType);

        ManageDistanceFromDataset(image);
        distance_pairs.sort(new Distance_Comparator());

        if (KthVal > distance_pairs.size())     k = KthVal;
        else                                    return "Invalid K value";

        for (int i=0; i<k; i++) {
            Distance_Pair pair = distance_pairs.get(i);

            if (pair.image.Type().equals(datasetType1.get(0).Type()))       count_type1++;
            else if (pair.image.Type().equals(datasetType2.get(0).Type()))  count_type2++;
        }

        if (count_type1 > count_type2)  sb.append(datasetType1.get(0).Type());
        else                            sb.append(datasetType2.get(0).Type());

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
