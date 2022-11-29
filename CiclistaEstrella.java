public class CiclistaEstrella extends Ciclista {
    private int SerPopular;

    public CiclistaEstrella(String nombreCiclista, Habilidad habilidad, double energia, Equipo equipo) {
        super(nombreCiclista, habilidad, energia, equipo);
        this.SerPopular = 6;
    }

    public double Destreza() {
        //destreza = (((habilidad del Ciclista + 6) / 140) * 10;
        return (double) Math.round((((super.getValorHabilidad() + 6) / 140) * 10) * 100) / 100;
    }

    public String getTipo() {
        return "CiclistaEstrella";
    }

    public int getSerPopular() {
        return SerPopular;
    }

    public void setSerPopular(int serPopular) {
        SerPopular = serPopular;
    }

    public int popularidad(int serPopular) {
        if (getTotalEtapas() < 1)
            return serPopular = 6;
        else if (super.getTiempoEtapa() < 160.0)
            return serPopular += 4;
        else return serPopular -= 1;

    }

    public String toString() {
        return super.toString() + " <popularidad: " + popularidad(getSerPopular()) + ">";
    }

}
