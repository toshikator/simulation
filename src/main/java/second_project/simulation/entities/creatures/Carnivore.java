package second_project.simulation.entities.creatures;

import second_project.simulation.AppSettings;
import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.entities.Entity;

public class Carnivore extends Creature {
    private final Integer strength;

    public Carnivore(Coordinates coordinates) {
        super(coordinates);
        img = String.valueOf(ConsolePics.CARNIVORE.getPic());
        speed = AppSettings.CARNIVORE_SPEED;
        health = AppSettings.CARNIVORE_HEALTH;
        strength = AppSettings.CARNIVORE_STRENGTH;
        foodType = Herbivore.class;
    }

    @Override
    protected void biteMyFood(Entity food) {
        if (health < AppSettings.CARNIVORE_HEALTH) {
            health++;
        }
        biteCreatureOnCoordinate(food.getCoordinates());
    }

    public void biteCreatureOnCoordinate(Coordinates coordinates) {
        ((Creature) MapUtility.getEntityByCoordinates(coordinates)).getDamage(this.strength);
    }
}
