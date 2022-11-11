package ArchivosPregunta2.Anterior.Produccion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flight {
    //se crean los atributos que son el id, para identificar un vuelo
    // lista de pasajeros, que es inicializada como una lista vacía
    // y el tipo de vuelo
    private String id;
    private List<Passenger> passengers = new ArrayList<Passenger>();
    private String flightType;

    //El constructor de la clase que inicializa id y flightType
    //el atributo passengers es modificado por add y remove passenger
    public Flight(String id, String flightType) {
        this.id = id;
        this.flightType = flightType;
    }

    //getters para cada uno de los atributos
    public String getId() {
        return id;
    }
    public List<Passenger> getPassengersList() {
        return Collections.unmodifiableList(passengers);
    }

    public String getFlightType() {
        return flightType;
    }



    public boolean addPassenger(Passenger passenger) {
        switch (flightType) { //evalua el tipo de vuelo
            case "Economico": //en caso sea económico es posible agregar cualquier pasajero
                return passengers.add(passenger);
            case "Negocios": //en caso sea de negocios
                if (passenger.isVip()) { //primero verifica que sea vip
                    return passengers.add(passenger); //si lo es, se añade
                }
                return false; //sino, no lo agrega
            default://en caso sea una entrada de vuelo no reconocida lanza una excepción
                throw new RuntimeException("Tipo desconocido: " + flightType);// aca especifica que el tipo de vuelo ingresa no es conocido
        }

    }

    public boolean removePassenger(Passenger passenger) {
        switch (flightType) { //evalua el tipo de vuelo
            case "Economico": //en caso sea económico
                if (!passenger.isVip()) {//si es que el pasajero no es vip
                    return passengers.remove(passenger);
                }
                return false;
            case "Negocios":
                return false;
            default:
                throw new RuntimeException("Tipo desconocido: " + flightType);
        }
    }

}
