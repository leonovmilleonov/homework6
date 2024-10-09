package Exercise1.src;

import java.util.List;

public class StatisticObject {
    private List<String> names;
    private double averageScore;

    public StatisticObject(List<String> names, double averageScore) {
        this.names = names;
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "StatisticObject{" +
               "names=" + names +
               ", averageScore=" + averageScore +
               '}';
    }

    public List<String> getNames() {
        return names;
    }

    public double getAverageScore() {
        return averageScore;
    }
}
