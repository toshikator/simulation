package second_project.simulation.entities.creatures;

import second_project.simulation.AppConstants;
import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;

import second_project.simulation.entities.Entity;
import second_project.simulation.entities.resources.Grass;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        img = String.valueOf(ConsolePics.HERBIVORE.getPic());
        speed = AppConstants.HERBIVORE_SPEED;
        health = AppConstants.HERBIVORE_HEALTH;
        foodType = Grass.class;
    }

    @Override
    protected void biteMyFood(Entity food) {
        if (health < AppConstants.HERBIVORE_HEALTH) {
            health++;
        }
    }
}

