package main.persistance;

import main.business.entities.DDBBInfo;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigDatabaseDAO implements ConfigDAO {
    private final String path = "data/config.json";
    @Override
    public DDBBInfo readConfigJson () throws IOException {
        JSONObject jsonObject = new JSONObject(new String(Files.readAllBytes(Paths.get(path))));
        return new DDBBInfo(jsonObject.getInt("port"),
                            jsonObject.getString("ip"),
                            jsonObject.getString("name"),
                            jsonObject.getString("user"),
                            jsonObject.getString("password"));
    }
}
