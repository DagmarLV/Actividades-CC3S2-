package ArchivosPregunta2.Fase2.Produccion;
public class BusinessFlight extends Flight {//ahora BusinessFlight extiende a Flight
    //crea al constructor que llama al constructor de la superclase
    public BusinessFlight(String id) {
        super(id);
    }

    @Override
    //para añadir a un pasajero, por ser de negocios, evalúa que el pasajero sea vip para hacerlo
    public boolean addPassenger(Passenger passenger) {
        if (passenger.isVip()) {
            return passengers.add(passenger);
        }
        return false;
    }

    @Override
    //por lógica de negocio, no permite que pueda ser retirado ningún pasajero
    public boolean removePassenger(Passenger passenger) {
        return false;
    }

}
