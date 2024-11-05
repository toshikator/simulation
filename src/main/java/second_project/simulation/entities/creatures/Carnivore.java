package second_project.simulation.entities.creatures;

import second_project.simulation.AppConstants;
import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;
import second_project.simulation.map.Map;

public class Carnivore extends Creature {
    private final Integer strength;

    public Carnivore(Map map) {
        super(map);
        this.name = "Carnivore";
        this.img = String.valueOf(ConsolePics.CARNIVORE.getPic());
        this.speed = AppConstants.carnivoreSpeed;
        this.health = AppConstants.carnivoreHealth;
        this.strength = AppConstants.carnivoreStrength;
    }

    public void biteCreatureOnCoordinate(Coordinates coordinates) {
        ((Creature) map.getEntityByCoordinates(coordinates)).getDamage(this.strength);
    }
}
