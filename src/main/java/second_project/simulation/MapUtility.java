package second_project.simulation;

import second_project.simulation.entities.Entity;
import second_project.simulation.map.SimulationMap;

import java.util.ArrayList;
import java.util.List;

public class MapUtility {

    private static SimulationMap simulationMap;

    public static boolean isCoordinateEmpty(Coordinates coordinates) {
        return simulationMap.isCoordinateEmpty(coordinates);
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

    public static void setMap(SimulationMap simulationMap) {
        MapUtility.simulationMap = simulationMap;
    }

    public static Coordinates getEmptyRandomCoordinate() {
        return simulationMap.getEmptyRandomCoordinate();
    }

    public static ArrayList<Entity> getEntities() {
        return simulationMap.getEntities();
    }

    public static List<Coordinates> getAvailableMoveCoordinates(Coordinates coordinates) {
        return simulationMap.getAvailableMoveCoordinates(coordinates);
    }

    public static Coordinates[] getNeighboursCoordinates(Coordinates coordinates) {
        return new Coordinates[]{
                new Coordinates(coordinates.abscissa + 1, coordinates.ordinate),
                new Coordinates(coordinates.abscissa - 1, coordinates.ordinate),
                new Coordinates(coordinates.abscissa, coordinates.ordinate + 1),
                new Coordinates(coordinates.abscissa, coordinates.ordinate - 1),
        };
    }
}
