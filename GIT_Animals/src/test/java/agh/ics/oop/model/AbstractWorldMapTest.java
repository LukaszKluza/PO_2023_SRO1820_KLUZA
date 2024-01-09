package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractWorldMapTest {

    @Test
    void getOrderedAnimals() {
        List<Vector2d> positions = List.of(new Vector2d(3,5), new Vector2d(3,4),
                                            new Vector2d(1,5), new Vector2d(3,1));
        WorldMap map = new GrassField(0,1);

        try{
            List<MoveDirection> directions = List.of(MoveDirection.LEFT);
            Simulation simulation = new Simulation(positions, directions, map);
            simulation.run();

            List<Animal> sortedAnimals = map.getOrderedAnimals();

            assertEquals(new Vector2d(1,5),sortedAnimals.get(0).getPosition() );
            assertEquals(new Vector2d(3,1),sortedAnimals.get(1).getPosition() );
            assertEquals(new Vector2d(3,4),sortedAnimals.get(2).getPosition() );
            assertEquals(new Vector2d(3,5),sortedAnimals.get(3).getPosition() );


        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}