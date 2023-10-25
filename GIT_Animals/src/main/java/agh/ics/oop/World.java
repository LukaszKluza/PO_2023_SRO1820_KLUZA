package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        run(OptionsParser.convertOptions(args));
        System.out.println("System zakończył działanie");
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
//        for(String arg: args){
//            String message = switch (arg){
//                case "f" -> "Zwierzak idzie do przodu";
//                case "b" -> "Zwierzak idzie do tyłu";
//                case "l" -> "Zwierzak idzie w lewo";
//                case "r" -> "Zwierzak idzie w prawo";
//                default -> null;
//            };
//            if(message != null){
//                System.out.println(message);
//            }
//        }
    }
}
