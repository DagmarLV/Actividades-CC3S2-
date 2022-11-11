package ArchivosPregunta1;
import java.util.*;
import java.util.function.Consumer;

public class Mainremove {

    public static void remove(List<Character> chars) {
        char end = 'z';//los valores de start y end pueden ser cambiados convenientemente

        //el siguiente código hace uso también de una expresion lambda para mostrar los valores de la lista
        //tampoco genera un error de compilación
        System.out.println("Código agregado antes: ");
        chars.forEach(i -> System.out.print(i+" "));
        //si inicializariamos c o start, ahí sí tendríamos un error

        chars.removeIf(c -> {
            char start = 'a';
            return start <= c && c <= end; }
        );
        //end='y'; //esto si generará un error de compilación

        //el código insertado a continuación evalua si la cadena quedó vacia para lanzar un mensaje de que así fue
        //y en caso contrario, también lo señala
        //no genera ningún error de complación

        String aclaracion = (chars.isEmpty())?"\nLa cadena se encuentra vacía":"\nLa cadena no se encuetra vacía";
        System.out.println("\nCódigo agregado despues: "+aclaracion);
    }

    public static void main(String[] args) {
        System.out.println("Lista a ser eliminada segun un límite start y end");
        //para probar que el metodo funciona
        //considere una lista con al menos un elemento
        List<Character> charlista=new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'f', 'g','x','y','z'));
        System.out.println("Antes: "+Arrays.toString(charlista.toArray())); //muestra la lista antes
        remove(charlista);//al aplicar la función a la lista
        System.out.println("Despues: "+Arrays.toString(charlista.toArray()));//muestra la lista despues de la funcion

    }

}