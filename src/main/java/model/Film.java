package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    private int id;
    private String name;
    private int numberTicketAvailable;
    private double price;

    public boolean hasEnoughTicket(int cont) {
        return numberTicketAvailable>=cont;
    }
    public void reducingTicket (int cont){
        numberTicketAvailable -= cont;
    }
}