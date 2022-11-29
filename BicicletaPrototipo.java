public class BicicletaPrototipo extends BicicletaNormal {

    public BicicletaPrototipo(String nombreBicicleta, Peso peso) {
        super(nombreBicicleta, peso);
    }

    public double calcularTiempoNecesario(Etapa etapa, Ciclista ciclista) {
        return (double) Math.round((etapa.getValorDistancia() / this.calcularVelocidad(ciclista, etapa) * ciclista.Destreza()) * 100) / 100;
    }

    public String getTipo() {
        return "BicicletaPrototipo";
    }


}
