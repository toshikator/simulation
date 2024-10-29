package second_project.simulation.entities.resources;

import second_project.simulation.ConsolePics;

public class Rock extends Resource {
    public Rock() {
        this.name = "Rock";
        this.img = String.valueOf(ConsolePics.ROCK.getPic());
    }
}
