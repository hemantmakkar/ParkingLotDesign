package ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TicketDAO {

    private static Map<UUID, Ticket> tickets = new HashMap<>();

    public void addTicket(UUID tId, Ticket t) { tickets.put(tId, t); }

    public Ticket getTicket(UUID id) {
        return tickets.get(id);
    }

    public Ticket removeTicket(UUID id) {
        return tickets.remove(id);
    }
}