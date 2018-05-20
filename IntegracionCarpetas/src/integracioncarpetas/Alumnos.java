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
public class Alumnos extends Usuario {

    private String nivelEstudio;

    public Alumnos(String nivelEstudio, String dni, String usuario, String contraseña, String nombreYapellidos, Calendar fechaNacimiento) {
        super(dni, usuario, contraseña, nombreYapellidos, fechaNacimiento);
        this.nivelEstudio = nivelEstudio;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    @Override
    public String toString() {
        return "Nivel estudio: " + this.nivelEstudio + super.toString();
    }

    @Override
    void escribirFichero() {
        String ruta = "usuarios/alumnos";
        File fic = new File(ruta);
        File fichero = new File(ruta + "/" + this.dni + ".txt");
        try {
            if (fic.exists() && fic.isDirectory()) {
                fichero.createNewFile();
                PrintWriter pw = new PrintWriter(fichero);
                String formatoCSV = super.formatear() + this.nivelEstudio + ";";
                pw.println(formatoCSV);
                pw.close();
            } else {
                fic.mkdir();
                fichero.createNewFile();
                PrintWriter pw = new PrintWriter(fichero);
                String formatoCSV = super.formatear() + this.nivelEstudio + ";";
                pw.println(formatoCSV);
                pw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    String generarContraseña() {
        return this.dni.substring(0, 3) + this.fechaNacimiento.get(Calendar.YEAR);
    }

}
