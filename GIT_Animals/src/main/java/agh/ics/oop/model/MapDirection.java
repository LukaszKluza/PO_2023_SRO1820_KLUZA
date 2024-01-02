package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public String toString(){
        return switch(this) {
            case NORTH -> "NORTH";
            case EAST -> "EAST";
            case SOUTH -> "SOUTH";
            case WEST -> "WEST";
        };
    }

    public MapDirection next(){
        int ordinal = this.ordinal();
        MapDirection[] values = MapDirection.values();
        int nextOrdinal = (ordinal +1) % values.length;
        return  values[nextOrdinal];
    }

    public MapDirection previous(){
        int ordinal = this.ordinal();
        MapDirection[] values = MapDirection.values();
        int previousOrdinal = (ordinal-1 + values.length) % values.length;
        return  values[previousOrdinal];
    }

    public Vector2d toUnitVector(){
        return switch (this){
            case NORTH -> new Vector2d(0,1);
            case EAST -> new Vector2d(1,0);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
        };
    }
}