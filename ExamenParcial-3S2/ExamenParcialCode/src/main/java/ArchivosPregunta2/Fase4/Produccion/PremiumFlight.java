package ArchivosPregunta2.Fase4.Produccion;

public class PremiumFlight extends Flight {//ahora PremiumFlight extiende a Flight
    //crea al constructor que llama al constructor de la superclase
    public PremiumFlight(String id) {
        super(id);
    }

    // Diseño inicial de la clase  PremiumFlight. Pregunta 7
    @Override
    public boolean addPassenger(Passenger passenger) {
        return false;
    }
    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }

}

