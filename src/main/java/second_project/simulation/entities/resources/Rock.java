package second_project.simulation.entities.resources;

import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;
import second_project.simulation.entities.Entity;

public class Rock extends Entity {
//    public Rock() {
//        this.name = "Rock";
//        this.img = String.valueOf(ConsolePics.ROCK.getPic());
//    }

    public Rock(Coordinates coordinates) {
        super(coordinates);
//        this.name = "Rock";
        this.img = String.valueOf(ConsolePics.ROCK.getPic());
    }
}
