public class RegistroPersonaTesteada {
    private String  dni;
    private Integer  temp;

    public RegistroPersonaTesteada(String dni, Integer temp) {
        this.dni = dni;
        this.temp = temp;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }
}
