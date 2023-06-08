import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.annotation.IncompleteAnnotationException;
import java.util.*;

public class Vacunacion extends  Throwable {

    private LinkedHashSet<Persona> Cola;
    private HashMap<String,RegistroPersonaTesteada> Testeos;
    private ArrayList<Persona> Sanos;
    private ArrayList<Infectado> Emfermos;
    private Integer reactivosDelDia = (Integer) new Random().nextInt(10);

    public Vacunacion() {
        Cola = new LinkedHashSet<>();
        Testeos= new HashMap<>();
        Sanos=new ArrayList<>();
        Emfermos=new ArrayList<>();
    }

    public void agendarPersonaenFila(Persona p) {

        try {
            if (Cola.contains(p)) {
                throw new IllegalArgumentException();
            } else {

                Cola.add(p);

            }
            System.out.println("Se agendo correctamente");
        } catch (IllegalArgumentException e) {

            System.out.println("No se registro en la cola, el usuario ya existe");
        }


    }

    public Boolean chequeoDeKit() {
        Boolean flag = true;

        if (this.reactivosDelDia == 0) {
            flag = false;
        }

        return flag;
    }

    public void atenderPersona(Persona p) {

        try {
            System.out.println("Chequeando Stock de vacunas...");
            if (!(chequeoDeKit())) {
                throw new miExcepcionKit("Error no se encuentran kits disponibles");
            }

            System.out.println("Se atendio correctamente a la persona");
            p.setNumeroDeKitAsignado("Abc" + new Random().nextInt(25) + "AR");
        } catch (miExcepcionKit e) {
            System.out.println(e.getMessage() + ". Intente nuevamente se solicitaron 10 nuevos Kits");
            this.reactivosDelDia += 10;


        } catch (IllegalArgumentException e) {

            e.printStackTrace();
            System.out.println("Esta persona no esta registrada en el REGISTRO DE LAS PERSONAS");

        }

    }

    public void testearPersonas() {

        for (Persona cliente : Cola) {
            int temperatura = new Random().nextInt(3) + 36;
            RegistroPersonaTesteada r = new RegistroPersonaTesteada(cliente.getDni(), (Integer) temperatura);


            Testeos.put(cliente.getNumeroDeKitAsignado(), r);

        }



    }


    public void chequearYAislar() {
        int i=0;
        String barrio="" ;
        Persona sana=null;
        Infectado personaEmferma= new Infectado();


        try {

            for (Map.Entry<String,RegistroPersonaTesteada> elemento: Testeos.entrySet()) {
                RegistroPersonaTesteada r = elemento.getValue();
                personaEmferma.setKit(elemento.getKey());
                i++;
                for (Persona sospechoso:Cola ) {
                    if (sospechoso.getDni().equals(r.getDni())){
                        barrio=sospechoso.getBarrio().toString();
                        sana=sospechoso;
                    }

                }

                if (r.getTemp() >=38) {
                    personaEmferma.setBarrio(barrio);
                    personaEmferma.setTemp(r.getTemp());

                    Emfermos.add(personaEmferma);

                    throw new miExcepcionTemperatura("Testeo Numero: "+i+" BARRIO :"+barrio+"   POSITIVO DE COVID");
                }else{
                    Sanos.add(sana);
                }
            }

        } catch (miExcepcionTemperatura e) {

            System.out.println( e.getMessage());

        }


    }
    public void mostrarColaPendiente (){
        for (Persona clientes:Cola ) {
            System.out.println(clientes.toString());
        }
    }
    public  void cargarEmfermos(){

        try (FileInputStream inpu = new FileInputStream("Urgente.dat");
             ObjectInputStream objeto = new ObjectInputStream(inpu)) {


            ArrayList<Infectado> listaInfectados = (ArrayList<Infectado>) objeto.readObject();


            for (Infectado persona : Emfermos) {
                System.out.println(persona.toString());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }





    }

    public void mostrarEmfermos(){
        for (int i = 0; i < Emfermos.size(); i++) {
            System.out.println(Emfermos.get(i).toString());

        }
    }
    public  void mostrarSanos(){
        for (int i = 0; i < Sanos.size(); i++) {
            System.out.println(Sanos.get(i).toString());

        }
    }
    public void mostrarTesteos(){
        for (Map.Entry elementos: Testeos.entrySet() ) {
            System.out.println("Key: "+elementos.getKey()+"  Valor: "+elementos.getKey());
        }

    }
    public void pasaraJSON(){

        HashMap<String, Object> objetoJson = new HashMap<>();
        objetoJson.put("Sanos", Sanos);
        objetoJson.put("Emfermos", Emfermos);

        ObjectMapper objectMapper = new ObjectMapper();
        String json="";
        try {
            json = objectMapper.writeValueAsString(objetoJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        try (FileWriter fileWriter = new FileWriter("Archivo.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
}
