package business.entities;

public class Playlist {
    private final String name;
    private final String owner;

    public Playlist(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }
}
