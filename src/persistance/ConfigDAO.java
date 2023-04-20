package persistance;

import business.entities.DDBBInfo;

import java.io.IOException;

public interface ConfigDAO {
    DDBBInfo readConfigJson() throws IOException;
}
