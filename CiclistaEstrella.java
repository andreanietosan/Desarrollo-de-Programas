/**
 * Clase dedicada al CiclistaEstrella, subclase de Ciclista, el cuál se diferencia de los demás a través de su forma de calcular la destreza,
 * esta clase además se caracteriza porque tiene un extra que es SerPopular, el cuál, caracteriza al ciclistaEstrella por su popularidad
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class CiclistaEstrella extends Ciclista {
    private int SerPopular;

    /**
     * Constructor por parámetros de la clase CiclistaEstrella
     */
    public CiclistaEstrella(String nombreCiclista, Habilidad habilidad, double energia, Equipo equipo) {
        super(nombreCiclista, habilidad, energia, equipo);
        this.SerPopular = 6;
    }

    @Override
    public double Destreza() {
        return (double) Math.round((((getValorHabilidad() + 6.0) / 140) * 10) * 100) / 100;
    }

    /**
     * Devuelve el valor de popularidad del ciclistaEstrella
     *
     * @return valor popularidad
     */
    public int getSerPopular() {
        return SerPopular;
    }

    /**
     * Asigna el valor de la popularidad al ciclistaEstrella
     *
     * @param serPopular valor de la popularidad
     */
    public void setSerPopular(int serPopular) {
        SerPopular = serPopular;
    }

    @Override
    public void correr(Etapa etapa) {
        super.correr(etapa);

        if (getTotalEtapas() < 1)
            SerPopular = 6;
        else if (super.getTiempoEtapa() < 160.0) {
            SerPopular += 4;
            System.out.println("+++ La popularidad del ciclista " + getNombreCiclista() + " ha aumentado y ahora su nivel de popularidad es de: " + getSerPopular() + " unidades\n" + "@@@");
        } else {
            SerPopular -= 1;
            System.out.println("--- La popularidad del ciclista " + getNombreCiclista() + " ha disminuido y ahora su nivel de popularidad es de: " + getSerPopular() + " unidades\n" + "@@@");
        }
    }

    /**
     * Muestra en una cadena los atributos del ciclistaEstrella
     *
     * @return Un string con los atributos y características principales del ciclsitaEstrella
     */
    public String toString() {
        return super.toString() + " <popularidad: " + getSerPopular() + ">";
    }

}
