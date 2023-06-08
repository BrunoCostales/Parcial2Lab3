import java.util.Objects;

public class Persona {

    private String nombreyApellido;
    private Integer edad;
    private String barrio;
    private String dni;
    private String ocupacion;
    private  String numeroDeKitAsignado=null;

    public Persona(String nombreyApellido, Integer edad, String barrio, String dni, String ocupacion) {
        this.nombreyApellido = nombreyApellido;
        this.edad = edad;
        this.barrio = barrio;
        this.dni = dni;
        this.ocupacion = ocupacion;
    }

    public String getNombreyApellido() {
        return nombreyApellido;
    }

    public void setNombreyApellido(String nombreyApellido) {
        this.nombreyApellido = nombreyApellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getNumeroDeKitAsignado() {
        return numeroDeKitAsignado;
    }

    public void setNumeroDeKitAsignado(String numeroDeKitAsignado) {
        this.numeroDeKitAsignado = numeroDeKitAsignado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return dni.equals(persona.dni);
    }


    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombreyApellido='" + nombreyApellido + '\'' +
                ", edad=" + edad +
                ", barrio='" + barrio + '\'' +
                ", dni='" + dni + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }


}
