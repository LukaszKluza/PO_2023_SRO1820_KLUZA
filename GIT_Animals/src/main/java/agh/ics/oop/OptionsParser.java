package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;


public class OptionsParser {
    public static MoveDirection[] convertOptions(String[] args){
        MoveDirection[] tempEnum = new MoveDirection[args.length];
        int counter = 0;
        for(String arg: args){
            MoveDirection message = switch (arg){
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "l" -> MoveDirection.LEFT;
                case "r" -> MoveDirection.RIGHT;
                default -> null;
            };
            if (message != null) {
                tempEnum[counter] = message;
                counter++;
            }
        }
        MoveDirection[] enum_args = new MoveDirection[counter];

        System.arraycopy(tempEnum, 0, enum_args, 0, counter);
        return enum_args;
    }
}
