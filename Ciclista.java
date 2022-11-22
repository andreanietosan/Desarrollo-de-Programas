import java.util.ArrayList;
import java.util.List;

/**
 * En la clase Ciclista se encuentra toda la información de esta
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Ciclista {
    private String nombreCiclista;
    private Bicicleta bicicleta;
    private double habilidad;
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
    public Ciclista(String nombreCiclista, double habilidad, double energia, Equipo equipo) {
        this.nombreCiclista = nombreCiclista;
        this.habilidad = habilidad;
        this.energia = energia;
        resultados = new ArrayList<Resultado>();
        this.equipo = equipo;
        tiempoEtapa = -1;
    }

    /**
     * Devuelve el atributo nombre de la clase Ciclista
     *
     * @return El atributo nombre del Ciclista
     */
    public String getNombreCiclista() {
        return nombreCiclista;
    }

    /**
     * Asigna un nombre al Ciclista
     *
     * @param nombreCiclista Nombre que se le va asignar al Ciclista
     */
    public void setNombreCiclista(String nombreCiclista) {
        this.nombreCiclista = nombreCiclista;
    }

    /**
     * Devuelve la bicibleta de cada Ciclista
     *
     * @return La bicicleta del Ciclista
     */
    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    /**
     * Asigna una bicicleta al Ciclista
     *
     * @param bicicleta Bicicleta que se le va asignar al Ciclista
     */
    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    /**
     * Devuelve la habilidad de cada Ciclista
     *
     * @return El atributo habilidad del Ciclista
     */
    public double getHabilidad() {
        return habilidad;
    }

    /**
     * Asigna una habilidad al Ciclista
     *
     * @param habilidad Habilidad que se le va asignar al Ciclista
     */
    public void setHabilidad(double habilidad) {
        this.habilidad = habilidad;
    }

    /**
     * Devuelve la energia de cada Ciclista
     *
     * @return El atributo energia del Ciclista
     */
    public double getEnergia() {
        return (double) Math.round(energia * 100) / 100;
    }

    /**
     * Asigna una energia al Ciclista
     *
     * @param energia Energia que se le va asignar al Ciclista
     */
    public void setEnergia(double energia) {
        this.energia = energia;
    }

    /**
     * Devuelve la lista de resultados que tenemos del Ciclista
     *
     * @return La lista con los resultados
     */
    public List<Resultado> getResultados() {
        return resultados;
    }

    /**
     * Asigna a la lista de resultados del Ciclista
     *
     * @param resultados La lista resultados que se va asignar al Ciclista
     */
    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    /**
     * Devuelve el equipo de cada Ciclista
     *
     * @return El equipo del Ciclista
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Asigna un equipo al Ciclista
     *
     * @param equipo Equipo que se le va asignar al Ciclista
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Devuelve el tiempo necesario de una etapa
     *
     * @return El tiempo de la etapa
     */
    public double getTiempoEtapa() {
        return tiempoEtapa;
    }

    /**
     * Asigna el tiempo necesario a una etapa
     *
     * @param tiempoEtapa Tiempo necesario que se va a asignar a cada ciclista en una etapa
     */
    public void setTiempoEtapa(double tiempoEtapa) {
        this.tiempoEtapa = tiempoEtapa;
    }

    /**
     * Gestiona y proporciona informacion sobre el resultado obtenido en cualquier etapa
     *
     * @param etapa Etapa de la que se obtiene la información
     * @return El resultado del ciclista en cada etapa
     */
    public Resultado getResultado(Etapa etapa) {
        Resultado res = null;
        int i = 0;
        while (i < resultados.size() && resultados.get(i).getEtapa() != etapa)
            i++;
        if (resultados.get(i).getEtapa() == etapa)
            res = resultados.get(i);
        return res;
    }

    /**
     * Comprobar si el ciclista ha abandonado o no
     *
     * @return Abandona o no
     */
    public boolean comprobarAbandono() {
        boolean abandono = false;
        if (energia <= 0.0)
            abandono = true;
        return abandono;
    }

    /**
     * Devuelve el total de etapas en la que ha participado el Ciclista
     *
     * @return El número de etapas
     */
    public double getTotalEtapas() {
        return resultados.size();
    }

    /**
     * Devuelve el número de etapas que ha completado
     *
     * @return El número de etapas terminadas
     */
    public double getEtapasTerminadas() {
        double terminadas = 0;
        for (Resultado res : resultados) {
            if (res.isEtapaTerminada())
                terminadas++;
        }
        return terminadas;
    }

    /**
     * Devuelve el tiempo que ha tardado en terminar una etapa
     *
     * @return El tiempo en terminar una etapa
     */
    public double getTiempoTerminadas() {
        double tiempo = 0;
        for (Resultado res : resultados) {
            if (res.isEtapaTerminada())
                tiempo += res.getTiempo();
        }
        return (double) Math.round(tiempo * 100) / 100;
    }

    /**
     * Devuelve en que etapa ha terminado
     *
     * @return Etapa en la que finaliza
     */
    public Etapa getEtapaAbandonada() {
        Etapa etapa = null;
        Resultado ultimo = resultados.get(resultados.size() - 1);

        if (!ultimo.isEtapaTerminada())
            etapa = ultimo.getEtapa();
        return etapa;
    }

    /**
     * Obtiene el tiempo que ha necesitado para terminar una etapa
     *
     * @param tiempo El tiempo con el que inicia
     * @param etapa  La etapa en la que se encuentra
     */
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

    /**
     * Muestra en una cadena los atributos del ciclista
     *
     * @return Un string con los atributos y características principales del ciclista
     */
    public String toString() {
        return "<ciclista:" + getNombreCiclista() + "> <energía:" + getEnergia() + "> <habilidad:" + getHabilidad() + "> <tiempo acumulado sin abandonar:" + getTiempoTerminadas() + "> <abandonado:" + comprobarAbandono() + ">";
    }


}
