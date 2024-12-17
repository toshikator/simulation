package second_project.simulation.actions.foodFinder;

import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.entities.Entity;

import java.util.*;

public class ClosestFoodFinder {
    Coordinates start;
    Class foodType;
    Queue<Coordinates> openSet;
    HashSet<Coordinates> closedSet;

    public ClosestFoodFinder(Coordinates start, Class foodType) {
        this.start = start;
        this.foodType = foodType;
        openSet = new ArrayDeque<>();
        closedSet = new HashSet<>();
    }

    protected Entity getEatableFood(Coordinates coordinates) {
        Coordinates[] variants = MapUtility.getNeighboursCoordinates(coordinates);
        Optional<Coordinates> foodCoordinates = Arrays.stream(variants).filter(c -> MapUtility.isCoordinateOnMap(c) && !MapUtility.isCoordinateEmpty(c) && MapUtility.getEntityByCoordinates(c)
                .getClass().equals(foodType)).findAny();
        return foodCoordinates.map(MapUtility::getEntityByCoordinates).orElse(null);
    }

    public Coordinates findFood() {
        openSet.add(start);
        Coordinates currentNode;
        Entity food;
        while (!openSet.isEmpty()) {
            currentNode = openSet.poll();
            closedSet.add(currentNode);
            MapUtility.getAvailableMoveCoordinates(currentNode).stream().filter(e -> !closedSet.contains(e)).forEach(e -> openSet.add(e));
            food = getEatableFood(currentNode);
            if (!Objects.isNull(food)) {
                return food.getCoordinates();
            }
        }
        return null;
    }
}
