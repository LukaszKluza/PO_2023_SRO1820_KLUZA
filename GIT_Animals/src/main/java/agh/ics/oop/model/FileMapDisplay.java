package agh.ics.oop.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileMapDisplay implements MapChangeListener{
    private final int mapId;

    public FileMapDisplay(int mapId) {
        this.mapId = mapId;
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        String logFileName = "logs/map_" + mapId + ".log";

        File logFile = new File(logFileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {

            writer.write( message + "\n");
            writer.write(worldMap.toString() + "\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
