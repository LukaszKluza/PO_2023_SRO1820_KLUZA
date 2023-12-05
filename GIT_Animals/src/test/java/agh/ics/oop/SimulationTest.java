package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    @Test
    void runBorder(){
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap map = new GrassField(10);
        String[] input = {"b","f","l","l","f","b","f","b","f","l","l","b","f","l","f","b"};

        try{
            List<MoveDirection> directions = OptionsParser.convertOptions(input);
            Simulation simulation = new Simulation(positions, directions, map);
            simulation.run();

            assertEquals(new Vector2d(-1,-1),simulation.getAnimalsList().get(0).getPosition());
            assertEquals(new Vector2d(4,6),simulation.getAnimalsList().get(1).getPosition());
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    @Test
    void runOrientation(){
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap map = new GrassField(10);
        String[] input = {"r","l","r","l","l","l","r","l"};

        try {
            List<MoveDirection> directions = OptionsParser.convertOptions(input);
            Simulation simulation = new Simulation(positions, directions, map);
            simulation.run();

            assertEquals(MapDirection.SOUTH, simulation.getAnimalsList().get(0).getAnimalDirection());
            assertEquals(MapDirection.NORTH, simulation.getAnimalsList().get(1).getAnimalDirection());
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    @Test
    void runComplex() {
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap map = new GrassField(10);
        String[] input = {"r","l","f","r","r","f"};

        try{
            List<MoveDirection> directions = OptionsParser.convertOptions(input);
            Simulation simulation = new Simulation(positions, directions, map);
            simulation.run();

            assertEquals(new Vector2d(3,2),simulation.getAnimalsList().get(0).getPosition());
            assertEquals(new Vector2d(3,5),simulation.getAnimalsList().get(1).getPosition());
            assertEquals(MapDirection.SOUTH, simulation.getAnimalsList().get(0).getAnimalDirection());
            assertEquals(MapDirection.NORTH, simulation.getAnimalsList().get(1).getAnimalDirection());
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}