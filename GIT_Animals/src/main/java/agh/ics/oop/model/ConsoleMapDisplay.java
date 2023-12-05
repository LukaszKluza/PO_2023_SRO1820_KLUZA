package agh.ics.oop.model;

public class ConsoleMapDisplay implements  MapChangeListener{
    private int totalUpdates = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        totalUpdates++;
        System.out.println("Operacja na mapie: " + message);
        System.out.println(worldMap);
        System.out.println("Sumaryczna liczba aktualizacji: " + totalUpdates);
    }
}
