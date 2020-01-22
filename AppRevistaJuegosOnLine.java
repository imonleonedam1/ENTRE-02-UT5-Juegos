import java.util.Arrays;
/**
 * Punto de entrada a la aplicación
 * 
 * @author - 
 */
public class AppRevistaJuegosOnLine 
{
    public static void main(String[] args)
    {
        if (args.length != 2) { 
            System.out.println("Error en argumentos\nSintaxis: java AppRevistaJuegosOnLine <nombre> <n> \n---------------------------"
                + "-----------------------------------");
        } else {
            // Crear revista
            int aux = Integer.parseInt(args[1]);
            RevistaOnLineJuegos revista = new RevistaOnLineJuegos(args[0], aux);
            revista.leerDeFichero();
            System.out.println(revista.toString());
            // Asignar puntuaciones
            System.out.println("***************************************\nPuntuando...");
            revista.puntuar("Planet Zoo", 8);
            revista.puntuar("Steep", 7);
            revista.puntuar("Catastronauts", 9);
            revista.puntuar("Wattam", 9);
            System.out.println("\nDespués de puntuar la revista queda\n");
            System.out.println(revista.toString());
            // Valoración media superior a 8.2
            System.out.println("\n***************************************\nJuegos con valoración media > 8.2");
            System.out.println(Arrays.toString(revista.valoracionMayorQue(8.2)));
            // Borrar juegos de rol
            System.out.println("\n***************************************\nBorrando juegos de género ROL...");
            System.out.println("Borrados " + revista.borrarDeGenero(Genero.ROL) + " juegos\n");
            System.out.println(revista.toString());
        }

    }
}
