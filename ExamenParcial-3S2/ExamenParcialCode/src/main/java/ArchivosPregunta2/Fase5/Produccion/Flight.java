package ArchivosPregunta2.Fase5.Produccion;
import java.util.*;

public abstract class Flight {

    private String id;
    Set<Passenger> passengers = new HashSet<>();

    public Flight(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    //inicialmente se encuentra como getPassengerList, se cambia a set para solo añadir uno y esto
    //tiene que ser reflejado también en las pruebas
    public Set<Passenger> getPassengersSet() {
        return Collections.unmodifiableSet(passengers);
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

}
