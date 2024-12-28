package second_project.simulation.entities.creatures;

import second_project.simulation.AppConstants;
import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.entities.Entity;

public class Carnivore extends Creature {
    private final Integer strength;

    public Carnivore(Coordinates coordinates) {
        super(coordinates);
        img = String.valueOf(ConsolePics.CARNIVORE.getPic());
        speed = AppConstants.CARNIVORE_SPEED;
        health = AppConstants.CARNIVORE_HEALTH;
        strength = AppConstants.CARNIVORE_STRENGTH;
        foodType = Herbivore.class;
    }

    @Override
    protected void biteMyFood(Entity food) {
        if (health < AppConstants.CARNIVORE_HEALTH) {
            health++;
        }
        biteCreatureOnCoordinate(food.getCoordinates());
    }

    public void biteCreatureOnCoordinate(Coordinates coordinates) {
        ((Creature) MapUtility.getEntityByCoordinates(coordinates)).getDamage(this.strength);
    }
}
