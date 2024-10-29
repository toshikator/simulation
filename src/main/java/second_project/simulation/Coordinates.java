package second_project.simulation;

import java.util.Objects;

public class Coordinates {
    public final Integer abscissa; //x
    public final Integer ordinate; //y

    public Coordinates(Integer abscissa, Integer ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;
        return abscissa.equals(that.abscissa) && ordinate.equals(that.ordinate);
    }

    @Override
    public int hashCode() {
        int result = abscissa.hashCode();
        result = 31 * result + ordinate.hashCode();
        return result;
    }
}
