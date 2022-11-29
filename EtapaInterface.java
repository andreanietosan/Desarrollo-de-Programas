public interface EtapaInterface {
    /**
     * Devuelve el atributo nombre de la clase Etapa
     *
     * @return El atributo nombre de la Etapa
     */
    public String getNombreEtapa();

    /**
     * Asigna un nombre a la Etapa
     *
     * @param nombreEtapa Nombre que se le va asignar a la Etapa
     */
    public void setNombreEtapa(String nombreEtapa);

    /**
     * Devuelve el atributo dificultad de la clase Etapa
     *
     * @return El atributo dificultad de la Etapa
     */
    public Dificultad getDificultad();

    /**
     * Asigna una dificultad a la Etapa
     *
     * @param dificultad Dificultad que se le va asignar a la Etapa
     */
    public void setDificultad(Dificultad dificultad);

    /**
     * Devuelve el atributo distancia de la clase Etapa
     *
     * @return El atributo distancia de la Etapa
     */
    public Distancia getDistancia();

    /**
     * Asigna una distancia a la Etapa
     *
     * @param distancia Distancia que se le va asignar a la Etapa
     */
    public void setDistancia(Distancia distancia);


    public double getValorDificultad();

    public double getValorDistancia();

}
