package ArchivosPregunta1;
import java.util.function.*;

 public class Panda {
 int age;
 public static void main(String[] args) {
         Panda p1 = new Panda();
         p1.age = 1; //si cambiasemos por un 6, sale not match
         //caso inicial, salida: match
         check(p1, p -> p.age < 5);
         //probando con lo siguiente saldra not match
         //check(p1, p -> p.age < 1);

         }
 private static void check(Panda panda, Predicate<Panda> pred) {
        String result =
          pred.test(panda)?"match":"not match";
         System.out.print(result);
         }

 }
