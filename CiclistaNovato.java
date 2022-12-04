public class CiclistaNovato extends Ciclista {
    public CiclistaNovato(String nombreCiclista, Habilidad habilidad, double energia, Equipo equipo) {
        super(nombreCiclista, habilidad, energia, equipo);
    }

    @Override
    public double Destreza() {
        //destreza = (((habilidad del Ciclista + 2) / 120) * 10;
        return (double) Math.round ((((getValorHabilidad() + 2.0) / 120) * 10)*100)/100;
    }

}
