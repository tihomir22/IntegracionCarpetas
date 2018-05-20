/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracioncarpetas;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sportak
 */
public class Administrador extends Usuario {

    public Administrador(String dni, String usuario, String contraseña, String nombreYapellidos, Calendar fechaNacimiento) {
        super(dni, usuario, contraseña, nombreYapellidos, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Administrador " + super.toString();
    }

    @Override
    void escribirFichero() {
        String ruta = "usuarios/administradores";
        File fic = new File(ruta);
        File fichero = new File(ruta + "/" + this.dni + ".txt");

        try {

            if (fic.exists() && fic.isDirectory()) {
                fichero.createNewFile();
                PrintWriter pw = new PrintWriter(fichero);
                String formatoCSV = super.formatear();
                pw.println(formatoCSV);
                pw.close();
            } else {
                fic.mkdir();
                fichero.createNewFile();
                PrintWriter pw = new PrintWriter(fichero);
                String formatoCSV = super.formatear();
                pw.println(formatoCSV);
                pw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    String generarContraseña() {
        return "1234";
    }

}
