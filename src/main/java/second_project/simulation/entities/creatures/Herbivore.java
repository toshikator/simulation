package second_project.simulation.entities.creatures;

import second_project.simulation.AppSettings;
import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;

import second_project.simulation.entities.Entity;
import second_project.simulation.entities.resources.Grass;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        img = String.valueOf(ConsolePics.HERBIVORE.getPic());
        speed = AppSettings.HERBIVORE_SPEED;
        health = AppSettings.HERBIVORE_HEALTH;
        foodType = Grass.class;
    }

    @Override
    protected void biteMyFood(Entity food) {
        if (health < AppSettings.HERBIVORE_HEALTH) {
            health++;
        }
    }
}

