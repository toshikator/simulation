package second_project.simulation.map;

import second_project.simulation.Coordinates;
import second_project.simulation.entities.Entity;

import java.util.HashMap;

public class Map {
    public final HashMap<Coordinates, Entity> map;
    public final Coordinates mapSize;

    public Map(Coordinates mapSize) {
        this.mapSize = mapSize;
        this.map = new HashMap<>();
    }
}
