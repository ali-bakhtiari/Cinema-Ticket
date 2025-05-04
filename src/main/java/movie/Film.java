package movie;
import lombok.Getter;
@Getter
public class Film {
    private String name;
    private int numberTicketAvailable;
    private double price;
    public Film(String name, int numberTicketAvailable, double price) {
        this.name = name;
        this.numberTicketAvailable = numberTicketAvailable;
        this.price = price;
    }
    public boolean hasEnoughTicket(int cont) {
        return numberTicketAvailable>=cont;
    }
    public void reducingTicket (int cont){
        numberTicketAvailable -= cont;
    }
}
