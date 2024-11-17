package second_project.simulation.actions.pathfinder;

import second_project.simulation.Coordinates;

import java.util.Objects;

public class NodeOnMap implements Comparable<NodeOnMap> {
    private final Coordinates coordinates;
    private Integer costFromStart;
    private Integer costToFinish;
    private NodeOnMap parent;

    public NodeOnMap(Coordinates coordinates, NodeOnMap parent) {
        this.coordinates = coordinates;
        this.parent = parent;
    }

    public NodeOnMap(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.parent = null;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Integer getCostFromStart() {
        return costFromStart;
    }

    public void setCostFromStart(Integer costFromStart) {
        this.costFromStart = costFromStart;
    }

    public Integer getCostToFinish() {
        return costToFinish;
    }

    public void setCostToFinish(Integer costToFinish) {
        this.costToFinish = costToFinish;
    }

    public NodeOnMap getParent() {
        return parent;
    }

    public void setParent(NodeOnMap parent) {
        this.parent = parent;
    }

    public Integer getCost() {
        return costFromStart + costToFinish;
    }

    @Override
    public int compareTo(NodeOnMap other) {
        return Integer.compare(this.getCost(), other.getCost());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(coordinates.abscissa);
        result = 31 * result + Objects.hashCode(coordinates.ordinate);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return Objects.equals(this.coordinates.abscissa, ((NodeOnMap) o).coordinates.abscissa) && Objects.equals(this.coordinates.ordinate, ((NodeOnMap) o).coordinates.ordinate);
    }
}
