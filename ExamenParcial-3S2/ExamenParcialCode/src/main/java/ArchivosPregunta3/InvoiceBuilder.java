package ArchivosPregunta3;

public class InvoiceBuilder {
    //Los atributos tienen valores ya preestablecidos
    private String country = "NL";
    private CustomerType customerType = CustomerType.PERSON;
    private double value = 500;

    //Los atributos pueden ser modificados gracias a que el constructor contiene
    //varios métodos que lo permiten

    public InvoiceBuilder withCountry(String country) {
        this.country = country;
        return this;
    }
    public InvoiceBuilder asCompany() {
        this.customerType = CustomerType.COMPANY;
        return this;
    }
    public InvoiceBuilder withAValueOf(double value) {
        this.value = value;
        return this;
    }
    //El constructor construye una instancia de Invoice con los datos necesarios
    public Invoice build() {
        return new Invoice(value, country, customerType);
    }
    //ahora se agregan las funciones para la pregunta 5
    public Invoice anyCompany() {
        return new Invoice(value, country, CustomerType.COMPANY);
    }
    public Invoice fromTheUS() {
        return new Invoice(value,"US", customerType);
    }

}
