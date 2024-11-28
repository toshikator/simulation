package second_project.simulation;

import second_project.simulation.entities.Entity;
import second_project.simulation.map.Map;

import java.util.ArrayList;

public class MapUtility {

    private static Map map;

    public static boolean isCoordinateEmpty(Coordinates coordinates) {
        return map.isCoordinateEmpty(coordinates);
    }

    public static Entity getEntityByCoordinates(Coordinates coordinates) {
        return map.getEntityByCoordinates(coordinates);
    }

    public static void setEntityToCoordinate(Coordinates coordinates, Entity entity) {
        map.setEntityToCoordinate(coordinates, entity);
    }

    public static boolean isCoordinateOnMap(Coordinates coordinates) {
        return map.isCoordinateOnMap(coordinates);
    }

    public static Map getMap() {
        return map;
    }

    public static void setMap(Map map) {
        MapUtility.map = map;
    }

    public static Coordinates getEmptyRandomCoordinate() {
        return map.getEmptyRandomCoordinate();
    }

    public static ArrayList<Entity> getEntities() {
        return map.getEntities();
    }
}
