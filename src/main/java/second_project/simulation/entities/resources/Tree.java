package second_project.simulation.entities.resources;

import second_project.simulation.ConsolePics;
import second_project.simulation.entities.Entity;

public class Tree extends Entity {
    public Tree() {
        this.name = "Tree";
        this.img = String.valueOf(ConsolePics.TREE.getPic());
    }
}
