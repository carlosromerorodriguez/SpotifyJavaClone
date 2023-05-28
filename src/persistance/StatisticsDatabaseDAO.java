package persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class StatisticsDatabaseDAO implements StatisticsDAO {
    private final DDBBAccess ddbbAccess;
    /**
     * Constructor
     * @param ddbbAccess Database access
     */
    public StatisticsDatabaseDAO(DDBBAccess ddbbAccess) {
        this.ddbbAccess = ddbbAccess;
    }

    /**
     * Get statistics from the database
     * @return statistics
     */
    @Override
    public HashMap<String, Integer> getStatistics() {
        HashMap<String, Integer> result = new HashMap<>();
        String query = "SELECT genere, COUNT(*) as count FROM cancion GROUP BY genere";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                String genre = rs.getString("genere");
                int count = rs.getInt("count");
                result.put(genre, count);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las estadísticas: " + e.getMessage());
        }
        return result;
    }
}
