package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;


public class OptionsParser {
    public static List<MoveDirection> convertOptions(String[] args){
        List<MoveDirection> enumArgs = new ArrayList<>();
        for(String arg: args){
            MoveDirection message = switch (arg){
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "l" -> MoveDirection.LEFT;
                case "r" -> MoveDirection.RIGHT;
                default -> null;
            };
            if (message != null) {
                enumArgs.add(message);
            }
        }
        return enumArgs;
    }
}
