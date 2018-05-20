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
public class Profesores extends Usuario {

    private String departamento;

    public Profesores(String departamento, String dni, String usuario, String contraseña, String nombreYapellidos, Calendar fechaNacimiento) {
        super(dni, usuario, contraseña, nombreYapellidos, fechaNacimiento);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Departamento: " + this.departamento + super.toString();
    }

    @Override
    void escribirFichero() {
        String ruta = "usuarios/profesores";
        File fic = new File(ruta);
        File fichero = new File(ruta + "/" + this.dni + ".txt");
        try {

            if (fic.exists() && fic.isDirectory()) {
                fichero.createNewFile();
                PrintWriter pw = new PrintWriter(fichero);
                String formatoCSV = super.formatear() + this.departamento + ";";
                pw.println(formatoCSV);
                pw.close();
            } else {
                fic.mkdir();
                fichero.createNewFile();
                PrintWriter pw = new PrintWriter(fichero);
                String formatoCSV = super.formatear() + this.departamento + ";";
                pw.println(formatoCSV);
                pw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    String generarContraseña() {
        return this.nombreYapellidos.substring(0, 3) + this.fechaNacimiento.get(Calendar.DAY_OF_MONTH);

    }

}
