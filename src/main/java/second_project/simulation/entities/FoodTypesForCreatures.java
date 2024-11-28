package second_project.simulation.entities;

public enum FoodTypesForCreatures {
    HerbivoreFood("Grass"),
    CarnivoreFood("Creatures");

    private final String food;

    FoodTypesForCreatures(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }
}
