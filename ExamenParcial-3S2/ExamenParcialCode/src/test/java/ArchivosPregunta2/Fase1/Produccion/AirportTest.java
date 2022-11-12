package ArchivosPregunta2.Fase1.Produccion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {

    //EconomyFlightTest es una clase de prueba anidada (@Nested)  y gracias
    // a @DisplayName entendemos que se da cuando hay un vuelo económico
    @DisplayName("Dado que hay un vuelo economico")
    @Nested
    class EconomyFlightTest {
    //Declara un vuelo económico y lo inicializa antes de la ejecución de cada
    //prueba
        private Flight economyFlight; //acá se declara un objeto economyFlight del tipo Flight para representar
                                      //un vuelo económico

        //Antes de cada ejecución de una prueba, se inicializa el objeto con un id 1, indicando que es un vuelo económico
        @BeforeEach
        void setUp() {
            economyFlight = new Flight("1", "Economico");
        }


        //Este prueba el funcionamiento cuando hay un pasajero regular, o sea que no es vip
        @Test
        public void testEconomyFlightRegularPassenger() {
            Passenger jessica = new Passenger("Jessica", false);//se crea un pasajero jessica como regular

            assertEquals("1", economyFlight.getId());//verifica que el id de economyFlight sea 1
            assertEquals(true, economyFlight.addPassenger(jessica));//verifica que pueda agregar a ese pasajero creado y tras hacerlo
            assertEquals(1, economyFlight.getPassengersList().size());//verifica que lo agregó pues la lista debe tener un tamaño de 1
            assertEquals("Jessica", economyFlight.getPassengersList().get(0).getName());//verifica que, efectivamente, el nombre del pasajero
                                                                                                // añadido sea correspondiente al de jessica

            assertEquals(true, economyFlight.removePassenger(jessica));//verifica que puede retirar a jessica del vuelo y tras hacerlo
            assertEquals(0, economyFlight.getPassengersList().size());//verifica que ya no se encuentre en la lista, siendo el tamaño 0
        }

        //Este prueba el funcionamiento cuando hay un pasajero vip
        @Test
        public void testEconomyFlightVipPassenger() {
            Passenger cesar = new Passenger("Cesar", true);//se crea un pasajero cesar como vip

            assertEquals("1", economyFlight.getId());//verifica que el id de economyFlight sea 1
            assertEquals(true, economyFlight.addPassenger(cesar));//verifica que pueda agregar a ese pasajero creado y tras hacerlo
            assertEquals(1, economyFlight.getPassengersList().size());//verifica que lo agregó pues la lista debe tener un tamaño de 1
            assertEquals("Cesar", economyFlight.getPassengersList().get(0).getName());//verifica que, efectivamente, el nombre del pasajero
                                                                                              // añadido sea correspondiente al de cesar

            assertEquals(false, economyFlight.removePassenger(cesar));//verifica que no le es posible retirar a cesar del vuelo y tras hacerlo
            assertEquals(1, economyFlight.getPassengersList().size());//verifica que todavia se encuentre en la lista
        }
    }
    //BusinessFlightTest es una clase de prueba anidada (@Nested)  y gracias
    // a @DisplayName entendemos que se da cuando hay un vuelo de negocios
    @DisplayName("Dado que hay un vuelo de negocios")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;//acá se declara un objeto businessFlight del tipo Flight para representar
                                      //un vuelo de negocios

        //Antes de cada ejecución de una prueba, se inicializa el objeto con un id 2, indicando que es un vuelo de negocios
        @BeforeEach
        void setUp() {
            businessFlight = new Flight("2", "Negocios");
        }

        //Este prueba el funcionamiento cuando hay un pasajero regular, o sea que no es vip
        @Test
        public void testBusinessFlightRegularPassenger() {
            Passenger jessica = new Passenger("Jessica", false);//se crea un pasajero jessica como regular

            assertEquals(false, businessFlight.addPassenger(jessica));//verifica que no pueda agregar a ese pasajero creado y tras hacerlo
            assertEquals(0, businessFlight.getPassengersList().size());//verifica que la accion no haya tenido efecto, siendo el tamaño de la lista 0
            assertEquals(false, businessFlight.removePassenger(jessica));//verifica que el intento de remover al pasajero tampoco sea permitido
            assertEquals(0, businessFlight.getPassengersList().size());//verifica que la accion tampoco haya tenido efecto, dejando el tamaño de la lista en 0

        }
        //Este prueba el funcionamiento cuando hay un pasajero vip
        @Test
        public void testBusinessFlightVipPassenger() {
            Passenger cesar = new Passenger("Cesar", true);//se crea un pasajero cesar como vip

            assertEquals(true, businessFlight.addPassenger(cesar));//verifica que pueda agregar a ese pasajero creado y tras hacerlo
            assertEquals(1, businessFlight.getPassengersList().size());//verifica que lo agregó pues la lista debe tener un tamaño de 1
            assertEquals(false, businessFlight.removePassenger(cesar));//verifica que no le es posible retirar a cesar del vuelo y tras hacerlo
            assertEquals(1, businessFlight.getPassengersList().size());//verifica que todavia se encuentre en la lista

        }
    }
}
