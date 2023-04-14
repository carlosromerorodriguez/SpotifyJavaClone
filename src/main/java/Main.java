public class Main {
    public static void main(String[] args) {
        ConfigDAO configDAO = new ConfigDAO();
        Config config = configDAO.readConfig();
    }
}