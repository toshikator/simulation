package second_project.simulation.entities.creatures;

import second_project.simulation.AppConstants;
import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;

import second_project.simulation.entities.Entity;
import second_project.simulation.entities.FoodTypesForCreatures;
import second_project.simulation.entities.resources.Grass;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        this.img = String.valueOf(ConsolePics.HERBIVORE.getPic());
        this.speed = AppConstants.HERBIVORE_SPEED;
        this.health = AppConstants.HERBIVORE_HEALTH;
        this.foodType = Grass.class;
    }

    @Override
    protected void eatMyFood(Entity food) {

    }
}

