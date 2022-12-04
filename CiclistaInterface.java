import java.util.List;

public interface CiclistaInterface {
    /**
     * Devuelve el atributo nombre de la clase Ciclista
     *
     * @return El atributo nombre del Ciclista
     */
    public String getNombreCiclista();

    /**
     * Asigna un nombre al Ciclista
     *
     * @param nombreCiclista Nombre que se le va asignar al Ciclista
     */
    public void setNombreCiclista(String nombreCiclista);

    /**
     * Devuelve la bicibleta de cada Ciclista
     *
     * @return La bicicleta del Ciclista
     */
    public Bicicleta getBicicleta();

    /**
     * Asigna una bicicleta al Ciclista
     *
     * @param bicicleta Bicicleta que se le va asignar al Ciclista
     */
    public void setBicicleta(Bicicleta bicicleta);

    /**
     * Devuelve la habilidad de cada Ciclista
     *
     * @return El atributo habilidad del Ciclista
     */
    public Habilidad getHabilidad();

    /**
     * Asigna una habilidad al Ciclista
     *
     * @param habilidad Habilidad que se le va asignar al Ciclista
     */
    public void setHabilidad(Habilidad habilidad);

    /**
     * Devuelve la energia de cada Ciclista
     *
     * @return El atributo energia del Ciclista
     */
    public double getEnergia();

    /**
     * Asigna una energia al Ciclista
     *
     * @param energia Energia que se le va asignar al Ciclista
     */
    public void setEnergia(double energia);

    /**
     * Devuelve la lista de resultados que tenemos del Ciclista
     *
     * @return La lista con los resultados
     */
    public List<Resultado> getResultados();

    /**
     * Asigna a la lista de resultados del Ciclista
     *
     * @param resultados La lista resultados que se va asignar al Ciclista
     */
    public void setResultados(List<Resultado> resultados);

    /**
     * Devuelve el equipo de cada Ciclista
     *
     * @return El equipo del Ciclista
     */
    public Equipo getEquipo();

    /**
     * Asigna un equipo al Ciclista
     *
     * @param equipo Equipo que se le va asignar al Ciclista
     */
    public void setEquipo(Equipo equipo);

    /**
     * Devuelve el tiempo necesario de una etapa
     *
     * @return El tiempo de la etapa
     */
    public double getTiempoEtapa();

    /**
     * Asigna el tiempo necesario a una etapa
     *
     * @param tiempoEtapa Tiempo necesario que se va a asignar a cada ciclista en una etapa
     */
    public void setTiempoEtapa(double tiempoEtapa);

    /**
     * Devuelve el valor numérico de la habilidad del ciclista
     *
     * @return el valor de la habilidad
     */
    public double getValorHabilidad();

    /**
     * Gestiona y proporciona informacion sobre el resultado obtenido en cualquier etapa
     *
     * @param etapa Etapa de la que se obtiene la información
     * @return El resultado del ciclista en cada etapa
     */
    public Resultado getResultado(Etapa etapa);

    /**
     * Comprobar si el ciclista ha abandonado o no
     *
     * @return Abandona o no
     */
    public boolean comprobarAbandono();

    /**
     * Devuelve el total de etapas en la que ha participado el Ciclista
     *
     * @return El número de etapas
     */
    public double getTotalEtapas();

    /**
     * Devuelve el número de etapas que ha completado
     *
     * @return El número de etapas terminadas
     */
    public double getEtapasTerminadas();

    /**
     * Devuelve el tiempo que ha tardado en terminar una etapa
     *
     * @return El tiempo en terminar una etapa
     */
    public double getTiempoTerminadas();

    /**
     * Devuelve en que etapa ha terminado
     *
     * @return Etapa en la que finaliza
     */
    public Etapa getEtapaAbandonada();

    /**
     * Devuelve si el ciclsita abandona o no la etapa
     *
     * @return true o false
     */
    public boolean resultadoEtapaAbandono(Etapa etapa);

    /**
     * Devuelve el valor de la destreza de los ciclista, dependiendo del tipo de ciclista
     *
     * @return el valor de la destreza
     */
    public abstract double Destreza();


    /**
     * Obtiene el tiempo que ha necesitado para terminar una etapa
     *
     * @param tiempo El tiempo con el que inicia
     * @param etapa  La etapa en la que se encuentra
     */
    public void participar(double tiempo, Etapa etapa);

    /**
     * En este método se realiza las diferentes competiciones de los ciclistas en las diferentes etapas
     */
    public void correr(Etapa etapa);

}
