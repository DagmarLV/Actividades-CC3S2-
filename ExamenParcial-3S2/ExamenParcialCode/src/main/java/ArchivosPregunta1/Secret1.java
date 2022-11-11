package ArchivosPregunta1;
import java.util.function.*;

interface Secret {
    public String magic(double d);
}

class Secret1 implements Secret{
    public String magic(double d) {
        return "Poof";
    }

    public static void main(String[] args) {
        Secret1 s1= new Secret1();
        String magicclass=s1.magic(2);

        Secret primerlambda = d -> "Poof";//expresión lambda que reemplaza a la clase magic
        Secret segundolambda =(d) ->{return "Poof";};//esto también lo puede reemplazar
        Secret tercerlambda = (d) -> { String f = ""; return "Poof"; };

        System.out.println("Con la clase magic normal: "+magicclass); //aca mostramos el retorno con la clase magic
        //mostramos los demas retornos con las lambdas
        System.out.println("Con primer lambda: "+ primerlambda.magic(4));
        System.out.println("Con segundo lambda: "+ segundolambda.magic(4));
        System.out.println("Con tercer lambda: "+ tercerlambda.magic(4));
    }


}