package second_project.simulation.actions.foodFinder;

import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.entities.Entity;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ClosestFoodFinder {
    Coordinates start;
    Class foodType;
    ConcurrentLinkedQueue<Coordinates> openSet;
    CopyOnWriteArraySet<Coordinates> closedSet;

    public ClosestFoodFinder(Coordinates start, Class foodType) {
        this.start = start;
        this.foodType = foodType;
        openSet = new ConcurrentLinkedQueue<>();
        closedSet = new CopyOnWriteArraySet<>();
    }

    protected Entity getEatableFood(Coordinates coordinates) {
        CopyOnWriteArrayList<Coordinates> variants = MapUtility.getNeighboursCoordinates(coordinates);

        Optional<Coordinates> foodCoordinates = variants.stream().parallel().filter(c -> MapUtility.isCoordinateOnMap(c) && !MapUtility.isCoordinateEmpty(c) && MapUtility.getEntityByCoordinates(c)
                .getClass().equals(foodType)).findFirst();
        return foodCoordinates.map(MapUtility::getEntityByCoordinates).orElse(null);
    }

    public Coordinates findFood() {
        if (MapUtility.getEntities().stream().anyMatch(e -> e.getClass().equals(foodType))) {
            openSet.add(start);
            Coordinates currentNode;
            Entity food;
            while (!openSet.isEmpty()) {
                currentNode = openSet.poll();
                closedSet.add(currentNode);
                MapUtility.getAvailableMoveCoordinates(currentNode).stream().parallel().filter(e -> !closedSet.contains(e)).forEach(e -> openSet.add(e));
                food = getEatableFood(currentNode);
                if (!Objects.isNull(food)) {
                    return food.getCoordinates();
                }
            }
        }
        return null;
    }
}
