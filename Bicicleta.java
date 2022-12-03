public interface Bicicleta {
    public String getNombreBicicleta();

    /**
     * Asigna un nombre a la Bicicleta
     *
     * @param nombreBicicleta Nombre que se le va asignar a la Bicicleta
     */
    public void setNombreBicicleta(String nombreBicicleta);

    /**
     * Devuelve el atributo peso de la clase Bicicleta
     *
     * @return El atributo peso de la Bicicleta
     */
    public Peso getPeso();

    /**
     * Asigna un peso a la Bicicleta
     *
     * @param peso Peso que se le va asignar a la Bicicleta
     */
    public void setPeso(Peso peso);

    public double getValorPeso();

    /**
     * Calcula la velocidad que es usada por un ciclista en particular en una etapa en concreto
     *
     * @param ciclista Ciclista del que se usa su habilidad
     * @param etapa    Etapa de la que se usa la dificultad
     * @return La velocidad calculada
     */
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa);

    /**
     * Calcula el tiempo necesario (en minutos) para terminar la etapa cuando es usada por un ciclista en particular en una etapa en concreto
     *
     * @param etapa    Etapa de la que se usa su distancia
     * @param ciclista Ciclista que se usa para calcular la velocidad (anteriormente calculada)
     * @return El tiempo necesario para terminar una etapa
     */
    public double calcularTiempoNecesario(Etapa etapa, Ciclista ciclista);


}
