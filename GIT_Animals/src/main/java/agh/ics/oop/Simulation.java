package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final WorldMap map;
    private final List<MoveDirection> animalsMovements;
    private final List<Animal> animalsList = new ArrayList<>();

    public Simulation(List<Vector2d> animalsVector, List<MoveDirection> animalsDirections, WorldMap map) {
        this.map = map;
        this.animalsMovements = animalsDirections;
        for (Vector2d vector2d : animalsVector) {
            Animal animal = new Animal(vector2d);
            animalsList.add(animal);
            map.place(animal);
        }
    }

    public void run(){
        int animalListSize = animalsList.size();
        for(int i=0; i<animalsMovements.size(); ++i){
            Animal animal = animalsList.get(i%animalListSize);
            map.move(animal, animalsMovements.get(i));
            System.out.println(map);
        }
    }
    public List<Animal> getAnimalsList() {
        return Collections.unmodifiableList(animalsList);
    }
}
