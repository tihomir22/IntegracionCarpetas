/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracioncarpetas;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sportak
 */
abstract class Usuario {
    protected String dni;
    protected String usuario;
    protected String contraseña;
    protected String nombreYapellidos;
    protected Calendar fechaNacimiento;

    public Usuario(String dni, String usuario, String contraseña, String nombreYapellidos, Calendar fechaNacimiento) {
        this.dni = dni;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombreYapellidos = nombreYapellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreYapellidos() {
        return nombreYapellidos;
    }

    public void setNombreYapellidos(String nombreYapellidos) {
        this.nombreYapellidos = nombreYapellidos;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String formatear(){
        return this.dni+";"+this.usuario+";"+this.contraseña+";"+this.nombreYapellidos+";"+this.fechaNacimiento.getTime()+";";
    }
    abstract void escribirFichero();
    abstract String generarContraseña();

    @Override
    public String toString() {
        return this.nombreYapellidos+"\t"+this.dni+"\t"+this.usuario+"\t"+this.contraseña+"\t"+this.fechaNacimiento.getTime();
    }
    
    
}
