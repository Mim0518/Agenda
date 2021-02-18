import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class file extends IOException{
    public file(){
    }
    public ArrayList<Persona> obtenerDeArchivo(){
        ArrayList<Persona> a = new ArrayList<>();
        String csvFile = "personas.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
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

