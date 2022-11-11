package ArchivosPregunta1;
import java.util.*;
import java.util.function.Function;

interface Climb {
 public boolean isTooHigh(int height, int limit);
 }

 class Climber implements Climb{
     public boolean isTooHigh(int height, int limit){
         boolean result;
         return result =(height <= limit)?false:true;
     }

 public static void main(String[] args) {
         Climber a= new Climber();
         check( a, 5);
         //los parámetros h y m son del tipo int y append trabaja con Strings
         // check((h, m) -> h.append(m).isEmpty(), 5); //error de compilación se encuentra comentado para que el programa corra de todos modos

     //en caso "trabajaramos" con el tipo StringBuilder tampoco se permitiria aun sea convertido a String con
     //toString() para usar isEmpty() ya que no es conveniente usar tipos en una expresion lambda cuando se ya especifican implícitamente
         //check( (StringBuilder h, int m) -> h.append(m).toString().isEmpty(), 5);

     }


 private static void check(Climb climb, int height) {

         if (climb.isTooHigh(height, 10))
             System.out.println("too high");

         else
            System.out.println("ok");
         }

 }