package second_project.simulation.map;

import second_project.simulation.Coordinates;
import second_project.simulation.entities.Entity;
import second_project.simulation.entities.creatures.Creature;

import java.util.HashMap;
import java.util.Random;

public class Map {
    private final HashMap<Coordinates, Entity> map;
    private final Coordinates mapSize;

    public Map(Coordinates mapSize) {
        this.mapSize = mapSize;
        this.map = new HashMap<>();
    }

    public Coordinates getMapSize() {
        return mapSize;
    }

    protected Entity removeEntityByCoordinates(Coordinates coordinates) {
        return map.remove(coordinates);
    }

    protected void moveEntity(Coordinates from, Coordinates to) {
        Entity entity = removeEntityByCoordinates(from);
        entity.setCoordinates(to);
        this.setEntityToCoordinate(to, entity);
    }

    public void removeDeadCreatures() {
        map.forEach((coordinates, entity) -> {
            if (((Creature) entity).IsDead) map.remove(coordinates);
        });
    }

    public boolean isCoordinateEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public Entity getEntityByCoordinates(Coordinates coordinates) {
        return map.get(coordinates);
    }

    protected void setEntityToCoordinate(Coordinates coordinates, Entity entity) {
        entity.setCoordinates(coordinates);
        map.put(coordinates, entity);
    }

    public void setEntityToRandomEmptyCoordinate(Entity entity) {
        Coordinates newCoordinate = getEmptyRandomCoordinate();
        setEntityToCoordinate(newCoordinate, entity);
    }

    private Coordinates getRandomCoordinate() {
        Integer abscissa = getRandomIntegerInLimit(mapSize.abscissa);
        Integer ordinate = getRandomIntegerInLimit(mapSize.ordinate);
        return new Coordinates(abscissa, ordinate);
    }

    private Integer getRandomIntegerInLimit(Integer limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    public Coordinates getEmptyRandomCoordinate() {
        Coordinates randomCoordinate;
        do {
            randomCoordinate = getRandomCoordinate();
        } while (map.containsKey(randomCoordinate));
        return randomCoordinate;
    }

    public boolean isCoordinateOnMap(Coordinates coordinates) {
        return coordinates.abscissa > 0 && coordinates.ordinate > 0 && coordinates.abscissa < mapSize.abscissa && coordinates.ordinate < mapSize.ordinate;
    }
}
