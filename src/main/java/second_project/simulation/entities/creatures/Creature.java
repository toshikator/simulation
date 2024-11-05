package second_project.simulation.entities.creatures;

import second_project.simulation.Coordinates;
import second_project.simulation.entities.Entity;
import second_project.simulation.map.Map;

import java.util.HashSet;
import java.util.Set;

public abstract class Creature extends Entity {
    protected final Map map;
    public boolean IsDead;
    protected Integer speed;
    protected Integer health;

    protected Creature(Map map) {
        this.map = map;
        IsDead = false;
    }

    public void getDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            dead();
        }
    }

    public void dead() {
        this.IsDead = true;
    }

    public Set<Coordinates> getAvailableMoveCoordinates() {
        Set<Coordinates> availableMoveCoordinates = new HashSet<>();

        for (int i = -this.getCoordinates().abscissa; i < this.getCoordinates().abscissa; i++) {
            for (int j = -this.getCoordinates().ordinate; j < this.getCoordinates().ordinate; j++) {
                if (Math.abs(i) + Math.abs(j) <= this.speed) {
                    Coordinates possibleCoordinates = new Coordinates(i, j);
                    if (map.isCoordinateOnMap(possibleCoordinates) && map.isCoordinateEmpty(possibleCoordinates)) {
                        availableMoveCoordinates.add(possibleCoordinates);
                    }
                }
            }
        }
        return availableMoveCoordinates;
    }
}
