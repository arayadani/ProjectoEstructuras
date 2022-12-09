/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenfinal.proyectocolas;

/**
 *
 * @author ridia
 */
public class Cajero2 {
    
    private Persona inicio;
    private Persona termino;

    public Cajero2() {
        this.inicio = null;
        this.termino = null;
    }

    public void Encola(String nombre, String numeroTarjeta, String pin, String saldo) {

        Persona i = new Persona(nombre, numeroTarjeta, pin, saldo);
        i.setNext(null);
//        System.out.println(i);

        if (this.inicio == null & this.termino == null) {

            this.inicio = i;
            this.termino = i;
        }
        this.termino.setNext(i);
        this.termino = this.termino.getNext();

    }

    public Persona Desencola() {
        Persona persona = this.inicio;
        inicio = inicio.getNext();
        return persona;
        
    }

    public boolean estaVacio() {
        boolean bandera = false;

        if (this.inicio == null & this.termino == null) {

            bandera = true;
        }

        return bandera;
    }

    public int Size() {
        int contador = 0;
                
         Persona c = this.inicio;
         while(c != null){
        contador++;
        c = c.getNext();
    }
        
        return contador;
    

   }
    
}
