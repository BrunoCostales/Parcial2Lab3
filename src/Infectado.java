public class Infectado {
    private String  kit;
    private Integer temp;
    private String barrio;


    public Infectado() {
        this.kit = null;
        this.temp = null;
        this.barrio = null;
    }
    public Infectado(String kit, Integer temp, String barrio) {
        this.kit = kit;
        this.temp = temp;
        this.barrio = barrio;
    }

    public String getKit() {
        return kit;
    }

    public void setKit(String kit) {
        this.kit = kit;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
}
