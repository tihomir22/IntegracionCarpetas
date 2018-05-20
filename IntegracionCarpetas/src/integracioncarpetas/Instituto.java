/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracioncarpetas;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author sportak
 */
public class Instituto {
    private String nombre;
    private ArrayList<Usuario>listaUsuarios=new ArrayList<>();

    public Instituto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    public void añadirUsuario(Usuario u){
        this.listaUsuarios.add(u);
    }
    public void crearCarpetaUsuarios(){
        File carpeta=new File("usuarios");
        if(!carpeta.exists()){
            carpeta.mkdir();
        }
    }
    public void crearPapelera(){
        File carpeta=new File("usuarios/papelera");
        if(!carpeta.exists()){
            carpeta.mkdir();
        }
    }
    public void imprimirUsuarios(){
        for (int i = 0; i < this.listaUsuarios.size(); i++) {
            System.out.println(this.listaUsuarios.get(i).toString());
        }
    }
    public Usuario buscarUsuario(String u){
        for (int i = 0; i < this.listaUsuarios.size(); i++) {
            if(this.listaUsuarios.get(i).getDni().equals(u)){
                return this.listaUsuarios.get(i);
            }
        }
        return null;
    }
    
}
