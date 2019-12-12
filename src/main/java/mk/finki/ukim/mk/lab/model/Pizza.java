package mk.finki.ukim.mk.lab.model;

public class Pizza {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pizza(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s ( %s )", name, description);
    }
}
