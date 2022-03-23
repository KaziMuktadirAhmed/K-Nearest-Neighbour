package K_Nearest_Neighbour;

import java.util.ArrayList;


class Distance_Pair {
    Double distance;
    ImageVector image;

    public Distance_Pair (Double distance, ImageVector image) {
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

    public void CalculateDistance () {

    }



}
