package second_project.simulation.actions.foodFinder;

import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.entities.Entity;

import java.util.*;
import java.util.stream.Collectors;

public class BFS {
    Coordinates start;
    Class foodType;
    Queue<Coordinates> openSet;
    HashSet<Coordinates> closedSet;

    public BFS(Coordinates start, Class foodType) {
        this.start = start;
        this.foodType = foodType;
        openSet = new ArrayDeque<>();
        closedSet = new HashSet<>();
    }

    protected Entity getEatableFood(Coordinates coordinates) {
        Coordinates[] variants = {
                new Coordinates(coordinates.abscissa + 1, coordinates.ordinate),
                new Coordinates(coordinates.abscissa - 1, coordinates.ordinate),
                new Coordinates(coordinates.abscissa, coordinates.ordinate + 1),
                new Coordinates(coordinates.abscissa, coordinates.ordinate - 1),
        };

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
