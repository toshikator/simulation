package second_project.simulation;

public enum ConsolePics {
    CARNIVORE("\uD83D\uDC6E"),
    HERBIVORE("\uD83E\uDD37 "),
    TREE("\uD83C\uDF33 "),
    ROCK("⛰️ "),
    GRASS("\uD83C\uDF31"),
    TILE("\uD83D\uDD32");

    private final String pic;

    ConsolePics(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }
}
