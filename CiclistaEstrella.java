public class CiclistaEstrella extends Ciclista {
    private int SerPopular;

    public CiclistaEstrella(String nombreCiclista, Habilidad habilidad, double energia, Equipo equipo) {
        super(nombreCiclista, habilidad, energia, equipo);
        this.SerPopular = 6;
    }

    @Override
    public double Destreza() {
        //destreza = (((habilidad del Ciclista + 6) / 140) * 10;
        return (double) (((getValorHabilidad() + 6.0) / 140) * 10);
    }

    public int getSerPopular() {
        return SerPopular;
    }

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

    public String toString() {
        return super.toString() + " <popularidad: " + getSerPopular() + ">";
    }

}
