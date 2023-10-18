package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        run(args);
        System.out.println("System zakończył działanie");
    }
    public static void run(String[] args){
        for(String arg: args){
            switch (arg){
                case "f" -> System.out.println("Zwierzak idzie do przodu");
                case "b" -> System.out.println("Zwierzak idzie do tyłu");
                case "l" -> System.out.println("Zwierzak idzie w lewo");
                case "r" -> System.out.println("Zwierzak idzie w prawo");
            }

            String message = switch (arg){
                case "f" -> "Zwierzak idzie do przodu";
                case "b" -> "Zwierzak idzie do tyłu";
                case "l" -> "Zwierzak idzie w lewo";
                case "r" -> "Zwierzak idzie w prawo";
                default -> null;
            };
            if(message != null){
                System.out.println(message);
            }
        }
    }
}
