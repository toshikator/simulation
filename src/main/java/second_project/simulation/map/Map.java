package second_project.simulation.map;

import second_project.simulation.AppConstants;
import second_project.simulation.Coordinates;
import second_project.simulation.entities.Entity;
import second_project.simulation.entities.creatures.Creature;

import java.util.*;

public class Map {
    private final HashMap<Coordinates, Entity> map;

    public Map() {
        this.map = new HashMap<>();
    }

    public static Integer calculateDistance(Coordinates from, Coordinates to) {
        return (Math.abs(to.abscissa - from.abscissa) + Math.abs(to.ordinate - from.ordinate));
    }

    public ArrayList<Entity> getEntities() {
        return new ArrayList<>(map.values());
    }

    public void removeDeadCreatures() {
        map.forEach((coordinates, entity) -> {
            if (((Creature) entity).isDead) map.remove(coordinates);
        });
    }

    public boolean isCoordinateEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public Entity getEntityByCoordinates(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public void setEntityToCoordinate(Coordinates coordinates, Entity entity) {
        map.remove(entity.getCoordinates());
        entity.setCoordinates(coordinates);
        map.put(coordinates, entity);
    }

    private Integer getRandomIntegerInLimit(Integer limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    public Coordinates getEmptyRandomCoordinate() {
        Coordinates randomCoordinate;
        do {
            randomCoordinate = new Coordinates(getRandomIntegerInLimit(AppConstants.WORLD_WIDTH), getRandomIntegerInLimit(AppConstants.WORLD_HEIGHT));
        } while (map.containsKey(randomCoordinate));
        return randomCoordinate;
    }

    public boolean isCoordinateOnMap(Coordinates coordinates) {
        return coordinates.abscissa > 0 && coordinates.ordinate > 0 && coordinates.abscissa < AppConstants.WORLD_WIDTH && coordinates.ordinate < AppConstants.WORLD_HEIGHT;
    }

    public List<Coordinates> getAvailableMoveCoordinates(Coordinates coordinates) {
        List<Coordinates> availableCoordinates = new ArrayList<>();
        for (int i = coordinates.abscissa - 1; i < coordinates.abscissa + 2; i++) {
            for (int j = coordinates.ordinate - 1; j < coordinates.ordinate + 2; j++) {
                Coordinates tempCoordinates = new Coordinates(i, j);
                if (isCoordinateOnMap(tempCoordinates)) {
                    if (isCoordinateEmpty(tempCoordinates)) {
                        if (!Objects.equals(tempCoordinates.abscissa, coordinates.abscissa) || !Objects.equals(tempCoordinates.ordinate, coordinates.ordinate)) {
                            availableCoordinates.add(tempCoordinates);
                        }
                    }
                }
            }
        }
        return availableCoordinates;
    }
}
