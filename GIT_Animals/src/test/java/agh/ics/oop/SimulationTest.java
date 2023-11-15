package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    @Test
    void runBorder(){
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        List<MoveDirection> directions = List.of(new MoveDirection[]{
                MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT,
                MoveDirection.FORWARD,MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT,MoveDirection.BACKWARD,
                MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD,MoveDirection.BACKWARD
        });

        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        assertEquals(new Vector2d(0,0),simulation.getAnimalsList().get(0).getAnimalVector());
        assertEquals(new Vector2d(3,4),simulation.getAnimalsList().get(1).getAnimalVector());
    }
    @Test
    void runOrientation(){
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        List<MoveDirection> directions = List.of(new MoveDirection[]{
                MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.LEFT,
                MoveDirection.LEFT, MoveDirection.LEFT,MoveDirection.RIGHT, MoveDirection.LEFT
        });

        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        assertEquals(MapDirection.SOUTH,simulation.getAnimalsList().get(0).getAnimalDirection());
        assertEquals(MapDirection.NORTH,simulation.getAnimalsList().get(1).getAnimalDirection());
    }
    @Test
    void runComplex() {
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        List<MoveDirection> directions = List.of(new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.LEFT});

        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        assertEquals(new Vector2d(3,2),simulation.getAnimalsList().get(0).getAnimalVector());
        assertEquals(new Vector2d(3,4),simulation.getAnimalsList().get(1).getAnimalVector());
        assertEquals(MapDirection.SOUTH, simulation.getAnimalsList().get(0).getAnimalDirection());
        assertEquals(MapDirection.WEST, simulation.getAnimalsList().get(1).getAnimalDirection());
    }
}