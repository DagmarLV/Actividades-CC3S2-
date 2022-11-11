package ArchivosPregunta2.Anterior.Produccion;
public class Passenger {
    //la clase es bastante simple ha decir verdad
    //se crean los atributos que son el nombre del pasajero y un booleano que indica si es vip
    private String name;
    private boolean vip;

    //El constructor para que sus atributos sean inicializados
    public Passenger(String name, boolean vip) {
        this.name = name;
        this.vip = vip;
    }
    //getters de la clase para obtener los atributos
    public String getName() {
        return name;
    }

    public boolean isVip() {
        return vip;
    }

}
