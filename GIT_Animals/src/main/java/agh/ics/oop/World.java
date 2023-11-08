package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MapDirection;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        MoveDirection[] directions = OptionsParser.convertOptions(args);
        run(directions);
        System.out.println("Stop");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection direction = MapDirection.WEST;
        System.out.println(direction + ", następny kierunek: " + direction.next() + " poprzedni kireunek: " + direction.previous() + " unit vector: " + direction.toUnitVector());
    }
    public static void run(MoveDirection[] args){
        
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
