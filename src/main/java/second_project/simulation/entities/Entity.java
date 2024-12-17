package second_project.simulation.entities;

import second_project.simulation.Coordinates;

abstract public class Entity {
    protected String img;
    protected Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getImg() {
        return img;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
