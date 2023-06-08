

public class Main {
    public static void main(String[] args) {

        Persona cliente1 = new Persona("BrunoCostales", 21, "Puerto", "43509132", "Programador");
        Persona cliente2 = new Persona("BrunoCostales", 21, "Puerto", "43509133", "Programador");
        Persona cliente3 = new Persona("BrunoCostales", 21, "Puerto", "43509134", "Programador");
        Persona cliente4 = new Persona("BrunoCostales", 21, "Puerto", "43509135", "Programador");
        Persona cliente5 = new Persona("BrunoCostales", 21, "Puerto", "43509136", "Programador");
        Persona cliente6 = new Persona("BrunoCostales", 21, "Puerto", "43509137", "Programador");


        Vacunacion SistemaVacunacionJunio = new Vacunacion();
        SistemaVacunacionJunio.agendarPersonaenFila(cliente1);
        SistemaVacunacionJunio.agendarPersonaenFila(cliente2);
        SistemaVacunacionJunio.agendarPersonaenFila(cliente3);
        SistemaVacunacionJunio.agendarPersonaenFila(cliente4);
        SistemaVacunacionJunio.atenderPersona(cliente1);
        SistemaVacunacionJunio.atenderPersona(cliente2);
        SistemaVacunacionJunio.atenderPersona(cliente3);
        SistemaVacunacionJunio.atenderPersona(cliente4);
        SistemaVacunacionJunio.testearPersonas();
        SistemaVacunacionJunio.chequearYAislar();
        SistemaVacunacionJunio.cargarEmfermos();



    }
}










