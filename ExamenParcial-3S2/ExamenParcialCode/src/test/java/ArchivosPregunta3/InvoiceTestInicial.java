package ArchivosPregunta3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.*;

class InvoiceTestInicial {
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
    void taxesForCompanyAreTaxRateMultipliedByAmount() {
        double invoiceValue = 2500.0;
        double tax = 0.1;
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