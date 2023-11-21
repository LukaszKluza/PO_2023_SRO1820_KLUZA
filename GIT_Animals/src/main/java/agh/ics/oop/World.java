package agh.ics.oop;
import agh.ics.oop.model.*;


import java.util.List;
import java.util.Vector;

public class World {
    public static void main(String[] args) {

        System.out.println("Start");
        List<MoveDirection> directions = OptionsParser.convertOptions(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap<Animal, Vector2d> map = new RectangularMap(4,4);
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();
        System.out.println("Stop");

    }
    public static void run(List<MoveDirection> args){
        
        for(MoveDirection arg: args){
            switch (arg) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
            }
        }
    }
}
