package agh.ics.oop.model;

public class ConsoleMapDisplay implements  MapChangeListener{
    private int totalUpdates = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        synchronized (this) {
            totalUpdates++;
            System.out.println("Map ID: " + worldMap.getId());
            System.out.println("Map operation: " + message);
            System.out.println(worldMap);
            System.out.println("Total number of updates: " + totalUpdates);
        }
    }
}
