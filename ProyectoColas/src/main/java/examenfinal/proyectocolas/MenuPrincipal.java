/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenfinal.proyectocolas;

import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ridia
 */
public class MenuPrincipal {

    Banco operaciones = new Banco();
    boolean sesionActiva = false;

    Crud cargarContactos = new Crud();

    ArrayList<Persona> personas = cargarContactos.getArrPersonas();

    public void mostrarPantallaPrincipal() throws IOException {

        JOptionPane.showMessageDialog(null,
                "===========================================" + "\n"
                + "||                   Bienvenido  al Banco Mundial                      ||" + "\n"
                + "||                   ccccXXXXXXXXXXXXXXXXccccc              ||" + "\n"
                + "|| XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX||" + "\n"
                + "===========================================" + "\n"
                + "Presione OK para continuar");
        operaciones.inicializarCrud();
        operaciones.asignarCajeros();

        alternarMenus();

    }

    public void alternarMenus() throws IOException {
        cargarContactos.cargarArchivo();

        for (int i = 0; i < personas.size(); i++) {

            if (i % 2 == 0) {

                while (sesionActiva != true) {
                    sesionActiva = operaciones.validarCredenciales();
                }
                try {

                    menuCajero1();

                    sesionActiva = false;

                } catch (Exception e) {
                    out.println("Datos invalidos");
                }

            } else {

                while (sesionActiva != true) {
                    sesionActiva = operaciones.validarCredenciales();
                }

                try {

                    menuCajero2();

                    sesionActiva = false;

                } catch (Exception e) {
                    out.println("Datos invalidos");
                }
            }

        }
    }

    public void menuCajero1() {
        boolean salir = false;
        int opcion;

        while (!salir) {
            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "===========================================" + "\n"
                        + "||                                Menu de usuario                                 ||" + "\n"
                        + "||                   ccccXXXXXXXXXXXXXXXXccccc              ||" + "\n"
                        + "|| XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX||" + "\n"
                        + "===========================================" + "\n"
                        + " Elija una opcion" + "\n"
                        + "1. c1Tamanho" + "\n" + "2. consultarSaldo" + "\n" + "3. Deposito" + "\n" + "4. Salir"));

                switch (opcion) {
                    case 1:
                        operaciones.c1Tamanho();

                        break;
                    case 2:
                        operaciones.consultarSaldo();

                        break;
                    case 3:
                        operaciones.deposito();

                        break;

                    case 4:
                        operaciones.desencolaC1();
                        salir = true;

                        break;
                    default:
                        JOptionPane.showMessageDialog(null, " La opcion que eligio no existe");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, " Elija una opcion valida o digite 3 para salir");

            }
        }
    }

    public void menuCajero2() {
        boolean salir = false;
        int opcion;

        while (!salir) {
            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "===========================================" + "\n"
                        + "||                                Menu de usuario                                 ||" + "\n"
                        + "||                   ccccXXXXXXXXXXXXXXXXccccc              ||" + "\n"
                        + "|| XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX||" + "\n"
                        + "===========================================" + "\n"
                        + " Elija una opcion" + "\n"
                        + "1. c2Tamanho" + "\n" + "2. consultarSaldo" + "\n" + "3. Salir"));

                switch (opcion) {
                    case 1:
                        operaciones.c2Tamanho();

                        break;
                    case 2:
                        operaciones.consultarSaldo();

                        break;
                    case 3:
                        operaciones.desencolaC2();
                        salir = true;

                        break;
                    default:
                        JOptionPane.showMessageDialog(null, " La opcion que eligio no existe");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, " Elija una opcion valida o digite 3 para salir");

            }
        }
    }
}
