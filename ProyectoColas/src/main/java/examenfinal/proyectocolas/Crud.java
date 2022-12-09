/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenfinal.proyectocolas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author ridia
 */
public class Crud {
     private Persona persona;

    private ArrayList<Persona> arrPersonas = new ArrayList<>();


    public ArrayList<Persona> getArrPersonas() {
        return arrPersonas;
    }

    public void setArrPersonas(ArrayList<Persona> arrPersonas) {
        this.arrPersonas = arrPersonas;
    }

   
 

    public void cargarArchivo() throws IOException {

     
        BufferedReader br = new BufferedReader(new FileReader("Contactos.txt"));
        String inf;
        String[] n = null;

        while ((inf = br.readLine()) != null) {
            n = inf.split(",");

            persona = new Persona(n[0], n[1], n[2], n[3]);
//            arrPersonas.add(persona);
            addToArray(persona);

        }
//      for (int i = 0; i < getArrPersonas().size(); i++) {
//            out.println(getArrPersonas().get(i).getNombre());
//        }

    }

    public void escribirArchivo() throws IOException {

        FileWriter fichero = null;
        PrintWriter pw = null;

        File newfile = new File("Contactos.txt");
        newfile.delete();
        fichero = new FileWriter("Contactos.txt");
        pw = new PrintWriter(fichero);

        for (int i = 0; i < arrPersonas.size(); i++) {

            pw.println(arrPersonas.get(i).getNombre() + ","
                    + arrPersonas.get(i).getNumeroTarjeta()+ ","
                    + arrPersonas.get(i).getPin()+ ","
                    + arrPersonas.get(i).getSaldo());

        }
        pw.close();
        fichero.close();

    }

    private void overWrite() throws IOException {

        cargarArchivo();
    }

    public void nuevaPersona(String pNombre, String pTarjeta, String pPin, String pSaldo) {

        persona = new Persona(pNombre, pTarjeta, pPin, pSaldo);
        addToArray(persona);

//        for (int i = 0; i < getArrPersonas().size(); i++) {
//            out.println(getArrPersonas().get(i));
//        }
    }

    private void addToArray(Persona pNuevaPersona) {
        arrPersonas.add(pNuevaPersona);
    }

    
}
