package main.persistance;

import main.business.entities.DDBBInfo;

import java.io.IOException;

public interface ConfigDAO {
    DDBBInfo readConfigJson() throws IOException;
}
