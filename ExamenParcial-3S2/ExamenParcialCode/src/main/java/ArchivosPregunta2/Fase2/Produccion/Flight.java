package ArchivosPregunta2.Fase2.Produccion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Flight {//ahora se declara a la clase Flight como abstracta

    private String id;
    //Hace que la lista de pasajeros no tenga modificador, o sea, que este por defecto
    //lo que hace que sea visible sólo dentro de su propio paquete
    //o sea permite que sea heredada directamente por las subclases del mismo paquete
    List<Passenger> passengers = new ArrayList<Passenger>();
    //como vemos, ya se ha eliminado la variable flightType que estaba en la clase Flight de la Fase 1
    public Flight(String id) {
        this.id = id;
    }//constructor de la clase

    //getters para cada uno de los atributos
    public String getId() {
        return id;
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    // Ahora los métodos add y remove Passenger son abstractos
    // por lo que su implementación tendrá que ser hecha por las subclases de Flight
    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

}
