package second_project.simulation.entities.resources;

import second_project.simulation.ConsolePics;

public class Grass extends Resource {

    public Grass() {
        this.name = "Grass";
        this.img = String.valueOf(ConsolePics.GRASS.getPic());
    }
}
