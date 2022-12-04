/**
 * BicicletaPrototipo es una subclase de Bicicleta el cuál es una bicicleta normal pero tiene una diferencia que es, que calcula el tiempo necesario
 * utilizando la destreza de cada  ciclista, dependerá del tipo de ciclsita
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class BicicletaPrototipo extends BicicletaNormal {

    /**
     * Constructor por parámetros de la clase BicicletaPrototipo
     */
    public BicicletaPrototipo(String nombreBicicleta, Peso peso) {
        super(nombreBicicleta, peso);
    }

    /**
     * Calcula el tiempo necesario (en minutos) para terminar la etapa cuando es usada por un ciclista en particular en una etapa en concreto,
     * teniendo en cuenta que utiliza la destreza de cada ciclista
     *
     * @param etapa    Etapa de la que se usa su distancia
     * @param ciclista Ciclista que se usa para calcular la velocidad (anteriormente calculada)
     * @return El tiempo necesario para terminar una etapa
     */
    @Override
    public double calcularTiempoNecesario(Etapa etapa, Ciclista ciclista) {
        double destreza = ciclista.Destreza();
        double velocidad = calcularVelocidad(ciclista, etapa);
        return (double) Math.round((etapa.getValorDistancia() / (velocidad * destreza)) * 100) / 100;
    }


}
