package second_project.simulation.entities.resources;

import second_project.simulation.ConsolePics;

public class Tree extends Resource {
    public Tree() {
        this.name = "Tree";
        this.img = String.valueOf(ConsolePics.TREE.getPic());
    }
}
