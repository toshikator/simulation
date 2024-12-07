package second_project.simulation.actions.pathfinder;

import second_project.simulation.Coordinates;

import java.util.Objects;

public class NodeOnMapAStar implements Comparable<NodeOnMapAStar> {
    private final Coordinates coordinates;
    private Integer costFromStart;
    private Integer costToFinish;
    private NodeOnMapAStar parent;

    public NodeOnMapAStar(Coordinates coordinates, NodeOnMapAStar parent) {
        this.coordinates = coordinates;
        this.parent = parent;
    }

    public NodeOnMapAStar(Coordinates coordinates) {
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

    public NodeOnMapAStar getParent() {
        return parent;
    }

    public void setParent(NodeOnMapAStar parent) {
        this.parent = parent;
    }

    public Integer getCost() {
        return costFromStart + costToFinish;
    }

    @Override
    public int compareTo(NodeOnMapAStar other) {
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

        return Objects.equals(this.coordinates.abscissa, ((NodeOnMapAStar) o).coordinates.abscissa) && Objects.equals(this.coordinates.ordinate, ((NodeOnMapAStar) o).coordinates.ordinate);
    }
}
