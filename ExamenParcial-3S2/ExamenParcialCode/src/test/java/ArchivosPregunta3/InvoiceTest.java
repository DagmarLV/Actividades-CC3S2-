package ArchivosPregunta3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.*;

class InvoiceTest {
    @Test
    void test1() {
        Invoice invoice = new Invoice(new BigDecimal("2500").doubleValue(),"NL",
                CustomerType.COMPANY);

        double v = invoice.calculate();

        assertThat(v).isEqualTo(250);

    }
    @Test
    @DisplayName("Dada una Compañia para obtener su facturación")
    void invoiceForCompanies() {
        Invoice invoice = new InvoiceBuilder()
                          .asCompany()
                          .withCountry("NL")
                          .withAValueOf(2500)
                          .build();

        double calculatedValue = invoice.calculate();

        assertThat(calculatedValue).isEqualTo(250); // 2500 * 0.1 = 250
    }
    @Test
    @DisplayName("Dada una Persona para obtener su facturación")
    void invoiceForPersonDefault() {
        Invoice invoice = new InvoiceBuilder().build();
        double calculatedValue = invoice.calculate();

        assertThat(calculatedValue).isEqualTo(50); // 500 * 0.1 = 50
    }
    @Test
    void invoiceForAnyCompany() {
        Invoice invoice = new InvoiceBuilder().anyCompany();
        double calculatedValue = invoice.calculate();

        assertThat(calculatedValue).isEqualTo(50); // 500 * 0.1 = 50
    }

    @Test
    void invoiceForFromTheUS() {
        Invoice invoice = new InvoiceBuilder().fromTheUS();
        double calculatedValue = invoice.calculate();

        assertThat(calculatedValue).isEqualTo(50); // 500 * 0.1 = 50
    }

    @Test
    void taxesForCompanyAreTaxRateMultipliedByAmount() {
        double invoiceValue = 2500.0;
        double tax = 0.1;// la variable
        Invoice invoice = new InvoiceBuilder()
                .asCompany()
                .withCountry("NL")
                .withAValueOf(invoiceValue)
                .build();
        double calculatedValue = invoice.calculate();
        assertThat(calculatedValue)
                .isEqualTo(invoiceValue * tax);
    }

}

