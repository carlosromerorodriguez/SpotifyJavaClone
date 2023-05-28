package persistance;

import business.entities.DDBBInfo;
import persistance.exceptions.ConfigFileNotFoundException;

import java.io.IOException;

/**
 * ConfigDAO interface for the DAO pattern
 */
public interface ConfigDAO {
    DDBBInfo readConfigJson() throws IOException, ConfigFileNotFoundException;
}
