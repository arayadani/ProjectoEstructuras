/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenfinal.proyectocolas;

import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author ridia
 */
public class Banco {

    Crud cargarContactos = new Crud();
    ArrayList<Persona> personas = cargarContactos.getArrPersonas();

    Cajero1 c1 = new Cajero1();
    Cajero2 c2 = new Cajero2();

    int tarjeta = 0;
    int tarjetaDestino = 0;
    int saldo = 0;
    int pin = 0;
    boolean id = false;

    public void inicializarCrud() throws IOException {
        cargarContactos.cargarArchivo();
    }

    public void asignarCajeros() throws IOException {

        for (int i = 0; i < personas.size(); i++) {

            if (i % 2 == 0) {
                c1.Encola(personas.get(i).getNombre(), personas.get(i).getNumeroTarjeta(), personas.get(i).getPin(), personas.get(i).getSaldo());

            } else {
                c2.Encola(personas.get(i).getNombre(), personas.get(i).getNumeroTarjeta(), personas.get(i).getPin(), personas.get(i).getSaldo());
            }

        }

    }

    public boolean validarCredenciales() {

        boolean credenciales = false;
        ingresarTarjeta();
        ingresarPin();
        while (verificarPin(pin) == false) {
            JOptionPane.showMessageDialog(null, "El numero de pin es invalido");
            ingresarPin();

        } 
       credenciales = true;
        

        return credenciales;
    }

//        public boolean iniciarSesion() {
//            
//          JOptionPane.showMessageDialog(null, validarCredenciales());
//
//        if (validarCredenciales() == true) {
//            id = false;
//        }
//        return id;
//    }
//    public boolean cerrarSesion() {
//
//        if (validarCredenciales() == true) {
//            id = false;
//        }
//        return id;
//    }
    public boolean cajero1Vacio() {

        boolean c1Vacio = false;

        if (c1.estaVacio() == true) {
            c1Vacio = true;

        }
        return c1Vacio;

    }

    public boolean cajero2Vacio() {

        boolean c2Vacio = false;

        if (c2.estaVacio() == true) {
            c2Vacio = true;

        }
        return c2Vacio;

    }

    public int c1Tamanho() {
        int tamanho = 0;

        tamanho = c1.Size();
        out.println(tamanho);
        return tamanho;
    }

    public int c2Tamanho() {
        int tamanho = 0;

        tamanho = c2.Size();
        out.println(tamanho);
        return tamanho;
    }

    public Persona desencolaC1() {

        Persona p = null;

        p = c1.Desencola();

        return p;
    }

    public Persona desencolaC2() {

        Persona p = null;

        p = c2.Desencola();

        return p;
    }

    public boolean verificarPin(int pPin) {

        boolean pinValido = false;

        for (int i = 0; i < personas.size(); i++) {
            if (Integer.valueOf(personas.get(i).getPin()).equals(pPin)) {
                pinValido = true;
            }

        }

        return pinValido;
    }

    public boolean verificarTarjeta(int pTarjeta) {

        boolean existe = false;

        for (int i = 0; i < personas.size(); i++) {
            if (Integer.valueOf(personas.get(i).getNumeroTarjeta()).equals(pTarjeta)) {
                existe = true;
            }

        }
        if (existe == false) {
            JOptionPane.showMessageDialog(null, "El numero de tarjeta es invalido");
            validarCredenciales();
        }

        return existe;
    }

    public void ingresarTarjeta() {
        tarjeta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de Tarjeta"));
        verificarTarjeta(tarjeta);

    }

    public void ingresarPin() {
        pin = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de pin"));
        verificarPin(pin);

    }

    public boolean tarjetaDestinoExiste() {

        boolean existe = false;
        tarjetaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de Tarjeta"));
        for (int i = 0; i < personas.size(); i++) {
            if (Integer.valueOf(personas.get(i).getNumeroTarjeta()).equals(tarjetaDestino)) {
                existe = true;

            }

        }
        return existe;

    }

    public void consultarSaldo() {

        for (int i = 0; i < personas.size(); i++) {
            if (Integer.valueOf(personas.get(i).getNumeroTarjeta()).equals(tarjeta)) {
                saldo = Integer.valueOf(personas.get(i).getSaldo());
            }
        }

      JOptionPane.showMessageDialog(null, "El saldo de su cuenta es: " + saldo + " colones.");
    }

