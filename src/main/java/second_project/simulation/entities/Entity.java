package second_project.simulation.entities;

import second_project.simulation.Coordinates;

abstract public class Entity {
    protected String img;
    protected String name;
    protected Coordinates coordinates;

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
