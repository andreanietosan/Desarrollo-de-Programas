import java.util.ArrayList;
import java.util.List;

/**
 * En la clase CiclistaInterface se encuentra toda la información de esta
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public abstract class Ciclista implements CiclistaInterface {
    private String nombreCiclista;
    private Bicicleta bicicleta;
    private Habilidad habilidad;
    private double energia;
    private List<Resultado> resultados;
    private Equipo equipo;
    private double tiempoEtapa;

    /**
     * Constructor para objetos de la clase Ciclista
     *
     * @param nombreCiclista Nombre del ciclista
     * @param habilidad      Habilidad que tiene cada ciclista
     * @param energia        Energia que tiene cada ciclista
     * @param equipo         Equipo al que pertenece cada ciclista
     */
    public Ciclista(String nombreCiclista, Habilidad habilidad, double energia, Equipo equipo) {
        this.nombreCiclista = nombreCiclista;
        this.habilidad = habilidad;
        this.energia = energia;
        resultados = new ArrayList<Resultado>();
        this.equipo = equipo;
        tiempoEtapa = -1;
    }

    public String getNombreCiclista() {
        return nombreCiclista;
    }

    public void setNombreCiclista(String nombreCiclista) {
        this.nombreCiclista = nombreCiclista;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public double getEnergia() {
        return (double) Math.round(energia * 100) / 100;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public double getTiempoEtapa() {
        return tiempoEtapa;
    }

    public void setTiempoEtapa(double tiempoEtapa) {
        this.tiempoEtapa = tiempoEtapa;
    }

    public double getValorHabilidad() {
        return getHabilidad().getValor();
    }

    public Resultado getResultado(Etapa etapa) {
        Resultado res = null;
        boolean enc = false;
        int i = 0;
        while (i < resultados.size() && !enc) {
            if (resultados.get(i).getEtapa().equals(etapa)) {
                res = resultados.get(i);
                enc = true;
            }
            i++;
        }
        return res;
    }

    public boolean comprobarAbandono() {
        boolean abandono = false;
        if (energia <= 0.0)
            abandono = true;
        return abandono;
    }

    public double getTotalEtapas() {
        return resultados.size();
    }

    public double getEtapasTerminadas() {
        double terminadas = 0;
        for (Resultado res : resultados) {
            if (res.isEtapaTerminada())
                terminadas++;
        }
        return terminadas;
    }

    public double getTiempoTerminadas() {
        double tiempo = 0;
        for (Resultado res : resultados) {
            if (res.isEtapaTerminada())
                tiempo += res.getTiempo();
        }
        return (double) Math.round(tiempo * 100) / 100;
    }

    public Etapa getEtapaAbandonada() {
        Etapa etapa = null;
        Resultado ultimo = resultados.get(resultados.size() - 1);

        if (!ultimo.isEtapaTerminada())
            etapa = ultimo.getEtapa();
        return etapa;
    }

    public boolean resultadoEtapaAbandono(Etapa etapa) {
        boolean contiene = false;
        int i = 0;
        while (i < resultados.size() && !contiene) {
            if (resultados.get(i).getEtapa().getNombreEtapa().equals(etapa.getNombreEtapa()))
                contiene = true;
            i++;
        }
        return contiene;
    }


    public abstract double Destreza();


    public void participar(double tiempo, Etapa etapa) {
        if (energia >= 0.0) {
            double energiaRestante = energia - tiempo;
            boolean terminada = true;
            if (energiaRestante < 0) {
                terminada = false;
                tiempo = (double) Math.round(energiaRestante * 100) / 100;
            }
            Resultado nuevo = new Resultado(etapa, tiempo, terminada);
            resultados.add(nuevo);
            energia = energiaRestante;
        }
    }

    public void correr(Etapa etapa) {

        System.out.print(toString());
        System.out.println(" con bicicleta");
        System.out.print(getBicicleta().toString());
        double tiempoEmpleado = getEnergia();
        System.out.println(" en etapa " + etapa.getNombreEtapa());
        System.out.println("+++ Con estas condiciones el ciclista " + getNombreCiclista() + " con la bicicleta " + getBicicleta().getNombreBicicleta() + " alcanza una velocidad de " + getBicicleta().calcularVelocidad(this, etapa) + " km/hora +++");

        if (getEnergia() > getTiempoEtapa())
            System.out.println("+++ " + getNombreCiclista() + " termina la etapa en " + getTiempoEtapa() + " minutos +++");
        participar(getTiempoEtapa(), etapa);

        if (tiempoEmpleado < getTiempoEtapa()) {
            System.out.println("¡¡¡ El ciclista " + getNombreCiclista() + " se quedó sin energia a falta de " + getEnergia() + " minutos para terminar !!!");
            System.out.println("¡¡¡ En el momento de quedarse sin energia llevaba en carrera " + tiempoEmpleado + " minutos !!!");
        }
        System.out.println("+++ La energía del ciclista " + getNombreCiclista() + " tras la carrera es " + getEnergia() + " +++");
        System.out.println("@@@");
    }

    /**
     * Muestra en una cadena los atributos del ciclista
     *
     * @return Un string con los atributos y características principales del ciclista
     */
    public String toString() {
        return "<" + getClass().getName() + ":" + getNombreCiclista() + "> <energía:" + getEnergia() + "> <habilidad:" + getHabilidad() + "> <tiempo acumulado sin abandonar:" + getTiempoTerminadas() + "> <abandonado:" + comprobarAbandono() + ">";
    }


}
