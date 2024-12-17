package second_project.simulation.entities.creatures;

import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.actions.foodFinder.ClosestFoodFinder;
import second_project.simulation.actions.pathfinder.AStarRouteTracer;
import second_project.simulation.actions.pathfinder.NodeOnMapAStar;
import second_project.simulation.entities.Entity;

import java.util.*;

public abstract class Creature extends Entity {
    protected boolean isDead;
    protected Integer speed;
    protected Integer health;
    protected Class foodType;

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    public boolean isDead() {
        return isDead;
    }

    public void getDamage(int damage) {
        health -= damage;
//        System.out.println(health);
        if (health <= 0) {
            dead();
        }
//        System.out.println("damage taken");
    }

    protected Coordinates getClosestFoodCoordinate() {
        ClosestFoodFinder closestFoodFinder = new ClosestFoodFinder(coordinates, foodType);
        return closestFoodFinder.findFood();
    }

    protected Entity getEatableFood() {
        Coordinates[] variants = MapUtility.getNeighboursCoordinates(coordinates);

        Optional<Coordinates> foodCoordinates = Arrays.stream(variants).filter(coordinates -> MapUtility.isCoordinateOnMap(coordinates)
                && !MapUtility.isCoordinateEmpty(coordinates) && MapUtility.getEntityByCoordinates(coordinates).getClass().equals(foodType)).findAny();
        return foodCoordinates.map(MapUtility::getEntityByCoordinates).orElse(null);
    }

    public void makeAction() {
        Entity temp = getEatableFood();
        if (Objects.isNull(temp)) {
            try {
                Coordinates foodCoordinates = getClosestFoodCoordinate();
                goToMyFood(foodCoordinates);
            } catch (NullPointerException e) {
                System.out.println("no way");
            }
        } else {
            biteMyFood(temp);
        }
    }

    protected void goToMyFood(Coordinates foodCoordinates) {
        AStarRouteTracer tracer = new AStarRouteTracer(MapUtility.getMap(), coordinates, foodCoordinates);
        List<NodeOnMapAStar> path = tracer.findPath();
        for (int i = 1; i < speed && path.size() > 1; i++) {
            path.removeFirst();
        }
        MapUtility.setEntityToCoordinate(path.getFirst().getCoordinates(), this);
    }

    protected abstract void biteMyFood(Entity food);

    public void dead() {
//        System.out.println(isDead());
        isDead = true;
    }
}
