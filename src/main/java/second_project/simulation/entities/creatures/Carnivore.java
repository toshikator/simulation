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
        this.img = String.valueOf(ConsolePics.CARNIVORE.getPic());
        this.speed = AppConstants.CARNIVORE_SPEED;
        this.health = AppConstants.CARNIVORE_HEALTH;
        this.strength = AppConstants.CARNIVORE_STRENGTH;
        this.foodType = Creature.class;
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
