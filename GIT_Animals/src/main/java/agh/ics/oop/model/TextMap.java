package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class TextMap implements WorldMap<MyString, Integer> {

    Map<Integer, MyString> elements = new HashMap<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.getX() >=0 && position.getX() < elements.size();
    }

    @Override
    public boolean place(MyString element) {
        element.setStringPosition(elements.size());
        elements.put(element.getStringPosition(), element);
        return true;
    }

    @Override
    public void move(MyString element, MoveDirection direction) {
        if(elements.containsValue(element)){
            int oldPosition = element.getStringPosition();
            element.move(direction,this);
            int newPosition = element.getStringPosition();
            elements.remove(oldPosition);
            elements.put(oldPosition, element);
            if(oldPosition != newPosition){
                swap(oldPosition, newPosition);
            }
        }
    }

    public void swap(Integer position1, Integer position2){
        MyString element1 = elements.get(position1);
        MyString element2 = elements.get(position2);
        elements.remove(position1);
        elements.remove(position2);
        elements.put(position1, element2);
        elements.put(position2, element1);
        element2.setStringPosition(position1);
        element1.setStringPosition(position2);
    }

    @Override
    public boolean isOccupied(Integer position) {
        return position < elements.size();
    }

    @Override
    public MyString objectAt(Integer position) {
        if (isOccupied(position)){
            return elements.get(position);
        }
        return null;
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    public Map<Integer, MyString> getElements() {
        return elements;
    }
}