    /*
    Transferencia
     */
    public int consultarSaldoCuentaPrincipal() {

        for (int i = 0; i < personas.size(); i++) {
            if (Integer.valueOf(personas.get(i).getNumeroTarjeta()).equals(tarjeta)) {
                saldo = Integer.valueOf(personas.get(i).getSaldo());
            }
        }

        return saldo;

    }

    public int consultarSaldoCuentaDestino() {

        for (int i = 0; i < personas.size(); i++) {
            if (Integer.valueOf(personas.get(i).getNumeroTarjeta()).equals(tarjetaDestino)) {
                saldo = Integer.valueOf(personas.get(i).getSaldo());
            }
        }
        return saldo;

    }

    public void deposito() throws IOException {

        int nuevoSaldo = 0;

//        if (iniciarSesion() == true) {
            int montoDeposito = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el monto a depositar"));

            for (int i = 0; i < personas.size(); i++) {

                if (Integer.valueOf(personas.get(i).getNumeroTarjeta()).equals(tarjeta)) {

                    saldo = Integer.valueOf(personas.get(i).getSaldo());

                    nuevoSaldo = saldo + montoDeposito;

                    personas.get(i).setSaldo(String.valueOf(nuevoSaldo));

//                    out.println(personas.get(i).getSaldo());
                    cargarContactos.escribirArchivo();

                    JOptionPane.showMessageDialog(null, "El deposito ha sido completado");

                }
            }

//        }

    }

    public void retiro() throws IOException {

        int nuevoSaldo = 0;

//        if (iniciarSesion() == true) {
            int montoRetiro = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el monto a retirar"));

            if (consultarSaldoCuentaPrincipal() >= montoRetiro) {
                for (int i = 0; i < personas.size(); i++) {

                    if (Integer.valueOf(personas.get(i).getNumeroTarjeta()).equals(tarjeta)) {

                        saldo = Integer.valueOf(personas.get(i).getSaldo());

                        nuevoSaldo = saldo + montoRetiro;

                        personas.get(i).setSaldo(String.valueOf(nuevoSaldo));

//                    out.println(personas.get(i).getSaldo());
                        cargarContactos.escribirArchivo();

                        JOptionPane.showMessageDialog(null, "La transaccion ha sido completada");

                    }
                }

            } else {
                out.println("La cuenta no posee fondos suficientes");

            }

//        }

    }

    public void transferir() throws IOException {

        int nuevoSaldo = 0;

//        if (iniciarSesion() == true) {

            tarjetaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de tarjeta destino"));

            if (tarjetaDestinoExiste() == true) {

                int montoTransferir = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el monto a transferir"));

/////Verificar fondos   
                if (consultarSaldoCuentaPrincipal() >= montoTransferir) {

                    ///Transferir saldo a cuenta secundaria    
                    for (int i = 0; i < personas.size(); i++) {

                        if (Integer.valueOf(personas.get(i).getNumeroTarjeta()).equals(tarjetaDestino)) {

                            saldo = Integer.valueOf(personas.get(i).getSaldo());

                            nuevoSaldo = saldo + montoTransferir;

                            personas.get(i).setSaldo(String.valueOf(nuevoSaldo));

                            out.println("Nuevo saldo cuenta destino " + personas.get(i).getSaldo());
                        }
                    }

                    ///Restar saldo a cuenta secundaria    
                    for (int i = 0; i < personas.size(); i++) {

                        if (Integer.valueOf(personas.get(i).getNumeroTarjeta()).equals(tarjeta)) {

                            saldo = Integer.valueOf(personas.get(i).getSaldo());

                            nuevoSaldo = saldo - montoTransferir;

                            personas.get(i).setSaldo(String.valueOf(nuevoSaldo));

                            out.println("Nuevo saldo cuenta principal " + personas.get(i).getSaldo());
                        }
                    }
                    cargarContactos.escribirArchivo();
                    JOptionPane.showMessageDialog(null, "La transferencia ha sido completada");

                } else {
                    out.println("La cuenta no posee fondos suficientes");
                }

            }

//        }

    }

}
