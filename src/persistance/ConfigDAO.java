package persistance;

import business.entities.DDBBInfo;
import persistance.exceptions.ConfigFileNotFoundException;

import java.io.IOException;

public interface ConfigDAO {
    DDBBInfo readConfigJson() throws IOException, ConfigFileNotFoundException;
}
