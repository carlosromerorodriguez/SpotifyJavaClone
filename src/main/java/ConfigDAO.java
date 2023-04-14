import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
public class ConfigDAO {
    public Config readConfig () {
        JsonParser jsonParser = new JsonParser();
        JsonObject config = new JsonObject ();
        try (FileReader reader = new FileReader("src/main/java/config.json")) {
            Object obj = jsonParser.parse(reader);
            config = (JsonObject) obj;

            JsonElement jPort = config.get("port");
            int port = jPort.getAsInt();

            String jString = String.valueOf(config.get("ip"));
            String[] ipLimpio = (jString.split("\""));

            jString = String.valueOf(config.get("nom"));
            String[] nameLimpio = (jString.split("\""));

            jString = String.valueOf(config.get("user"));
            String[] userLimpio = (jString.split("\""));

            JsonElement jPass = config.get("password");
            int pass = jPort.getAsInt();

            return new Config(port, ipLimpio[1], nameLimpio[1], userLimpio[1], pass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}