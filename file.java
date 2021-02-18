import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class file extends IOException{
    public file(){
    }
    //Obtiene los datos de las personas desde del archivo CSV indicado
    public ArrayList<Persona> obtenerDeArchivo(){
        ArrayList<Persona> a = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader("personas.csv"));
            while((line = br.readLine()) != null){
                String [] datos = line.split(cvsSplitBy);
                Persona p = new Persona(datos[0], datos[1], datos[2], datos[3]);
                a.add(p);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(br != null){
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return a;
    }

    public void ponerEnArchivo(ArrayList listaPersonas) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("personas.csv"));
        try {
            for(int i = 0; i < listaPersonas.size(); i++){
                Persona p = (Persona)(listaPersonas.get(i));
                bw.write(p.toString());
                bw.write("\n");
            }
            bw.close();
        }catch (IOException e) {
            //TODO: handle exception
        }
    }

    public int buscaPersona(ArrayList p, JComboBox b){
        String cad = (String)(b.getSelectedItem());
        int indice = 0;
        for (int i = 0; i < p.size(); i++){
            Persona a = (Persona)(p.get(i));
            if (cad.equals(a.getNombre() + " " + a.getApellidos())){
                indice = i;
                break;
            }
        }
        return indice;		
    }
}

