package second_project.simulation.entities.creatures;

import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.actions.foodFinder.BFS;
import second_project.simulation.actions.pathfinder.AStarTracer;
import second_project.simulation.actions.pathfinder.NodeOnMapAStar;
import second_project.simulation.entities.Entity;
import second_project.simulation.map.Map;

import java.util.*;
import java.util.function.Predicate;

public abstract class Creature extends Entity {
    public boolean isDead;
    protected Integer speed;
    protected Integer health;
    protected Class foodType;

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    public void getDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            dead();
        }
    }

    protected Coordinates getClosestFoodCoordinate() {
        BFS bfs = new BFS(this.coordinates, foodType);
        return bfs.findFood();
    }

    protected Entity getEatableFood() {
        Coordinates[] variants = {
                new Coordinates(this.coordinates.abscissa + 1, this.coordinates.ordinate),
                new Coordinates(this.coordinates.abscissa - 1, this.coordinates.ordinate),
                new Coordinates(this.coordinates.abscissa, this.coordinates.ordinate + 1),
                new Coordinates(this.coordinates.abscissa, this.coordinates.ordinate - 1),
        };

        Optional<Coordinates> foodCoordinates = Arrays.stream(variants).filter(coordinates -> MapUtility.isCoordinateOnMap(coordinates) && !MapUtility.isCoordinateEmpty(coordinates) && MapUtility.getEntityByCoordinates(coordinates).getClass().equals(foodType)).findAny();
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
            eatMyFood(temp);
        }
    }

    protected void goToMyFood(Coordinates foodCoordinates) {
        AStarTracer tracer = new AStarTracer(MapUtility.getMap(), this.coordinates, foodCoordinates);
//        System.out.println("food for " + this.coordinates + " is " + getClosestFoodCoordinate());
        List<NodeOnMapAStar> path = tracer.findPath();
        for (int i = 1; i < speed && path.size() > 1; i++) {
            path.removeFirst();
        }
        MapUtility.setEntityToCoordinate(path.getFirst().getCoordinates(), this);
    }

    protected abstract void eatMyFood(Entity food);

    public void dead() {
        this.isDead = true;
    }
}
