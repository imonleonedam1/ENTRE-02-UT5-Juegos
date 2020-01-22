/**
 * Un objeto de esta clase guarda información relativa a un juego
 * 
 * @author -
 */
public class Juego {
    private static final String SEPARADOR = ":";
    private String titulo;
    private Genero genero;
    private int year;
    private int[] valoraciones;

    /**
     *  Inicializa los atributos a partir de la información recibida
     *  Esta información se encuentra en linea
     */
    public Juego(String linea) {
        String[] datos = linea.split(SEPARADOR);
        for(int i = 0; i < datos.length; i++) {
            datos[i] = datos[i].trim();
        }
        titulo = datos[0].toUpperCase();
        genero = Genero.valueOf(datos[1].toUpperCase());
        year = Integer.valueOf(datos[2]);
        valoraciones = new int[10];
        for (int i = 0; i < valoraciones.length; i++) {
            valoraciones[i] = Integer.valueOf(datos [i + 3]);
        }
    }

    /**
     * accesor título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * accesor género
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * accesor year
     */
    public int getYear() {
        return year;
    }

    /**
     * accesor valoraciones
     */
    public int[] getValoraciones() {
        return valoraciones;
    }

    /**
     * total votos emitidos
     */
    public int getVotos() {
        int aux = 0;
        for (int i = 0; i < valoraciones.length; i++) {
            aux += valoraciones[i];
        }
        return aux;
    }

    /**
     *  obtener valoración media
     */
    public double getValoracionMedia() {
        int aux = 0;
        for (int i = 0; i < valoraciones.length; i++) {
            aux += valoraciones[i] * (i + 1);
        }
        return (double)aux/getVotos();
    }

    /**
     *  Un usuario puntúa el juego con un valor entre 1 y 10 
     */
    public void puntuar(int puntuacion) {
        valoraciones[puntuacion - 1]++; 
    }

    /**
     * Representación textual del juego 
     * (Ver enunciado)
     */
    public String toString() {
        return titulo + "\nGénero: " + this.genero +
        "| Lanzamiento: " + this.year +
        "\nValoración (" + getVotos() + " votos): "
        + String.format("%.2f", this.getValoracionMedia());
    }

    public static void main(String[] args) {
        Juego juego1 = new Juego(
                "Steep: deporte: 2016  : 0:0:0:0: 0: 0:0:0:12:  10");
        System.out.println(juego1.toString());

        Juego juego2 = new Juego(
                "For the King: estrategia: 2018  : 0:0:0:7: 12: 0:33:13:2: 0");
        System.out.println(juego2.toString());

    }
}
