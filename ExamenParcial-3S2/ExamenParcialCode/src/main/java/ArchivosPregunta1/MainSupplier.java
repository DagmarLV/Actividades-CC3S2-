package ArchivosPregunta1;
import java.util.function.*;
public class MainSupplier {
    public static void main(String[] args) {
        int length = 3;
        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                Supplier<Integer> supplier = () -> length; // A lambda expression
                System.out.println(supplier.get()); // B
            } else {
                int j = i;
                Supplier<Integer> supplier = () -> j; // C lambda expression
                System.out.println(supplier.get()); // D
            }
        }
    }
}
