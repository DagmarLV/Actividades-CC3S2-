package ArchivosPregunta2.Fase2.Produccion;
public class EconomyFlight extends Flight {//ahora EconomyFlight extiende a Flight
    //crea al constructor que llama al constructor de la superclase
    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    //para añadir a un pasajero, por ser economico, sin evaluar ninguna restricción
    public boolean addPassenger(Passenger passenger) {
        return passengers.add(passenger);
    }

    @Override
    //para retir a un pasajero, pero agrega la restricción para que los pasajeros vip no puedan ser retirados
    public boolean removePassenger(Passenger passenger) {
        if (!passenger.isVip()) {
            return passengers.remove(passenger);
        }
        return false;
    }

}
