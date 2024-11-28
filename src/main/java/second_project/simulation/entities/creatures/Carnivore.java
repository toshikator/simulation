package second_project.simulation.entities.creatures;

import second_project.simulation.AppConstants;
import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.entities.Entity;
import second_project.simulation.entities.FoodTypesForCreatures;
import second_project.simulation.map.Map;

import java.util.ArrayList;

public class Carnivore extends Creature {
    private final Integer strength;

    public Carnivore(Coordinates coordinates) {
        super(coordinates);
//        this.name = "Carnivore";
        this.img = String.valueOf(ConsolePics.CARNIVORE.getPic());
        this.speed = AppConstants.CARNIVORE_SPEED;
        this.health = AppConstants.CARNIVORE_HEALTH;
        this.strength = AppConstants.CARNIVORE_STRENGTH;
        this.foodType = FoodTypesForCreatures.CarnivoreFood.getFood();
    }

    @Override
    protected Coordinates getClosestFoodCoordinate() {
        return null;
    }

    @Override
    protected void eatMyFood(Entity food) {

    }

    public void biteCreatureOnCoordinate(Coordinates coordinates) {
        ((Creature) MapUtility.getEntityByCoordinates(coordinates)).getDamage(this.strength);
    }
}
