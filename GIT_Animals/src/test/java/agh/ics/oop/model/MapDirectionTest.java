package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next() {
        MapDirection directionNorth = MapDirection.NORTH;
        MapDirection directionEast = MapDirection.EAST;
        MapDirection directionSouth = MapDirection.SOUTH;
        MapDirection directionWest = MapDirection.WEST;

        MapDirection nextNorth = directionNorth.next();
        MapDirection nextEast = directionEast.next();
        MapDirection nextSouth = directionSouth.next();
        MapDirection nextWest = directionWest.next();

        assertEquals(MapDirection.EAST, nextNorth);
        assertEquals(MapDirection.SOUTH, nextEast);
        assertEquals(MapDirection.WEST, nextSouth);
        assertEquals(MapDirection.NORTH, nextWest);
    }

    @Test
    void previous() {
        MapDirection directionNorth = MapDirection.NORTH;
        MapDirection directionEast = MapDirection.EAST;
        MapDirection directionSouth = MapDirection.SOUTH;
        MapDirection directionWest = MapDirection.WEST;

        MapDirection previousNorth = directionNorth.previous();
        MapDirection previousEast = directionEast.previous();
        MapDirection previousSouth = directionSouth.previous();
        MapDirection previousWest = directionWest.previous();

        assertEquals(MapDirection.WEST, previousNorth);
        assertEquals(MapDirection.NORTH, previousEast);
        assertEquals(MapDirection.EAST, previousSouth);
        assertEquals(MapDirection.SOUTH, previousWest);
    }
}