package models;

public class DestinationDTO {

    private int id_destination;
    private String name;
    private String description;

    public int getId_destination() {
        return id_destination;
    }

    public void setId_destination(int id_destination) {
        this.id_destination = id_destination;
    }

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
}
