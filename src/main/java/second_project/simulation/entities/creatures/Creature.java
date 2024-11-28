package second_project.simulation.entities.creatures;

import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.actions.pathfinder.AStarTracer;
import second_project.simulation.actions.pathfinder.NodeOnMap;
import second_project.simulation.entities.Entity;
import second_project.simulation.map.Map;

import java.util.*;

public abstract class Creature extends Entity {
    //    protected final ArrayList<Entity> mapEntities;
    public boolean isDead;
    protected Integer speed;
    protected Integer health;
    protected String foodType;

    public Creature(Coordinates coordinates) {
        super(coordinates);
//        this.mapEntities = mapEntities;
    }

    public void getDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            dead();
        }
    }

    protected Coordinates getClosestFoodCoordinate() {
        HashMap<Integer, Entity> foodDatabase = new HashMap<>();
        for (Entity entity : MapUtility.getEntities()) {
            if (Objects.equals(entity.getClass().getSimpleName(), foodType)) {
                foodDatabase.put(Map.calculateDistance(entity.getCoordinates(), this.getCoordinates()), entity);
            }
        }
        return foodDatabase.get(foodDatabase.keySet().stream().findFirst().get()).getCoordinates();
    }

    protected Entity getEatableFood() {
        Coordinates[] variants = {
                new Coordinates(this.coordinates.abscissa + 1, this.coordinates.ordinate),
                new Coordinates(this.coordinates.abscissa - 1, this.coordinates.ordinate),
                new Coordinates(this.coordinates.abscissa, this.coordinates.ordinate + 1),
                new Coordinates(this.coordinates.abscissa, this.coordinates.ordinate - 1),
        };

        for (Coordinates temp : variants) {

            if (MapUtility.isCoordinateOnMap(temp)) {
                if (!MapUtility.isCoordinateEmpty(temp)) {
                    if (MapUtility.getEntityByCoordinates(temp).getClass().getSimpleName().equals(foodType)) {
                        return MapUtility.getEntityByCoordinates(temp);
                    }
                }
            }
        }
        return null;
    }

    public void makeAction() {
        Entity temp = getEatableFood();
        if (Objects.isNull(temp)) {
            try {
                goToMyFood(getClosestFoodCoordinate());
            } catch (NullPointerException e) {
                System.out.println("no way");
            }
        } else {
            eatMyFood(temp);
        }
    }

    protected void goToMyFood(Coordinates food) {
        AStarTracer tracer = new AStarTracer(MapUtility.getMap(), this.coordinates, MapUtility.getEntityByCoordinates(getClosestFoodCoordinate()).getCoordinates());
        System.out.println("food for " + this.coordinates + " is " + getClosestFoodCoordinate());
        List<NodeOnMap> path = tracer.findPath();
        for (int i = 1; i < speed && path.size() > 1; i++) {
            path.removeFirst();
        }
//        map.moveEntity(this.coordinates, path.getFirst().getCoordinates());
        MapUtility.setEntityToCoordinate(path.getFirst().getCoordinates(), this);
    }

    protected abstract void eatMyFood(Entity food);

    public void dead() {
        this.isDead = true;
    }

//    public Set<Coordinates> getAvailableMoveCoordinates() {
//        Set<Coordinates> availableMoveCoordinates = new HashSet<>();
//
//        for (int i = -this.getCoordinates().abscissa; i < this.getCoordinates().abscissa; i++) {
//            for (int j = -this.getCoordinates().ordinate; j < this.getCoordinates().ordinate; j++) {
//                if (Math.abs(i) + Math.abs(j) <= this.speed) {
//                    Coordinates possibleCoordinates = new Coordinates(i, j);
//                    if (map.isCoordinateOnMap(possibleCoordinates) && map.isCoordinateEmpty(possibleCoordinates)) {
//                        availableMoveCoordinates.add(possibleCoordinates);
//                    }
//                }
//            }
//        }
//        return availableMoveCoordinates;
//    }
}
