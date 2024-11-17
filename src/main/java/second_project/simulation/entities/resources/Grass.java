package second_project.simulation.entities.resources;

import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;
import second_project.simulation.entities.Entity;

public class Grass extends Entity {

//    public Grass() {
//        this.name = "Grass";
//        this.img = String.valueOf(ConsolePics.GRASS.getPic());
//    }

    public Grass(Coordinates coordinates) {
        super(coordinates);
        this.name = "Grass";
        this.img = String.valueOf(ConsolePics.GRASS.getPic());
    }
}
