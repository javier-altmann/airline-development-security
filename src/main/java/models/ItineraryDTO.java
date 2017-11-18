package models;

public class ItineraryDTO {

    private int id_itinerary;
    private int cost_ticket;
    private int id_from_destination;
    private int id_to_destination;

    public int getId_itinerary() {
        return id_itinerary;
    }

    public void setId_itinerary(int id_itinerary) {
        this.id_itinerary = id_itinerary;
    }

    public int getCost_ticket() {
        return cost_ticket;
    }

    public void setCost_ticket(int cost_ticket) {
        this.cost_ticket = cost_ticket;
    }

    public int getId_from_destination() {
        return id_from_destination;
    }

    public void setId_from_destination(int id_from_destination) {
        this.id_from_destination = id_from_destination;
    }

    public int getId_to_destination() {
        return id_to_destination;
    }

    public void setId_to_destination(int id_to_destination) {
        this.id_to_destination = id_to_destination;
    }
}
