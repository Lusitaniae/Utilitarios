package utilitarios;

/** 
 * Representa um tempo através da hora, minuto e segundo.
 * @author ISEP-DEI-PPROG
 */
public class Tempo {

    /**
     * A hora do tempo.
     */  
    private int hora;

    /**
     * Os minutos do tempo.
     */ 
    private int minuto;

    /**
     * Os segundos do tempo.
     */ 
    private int segundo;

    /**
     * Constrói uma instância de Tempo recebendo a hora, minutos e segundos    
     * @param hora    a hora do tempo
     * @param minuto  os minutos do tempo
     * @param segundo os segundos do tempo
     */
    public Tempo(int hora, int minuto, int segundo) {        
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;  
    }

    /**
     * Constrói uma instância de Tempo recebendo a hora e os minutos e assumindo
     * os segundos 0.
     */
    public Tempo(int hora, int minuto) {
        this(hora, minuto, 0);
    }

    /**
     * Constrói uma instância de Tempo recebendo a hora e assumindo os minutos 0
     * e os segundos 0.
     */
    public Tempo(int hora) {
        this(hora, 0, 0);
    }

    /**
     * Constrói uma instância de Tempo com a hora 0, minutos 0 e segundos 0.  
     */
    public Tempo() {
        this(0, 0, 0);
    }

    /**
     * Constrói uma instância de Tempo com as mesmas caraterísticas do tempo
     * recebido por parâmetro.     
     * @param outroTempo o tempo com as características a copiar
     */ 
    public Tempo(Tempo outroTempo) {
        this(outroTempo.getHora(), outroTempo.getMinuto(),
                outroTempo.getSegundo());        
    }

    /**
     * Devolve a hora do tempo.
     * @return hora do tempo
     */
    public int getHora() {
        return this.hora;
    }

    /**
     * Devolve os minutos do tempo.
     * @return minutos do tempo
     */
    public int getMinuto() {
        return this.minuto;
    }

    /**
     * Devolve os segundos do tempo.
     * @return segundos do tempo
     */
    public int getSegundo() {
        return this.segundo;
    }

    /**
     * Modifica a hora do tempo.
     * @param hora a nova hora do tempo 
     */ 
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Modifica os minutos do tempo.
     * @param minuto os novos minutos do tempo
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * Modifica os segundos do tempo.
     * @param segundo os novos segundos do tempo
     */
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    /**
     * Modifica a hora, os minutos e os segundos do tempo.
     * @param hora    a nova hora do tempo
     * @param minuto  os novos minutos do tempo
     * @param segundo os novos segundos do tempo
     */ 
    public void setTempo(int hora, int minuto, int segundo) {
        this.hora = hora;               
        this.minuto = minuto;         
        this.segundo = segundo;        
    }

    /**
     * Devolve a descrição textual do tempo no formato: %02d:%02d:%02d AM/PM.
     * @return caraterísticas do tempo
     */
    public String toString() {
        return String.format("%02d:%02d:%02d %s",
                (this.hora == 12 || this.hora == 0) ? 12 : this.hora % 12,
                this.minuto, this.segundo, this.hora < 12 ? "AM" : "PM");
    }

    /**
     * Devolve o tempo no formato: %02d%02d%02d.
     * @return caraterísticas do tempo
     */
    public String toStringHHMMSS() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto,
                this.segundo);
    }

    /**
     * Compara o tempo com o objeto recebido.
     * 
     * @param outroObjeto o objeto a comparar com o tempo
     * @return true se o objeto recebido representar outro tempo equivalente
     *         ao tempo. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Tempo outroTempo = (Tempo) outroObjeto;
        return this.hora == outroTempo.hora && this.minuto == outroTempo.minuto
                && this.segundo == outroTempo.segundo;
    }

    /**
     * Aumenta o tempo em um segundo    
     */
    public void tick() {
        this.segundo = ++this.segundo % 60;
        if (this.segundo == 0) {
            this.minuto = ++this.minuto % 60;
            if (this.minuto == 0) {
                this.hora = ++this.hora % 24;
            }
        }
    }

    /**
     * Devolve o número de segundos correspondente ao tempo
     * @return número de segundos correspondente ao tempo
     */
    private int segundos() {
        return this.hora * 3600 + this.minuto * 60 + this.segundo;
    }

    /**
     * Devolve true se o tempo for maior do que o tempo recebido por parâmetro.  
     * Se o tempo for menor ou igual ao tempo recebido por parâmetro, devolve
     * false.
     * @param outroTempo o outro tempo com o qual se compara o tempo
     * @return true se o tempo for maior do que o tempo recebido por parâmetro,
     * caso contrário devolve false
     */
    public boolean isMaior(Tempo outroTempo) {
        return segundos() > outroTempo.segundos();
    }

    /*
     * Solução alternativa 
     * public boolean isMaior(Tempo outroTempo){ 
     *      if ( this.hora > outroTempo.hora || 
     *          (this.hora==outroTempo.hora && this.minuto>outroTempo.minuto) || 
     *          (this.hora==outroTempo.hora && this.minuto==outroTempo.minuto &&
     *           this.segundo > outroTempo.segundo) ) 
     *         return true;
     *      return false;
     * }
     */

    /**
     * Devolve true se o tempo for maior do que o tempo (hora, minutos e
     * segundos) recebido por parâmetro. Se o tempo for menor ou igual ao tempo
     * (hora, minutos e segundos) recebido por parâmetro, devolve false.
     * @param hora    a outra hora do tempo com o qual se compara o tempo
     * @param minuto  os outros minutos do tempo com o qual se compara o tempo
     * @param segundo os outros segundos do tempo com o qual se compara o tempo
     * @return true se o tempo for maior do que o tempo (hora, minutos e
     *         segundos) recebido por parâmetro, caso contrário devolve false
     */   
    public boolean isMaior(int hora, int minuto, int segundo) {
        Tempo outroTempo = new Tempo(hora,minuto,segundo);
        return segundos() > outroTempo.segundos();        
    }   

    /**
     * Devolve a diferença em segundos entre o tempo e o tempo recebido por
     * parâmetro.  
     * @param outroTempo o outro tempo com o qual se compara o tempo para
     *        calcular a diferença em segundos
     * @return diferença em segundos entre o tempo e o tempo recebido por
     *         parâmetro
     */
    public int diferencaEmSegundos(Tempo outroTempo) {
        return Math.abs(segundos() - outroTempo.segundos());
    }

    /**
     * Devolve uma instância Tempo representativa da diferença entre o tempo e o
     * tempo recebido por parâmetro.
     * @param outroTempo o outro tempo com o qual se compara o tempo para obter
     *        uma instãncia Tempo representativa da diferença entre o tempo e o
     *        tempo recebido por parâmetro
     * @return instância Tempo representativa da diferença entre o tempo e o
     *         tempo recebido por parâmetro
     */
    public Tempo diferencaEmTempo(Tempo outroTempo) {
        int dif = diferencaEmSegundos(outroTempo);
        int s = dif % 60;
        dif = dif / 60;
        int m = dif % 60;
        int h = dif / 60;
        return new Tempo(h, m, s);
    }

}
