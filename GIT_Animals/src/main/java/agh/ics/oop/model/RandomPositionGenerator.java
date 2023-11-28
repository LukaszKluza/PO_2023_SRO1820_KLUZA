package agh.ics.oop.model;

import java.util.*;

public class RandomPositionGenerator implements Iterable<Vector2d>, Iterator<Vector2d>{

    private int currentIndex = 0;
    private final List<Vector2d> drawResults = new ArrayList<>();

    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {
        List<Vector2d> drawPool = new ArrayList<>();
        for(int i = 0; i<maxWidth; ++i){
            for(int j =0; j<maxHeight; ++j){
                drawPool.add(new Vector2d(i,j));
            }
        }
        Random random =new Random();
        for(int i=0; i<grassCount; ++i){
            int randomIndex = random.nextInt(drawPool.size());
            Vector2d randomPosition = drawPool.get(randomIndex);
            drawPool.remove(randomIndex);
            drawResults.add(randomPosition);
        }
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return this;
    }
    @Override
    public boolean hasNext() {
        return currentIndex < drawResults.size();
    }

    @Override
    public Vector2d next() {
        if(hasNext()){
            return drawResults.get(currentIndex++);
        }
        return null;
    }
}
