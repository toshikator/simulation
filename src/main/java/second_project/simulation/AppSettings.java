package second_project.simulation;

public final class AppSettings {

    public final static int TREES_AMOUNT = 17;
    public final static int GRASS_AMOUNT = 17;
    public final static int CARNIVORE_AMOUNT = 15;
    public final static int HERBIVORE_AMOUNT = 22;
    public final static int CARNIVORE_SPEED = 3;
    public final static int HERBIVORE_SPEED = 6;
    public final static int CARNIVORE_HEALTH = 15;
    public final static int HERBIVORE_HEALTH = 25;
    public final static int CARNIVORE_STRENGTH = 3;
    public final static int GAME_TURNS = 70;
    public final static int WORLD_WIDTH = 20;
    public final static int WORLD_HEIGHT = 20;
    public final static int ROCKS_AMOUNT = 17;

    private AppSettings() {
        System.out.println("Entities for AppConstants are not allowed");
    }
}
