package second_project.simulation.map;

import second_project.simulation.AppSettings;
import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.entities.Entity;
import second_project.simulation.entities.creatures.Creature;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class SimulationMap {
    private static volatile SimulationMap instance;
    private final ConcurrentHashMap<Coordinates, Entity> map;
    private int coefficient = 1;
    private int worldHeight;
    private int worldWidth;
    private SimulationMap() {
        this.map = new ConcurrentHashMap<>();
        worldHeight = AppSettings.WORLD_HEIGHT;
        worldWidth = AppSettings.WORLD_WIDTH;
    }

    public static SimulationMap getInstance() {
        if (instance == null) {
            synchronized (SimulationMap.class) {
                if (instance == null) {
                    instance = new SimulationMap();
                }
            }
        }
        return instance;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public void setWorldHeight(int worldHeight) {
        this.worldHeight = worldHeight;
        coefficient = ((worldWidth * worldHeight) / (AppSettings.WORLD_HEIGHT * AppSettings.WORLD_WIDTH));
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public void setWorldWidth(int worldWidth) {
        this.worldWidth = worldWidth;
        coefficient = ((worldWidth * worldHeight) / (AppSettings.WORLD_HEIGHT * AppSettings.WORLD_WIDTH));
    }

    public CopyOnWriteArrayList<Entity> getEntities() {
        return new CopyOnWriteArrayList<>(map.values());
    }

    public void removeDeadCreatures() {
        Set<Coordinates> tempSet = map.values().parallelStream().filter(e -> e instanceof Creature).filter(e -> ((Creature) e).isDead()).map(e -> e.getCoordinates()).collect(Collectors.toSet());
        tempSet.forEach(map::remove);
//        HashMap<Coordinates, Entity> deadList = map.entrySet().stream().filter((e) -> e.getValue() instanceof Creature).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
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
            randomCoordinate = new Coordinates(getRandomIntegerInLimit(worldWidth), getRandomIntegerInLimit(worldHeight));
        } while (map.containsKey(randomCoordinate));
        return randomCoordinate;
    }

    public boolean isCoordinateOnMap(Coordinates coordinates) {
        return coordinates.abscissa >= 0 && coordinates.ordinate >= 0 && coordinates.abscissa < worldWidth && coordinates.ordinate < worldHeight;
    }

    public List<Coordinates> getAvailableMoveCoordinates(Coordinates coordinates) {
        CopyOnWriteArrayList<Coordinates> variants = new CopyOnWriteArrayList<>(MapUtility.getNeighboursCoordinates(coordinates));
        return variants.stream().parallel().filter(e -> isCoordinateOnMap(e) && isCoordinateEmpty(e)).collect(Collectors.toList());
    }
}
