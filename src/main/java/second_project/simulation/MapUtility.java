package second_project.simulation;

import second_project.simulation.entities.Entity;
import second_project.simulation.map.SimulationMap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MapUtility {

    private static final SimulationMap simulationMap = SimulationMap.getInstance();

    public static boolean isCoordinateEmpty(Coordinates coordinates) {
        return simulationMap.isCoordinateEmpty(coordinates);
    }

    public static Integer calculateDistance(Coordinates from, Coordinates to) {
        return (Math.abs(to.abscissa - from.abscissa) + Math.abs(to.ordinate - from.ordinate));
    }

    public static Entity getEntityByCoordinates(Coordinates coordinates) {
        return simulationMap.getEntityByCoordinates(coordinates);
    }

    public static void setEntityToCoordinate(Coordinates coordinates, Entity entity) {
        simulationMap.setEntityToCoordinate(coordinates, entity);
    }

    public static boolean isCoordinateOnMap(Coordinates coordinates) {
        return simulationMap.isCoordinateOnMap(coordinates);
    }

    public static SimulationMap getMap() {
        return simulationMap;
    }

    public static Coordinates getEmptyRandomCoordinate() {
        return simulationMap.getEmptyRandomCoordinate();
    }

    public static CopyOnWriteArrayList<Entity> getEntities() {
        return simulationMap.getEntities();
    }

    public static List<Coordinates> getAvailableMoveCoordinates(Coordinates coordinates) {
        return simulationMap.getAvailableMoveCoordinates(coordinates);
    }

    public static CopyOnWriteArrayList<Coordinates> getNeighboursCoordinates(Coordinates coordinates) {
        CopyOnWriteArrayList<Coordinates> result = new CopyOnWriteArrayList<>();
        result.add(new Coordinates(coordinates.abscissa + 1, coordinates.ordinate));
        result.add(new Coordinates(coordinates.abscissa - 1, coordinates.ordinate));
        result.add(new Coordinates(coordinates.abscissa, coordinates.ordinate + 1));
        result.add(new Coordinates(coordinates.abscissa, coordinates.ordinate - 1));

        return result;
    }
}
