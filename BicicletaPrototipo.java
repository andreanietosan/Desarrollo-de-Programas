public class BicicletaPrototipo extends BicicletaNormal {

    public BicicletaPrototipo(String nombreBicicleta, Peso peso) {
        super(nombreBicicleta, peso);
    }

    @Override
    public double calcularTiempoNecesario(Etapa etapa, Ciclista ciclista) {
        double destreza = ciclista.Destreza();
        double velocidad = calcularVelocidad(ciclista, etapa);
        return (double) Math.round((etapa.getValorDistancia() / (velocidad * destreza)) * 100) / 100;
    }


}
