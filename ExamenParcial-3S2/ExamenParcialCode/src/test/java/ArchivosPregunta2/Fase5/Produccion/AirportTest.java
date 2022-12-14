package ArchivosPregunta2.Fase5.Produccion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @DisplayName("Dado que hay un vuelo economico")
    @Nested
    class EconomyFlightTest {
        //declaramos las siguientes variables para que al momento de utilizar un nivel de prueba más
        //se pueda reutilizar estos campos para todas las pruebas de esta clase
        private Flight economyFlight;
        private Passenger jessica;
        private Passenger cesar;

        @BeforeEach
            //inicializamos las variables antes de la ejecución de cada prueba
        void setUp() {
            economyFlight = new EconomyFlight("1");
            jessica = new Passenger("Jessica", false);
            cesar = new Passenger("Cesar", true);
        }
        //aca añadimos un nivel de prueba más para los 2 tipos de pasajeros: regulares y vip
        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Entonces puede agregarlo y eliminarlo de un vuelo economico")
            public void testEconomyFlightRegularPassenger() {
                //ahora se hace uso de un assertAll para probar todas condiciones
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(jessica)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet())
                                    .get(0).getName().equals("Jessica")),
                        () -> assertEquals(true, economyFlight.removePassenger(jessica)),
                        () -> assertEquals(0, economyFlight.getPassengersSet().size())
                );
            }

            @RepeatedTest(3)//Podemos hacer uso de una prueba repetida
            @DisplayName("Entonces este no puede ser añadido más de una vez")

            public void testEconomyFlightRegularPassengerAddOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(jessica);
                }

                assertAll("Verifica las condiciones para agregar solamente una vez un pasajero regular a un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),//verificamos que es el vuelo economico
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),//vemos que el tamaño sea solo 1
                        () -> assertTrue(economyFlight.getPassengersSet().contains(jessica)),//que el set contenga a jessica
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()) //que el nombre corresponda a Jessica
                                .get(0).getName().equals("Jessica"))
                );
            }


        }



        //De forma similar que en EconomyFlightTest
        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {
            @Test
            @DisplayName("Luego puedes agregarlo pero no puede eliminarlo de un vuelo economico")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(cesar)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet())
                                        .get(0).getName().equals("Cesar")),
                        () -> assertEquals(false, economyFlight.removePassenger(cesar)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size())
                );

            }
        }



    }


    @DisplayName("Dado que hay un vuelo de negocios")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger jessica;
        private Passenger cesar;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            jessica = new Passenger("Jessica", false);
            cesar = new Passenger("Cesar", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Entonces no puede agregarlo o eliminarlo de un vuelo de negocios")
            public void testBusinessFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo de negocios",
                        () -> assertEquals(false, businessFlight.addPassenger(jessica)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(jessica)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {

            @Test
            @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo de negocios")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo de negocios",
                        () -> assertEquals(true, businessFlight.addPassenger(cesar)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(cesar)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size())
                );
            }
        }
    }

    // Completa la prueba para PremiumFlight de acuerdo a la logica comercial dada. Pregunta 8

    @DisplayName("Dado que hay un vuelo premium")
    @Nested
    class PremiumTest {//declaramos la clase anidada para probar el tipo de vuelo premium
        //en general, usaremos la misma lógica que se usó para implementar las anteriores
        //clases anidadas
        private Flight premiumFlight;
        private Passenger jessica;
        private Passenger cesar;
        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("3");
            jessica = new Passenger("Jessica", false);
            cesar = new Passenger("Cesar", true);
        }
        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Entonces no puede agregarlo o eliminarlo de un vuelo premium")
            public void testPremiumFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo premium",
                        () -> assertEquals(false, premiumFlight.addPassenger(jessica)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size()),
                        () -> assertEquals(false, premiumFlight.removePassenger(jessica)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {

            @Test
            @DisplayName("Entonces puedes agregarlo o puedes eliminarlo de un vuelo de premium")
            public void testPremiumFlightVipPassenger() {

                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                        () -> assertEquals("3", premiumFlight.getId()),
                        () -> assertEquals(true, premiumFlight.addPassenger(cesar)),
                        () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                        () -> assertTrue(new ArrayList<>(premiumFlight.getPassengersSet())
                                        .get(0).getName().equals("Cesar")),
                        () -> assertEquals(true, premiumFlight.removePassenger(cesar)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size())
                );
            }
        }


    }

}