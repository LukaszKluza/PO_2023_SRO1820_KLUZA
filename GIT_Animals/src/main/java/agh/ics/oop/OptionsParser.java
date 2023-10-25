package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] OptionsConvert(String[] args){
        MoveDirection[] temp_enum = new MoveDirection[args.length];
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
                temp_enum[counter] = message;
                counter++;
            }
        }
        MoveDirection[] enum_args = new MoveDirection[counter];

        System.arraycopy(temp_enum, 0, enum_args, 0, counter);
        return enum_args;
    }
}
