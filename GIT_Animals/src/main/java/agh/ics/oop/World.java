package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.Simulation;


import java.util.List;

public class World {
    public static void main(String[] args) {
//        Lepsza będzie ArrayList ponieważ daje ona szybszy dostęp do każdego elementu(ten dostęp jest bezpośredni)

//        Animal animal1 = new Animal(new Vector2d(0,0));
//        Animal animal2 = new Animal();
//        System.out.println(animal1.toString());
//        System.out.println(animal2.toString());

        System.out.println("Start");
        List<MoveDirection> directions = OptionsParser.convertOptions(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
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
