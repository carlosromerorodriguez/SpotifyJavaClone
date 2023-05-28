package persistance;

import java.util.HashMap;

/**
 * StatisticsDAO interface for the DAO pattern
 */
public interface StatisticsDAO {
    /**
     * Get statistics
     * @return statistics
     */
    HashMap<String, Integer> getStatistics();
}
