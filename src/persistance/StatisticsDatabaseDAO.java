package persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/*
INSERT INTO `cancion` (`id`, `nom`, `genere`, `album`, `autor`, `duration`, `url`) VALUES
(2, 'Shape of You', 'Pop', 'Divide', 'Ed Sheeran', 200, 'data/music/shape_of_you.mp3'),
(3, 'Bad Guy', 'Alternative', 'When We All Fall Asleep, Where Do We Go?', 'Billie Eilish', 210, 'data/music/bad_guy.mp3'),
(4, 'Blinding Lights', 'R&B', 'After Hours', 'The Weeknd', 220, 'data/music/blinding_lights.mp3'),
(5, 'Watermelon Sugar', 'Pop', 'Fine Line', 'Harry Styles', 230, 'data/music/watermelon_sugar.mp3'),
(6, 'Don''t Start Now', 'Pop', 'Future Nostalgia', 'Dua Lipa', 240, 'data/music/dont_start_now.mp3'),
(7, 'Yummy', 'Pop', 'Changes', 'Justin Bieber', 250, 'data/music/yummy.mp3'),
(8, 'Adore You', 'Pop', 'Fine Line', 'Harry Styles', 260, 'data/music/adore_you.mp3'),
(9, 'Dance Monkey', 'Pop', 'The Kids Are Coming', 'Tones and I', 270, 'data/music/dance_monkey.mp3'),
(10, 'Rain On Me', 'Dance', 'Chromatica', 'Lady Gaga & Ariana Grande', 280, 'data/music/rain_on_me.mp3'),
(11, 'Stuck with U', 'Pop', 'Stuck with U - Single', 'Ariana Grande & Justin Bieber', 290, 'data/music/stuck_with_u.mp3');
 */

public class StatisticsDatabaseDAO implements StatisticsDAO {
    private final DDBBAccess ddbbAccess;
    public StatisticsDatabaseDAO(DDBBAccess ddbbAccess) {
        this.ddbbAccess = ddbbAccess;
    }

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
