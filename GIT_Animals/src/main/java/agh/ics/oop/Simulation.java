package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Vector2d> animalsVector;
    private final List<MoveDirection> animalsMoves;
    private final List<Animal> animalsList = new ArrayList<>();

    public Simulation(List<Vector2d> animalsVector, List<MoveDirection> animalsDirections) {
        this.animalsVector = animalsVector;
        this.animalsMoves = animalsDirections;
        for (Vector2d vector2d : animalsVector) {
            animalsList.add(new Animal(vector2d));
        }
    }

    public void run(){
        int animalListSize = animalsList.size();
        for(int i =0; i<animalsMoves.size(); ++i){
            animalsList.get(i%animalListSize).move(animalsMoves.get(i));
            System.out.println("Zwierzak: " + i%animalListSize + ", " + animalsList.get(i%animalListSize).getAnimalVector());
        }
    }

    public List<Animal> getAnimalsList() {
        return Collections.unmodifiableList(animalsList);
    }

}
