package second_project.simulation.entities.creatures;

import second_project.simulation.AppConstants;
import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;

import second_project.simulation.map.Map;

import java.util.Set;

public class Herbivore extends Creature {
    public Herbivore(Map map) {
        super(map);
        this.name = "Herbivore";
        this.img = String.valueOf(ConsolePics.HERBIVORE.getPic());
        this.speed = AppConstants.herbivoreSpeed;
        this.health = AppConstants.herbivoreHealth;
    }

    @Override
    public Set<Coordinates> getAvailableMoveCoordinates() {
        return Set.of();
    }
}

