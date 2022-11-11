package ArchivosPregunta2.Anterior.Produccion;
public class Airport {
//clase principal, esta asocia a las clases Flight y Passenger
    public static void main(String[] args) {
    //se crean dos objetos del tipo vuelo y se asigna a uno como economico y a otro de negocios
        Flight economyFlight = new Flight("1", "Economico");
        Flight businessFlight = new Flight("2", "Negocios");
    //se crean dos objetos del tipo pasajero y gracias al constructor se asocia a Cesar como vip y a Jessica como regular
        Passenger cesar = new Passenger("Cesar", true);
        Passenger jessica = new Passenger("Jessica", false);

        businessFlight.addPassenger(cesar);//se añade a cesar en el vuelo de negocios por ser vip
        businessFlight.removePassenger(cesar);// se trata de retirar a Cesar del vuelo de negocio, pero esto no es permitido por la politica de eliminación
        businessFlight.addPassenger(jessica);// se trata de añadir a Jessica a un vuelo de negocio, pero tampoco se le permite por ser cliente regular
        economyFlight.addPassenger(jessica);// se añade, finalmente, a Jessica a un vuelo económico

        //se muestran la lista de pasajeros registrados en cada vuelo
        System.out.println("Lista de pasajeros de vuelos de negocios:");
        for (Passenger passenger : businessFlight.getPassengersList()) {
            System.out.println(passenger.getName());
        }

        System.out.println("Lista de pasajeros de vuelos economicos:");
        for (Passenger passenger : economyFlight.getPassengersList()) {
            System.out.println(passenger.getName());
        }
    }
}
