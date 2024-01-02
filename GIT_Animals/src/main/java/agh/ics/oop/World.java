package agh.ics.oop;
import agh.ics.oop.model.*;


import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) {

        System.out.println("Start");
//        try{
//            List<MoveDirection> directions = OptionsParser.convertOptions(args);
//            List<Vector2d> positions1 = List.of(new Vector2d(2,2), new Vector2d(3,4));
//            List<Vector2d> positions2 = List.of(new Vector2d(0,4), new Vector2d(1,4));
//            WorldMap map1 = new GrassField(10,1);
//            WorldMap map2 = new RectangularMap(5,5,2);
//            ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
//            map1.registerObserver(consoleMapDisplay);
//            map2.registerObserver(consoleMapDisplay);
//            List<Simulation> simulations = List.of(new Simulation(positions1, directions, map1), new Simulation(positions2, directions, map2));
//            SimulationEngine simulationEngine = new SimulationEngine(simulations);
//            simulationEngine.runAsyncInThreadPool();
//        }
//        catch(IllegalArgumentException e){
//            e.printStackTrace();
//        }
//        catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        try{
            List<Simulation> simulations = new ArrayList<>();
            List<MoveDirection> directions = OptionsParser.convertOptions(args);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
            ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
            for(int i =0; i<1000; ++i){
                WorldMap map = new GrassField(10,i);
                simulations.add(new Simulation(positions,directions,map));
                map.registerObserver(consoleMapDisplay);
            }
            SimulationEngine simulationEngine = new SimulationEngine(simulations);
            simulationEngine.runAsyncInThreadPool();
            simulationEngine.awaitSimulationsEnd();
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
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
