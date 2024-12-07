package second_project.simulation.actions.foodFinder;

import second_project.simulation.Coordinates;

public class NodeOnMapBFS {
    private final NodeOnMapBFS parent;
    private final Coordinates coordinates;

    public NodeOnMapBFS(NodeOnMapBFS parent, Coordinates coordinates) {
        this.parent = parent;
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public NodeOnMapBFS getParent() {
        return parent;
    }
}
