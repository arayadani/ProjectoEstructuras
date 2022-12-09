/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenfinal.proyectocolas;

/**
 *
 * @author ridia
 */
public class Persona {
    
     private String nombre;
    private String numeroTarjeta;
    private String pin;
    private String saldo;
    private Persona Next;

    public Persona(String nombre, String numeroTarjeta, String pin, String saldo) {
        this.nombre = nombre;
        this.numeroTarjeta = numeroTarjeta;
        this.pin = pin;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public Persona getNext() {
        return Next;
    }

    public void setNext(Persona Next) {
        this.Next = Next;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", numeroTarjeta=" + numeroTarjeta + ", pin=" + pin + ", saldo=" + saldo + '}';
    }

   
    
    
    
}
