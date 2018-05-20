/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracioncarpetas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sportak
 */
public class IntegracionCarpetas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion, dia, mes, año;
        String dni, usuario, contraseña, nombreApellidos, departamento, nivelEstudio, nomFich;
        Calendar FechaNacimiento = Calendar.getInstance();
        Profesores prof1;
        Administrador admin1;
        Alumnos alum1;
        Instituto insti1;
        Usuario activo;
        File archivoActivo;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce nombre del instituto");
        insti1 = new Instituto(teclado.nextLine());
        insti1.crearCarpetaUsuarios();
        insti1.crearPapelera();
        do {
            mostrarMenu();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Que tipo de usuario? 1 Administrador 2 Profesor 3 Alumno 0 salir");
                    opcion = teclado.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Introduzca dni");
                            teclado.nextLine();
                            dni = teclado.nextLine();
                            System.out.println("Introduzca usuario");
                            usuario = teclado.nextLine();
                            System.out.println("Introduzca nombreApellidos");
                            nombreApellidos = teclado.nextLine();
                            System.out.println("Introduzca fecha de nacimiento, DIA MES AÑO");
                            FechaNacimiento.set(teclado.nextInt(), teclado.nextInt(), teclado.nextInt());
                            admin1 = new Administrador(dni, usuario, "TEMPORAL", nombreApellidos, FechaNacimiento);
                            insti1.añadirUsuario(admin1);
                            admin1.escribirFichero();
                            break;
                        case 2:
                            System.out.println("Introduzca dni");
                            teclado.nextLine();
                            dni = teclado.nextLine();
                            System.out.println("Introduzca usuario");
                            usuario = teclado.nextLine();
                            System.out.println("Introduzca nombreApellidos");
                            nombreApellidos = teclado.nextLine();
                            System.out.println("Introduzca fecha de nacimiento, DIA MES AÑO");
                            FechaNacimiento.set(teclado.nextInt(), teclado.nextInt(), teclado.nextInt());
                            System.out.println("Introduzca departamento");
                            teclado.nextLine();
                            departamento = teclado.nextLine();
                            prof1 = new Profesores(departamento, dni, usuario, "TEMPORAL", nombreApellidos, FechaNacimiento);
                            insti1.añadirUsuario(prof1);
                            prof1.escribirFichero();
                            break;
                        case 3:
                            System.out.println("Introduzca dni");
                            teclado.nextLine();
                            dni = teclado.nextLine();
                            System.out.println("Introduzca usuario");
                            usuario = teclado.nextLine();
                            System.out.println("Introduzca nombreApellidos");
                            nombreApellidos = teclado.nextLine();
                            System.out.println("Introduzca fecha de nacimiento, DIA MES AÑO");
                            FechaNacimiento.set(teclado.nextInt(), teclado.nextInt(), teclado.nextInt());
                            System.out.println("Introduzca nivel de estudio");
                            teclado.nextLine();
                            nivelEstudio = teclado.nextLine();
                            alum1 = new Alumnos(nivelEstudio, dni, usuario, "TEMPORAL", nombreApellidos, FechaNacimiento);
                            insti1.añadirUsuario(alum1);
                            alum1.escribirFichero();
                            break;

                    }
                    break;
                case 2:
                    String dnie;
                    System.out.println("Modificar usuario [1] Modificar fichero [2]");
                    opcion = teclado.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Que usuario deseas modificar? Introduzca DNI");
                            insti1.imprimirUsuarios();
                            teclado.nextLine();
                            dnie = teclado.nextLine();
                            activo = insti1.buscarUsuario(dnie);
                            if (activo != null) {
                                System.out.println("Que deseas modificar del usuario? [1] Dni [2]Usuario [3]NombreYApellidos  [0]salir");
                                opcion = teclado.nextInt();
                                teclado.nextLine();
                                switch (opcion) {
                                    case 1:
                                        System.out.println("Introduzca nuevo dni");
                                        activo.setDni(teclado.nextLine());
                                        break;
                                    case 2:
                                        System.out.println("Introduzca nuevo nombre de Usuario");
                                        activo.setUsuario(teclado.nextLine());
                                        break;
                                    case 3:
                                        System.out.println("Introduzca nuevo nombre y apellidos");
                                        activo.setNombreYapellidos(teclado.nextLine());
                                        break;
                                }
                                insti1.imprimirUsuarios();

                            } else {
                                System.out.println("No existe tal usuario");
                            }
                            break;
                        case 2:
                            System.out.println("Introduzca nombre del fichero,con extension .txt si es windows");
                            teclado.nextLine();
                            nomFich = teclado.nextLine();
                            String ruta = "usuarios";
                            String contenido = "";
                            String res = buscarFichero(nomFich, ruta);
                            if (res != null) {
                                File ficheroEncontrado = new File(res);
                                try {
                                    Scanner sc = new Scanner(ficheroEncontrado);
                                    while (sc.hasNext()) {
                                        contenido = sc.nextLine();
                                    }
                                    sc.close();
                                    System.out.println("Que deseas cambiar? [1]Nombre del Fichero [2]Contenido del fichero [0]Salir");
                                    opcion = teclado.nextInt();
                                    switch (opcion) {
                                        case 1:
                                            System.out.println("Introduzca nuevo nombre del fichero con .txt");
                                            teclado.nextLine();
                                            nomFich = teclado.nextLine();
                                            File ficheroNuevo = new File(ficheroEncontrado.getParent() + "/" + nomFich);
                                            ficheroNuevo.createNewFile();
                                            PrintWriter escritura = new PrintWriter(ficheroNuevo);
                                            escritura.print(contenido);
                                            escritura.close();
                                            ficheroEncontrado.deleteOnExit();
                                            break;

                                        case 2:
                                            System.out.println("Introduce los nuevos datos");
                                            teclado.nextLine();
                                            contenido = teclado.nextLine();
                                            PrintWriter escritura2 = new PrintWriter(ficheroEncontrado);
                                            escritura2.print(contenido);
                                            escritura2.close();
                                            break;
                                    }
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(IntegracionCarpetas.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(IntegracionCarpetas.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            } else {
                                System.out.println("EL FICHERO NO EXISTE");
                            }

                            break;
                    }
                    break;
                case 3:
                    System.out.println("Introduce el dni del usuario ");
                    insti1.imprimirUsuarios();
                    teclado.nextLine();
                    dni = teclado.nextLine();
                    activo = insti1.buscarUsuario(dni);
                    if (activo != null) {
                        activo.setContraseña(activo.generarContraseña());
                        activo.escribirFichero();
                        System.out.println("Generada exitosamente");
                    } else {
                        System.out.println("El usuario no existe");
                    }

                    break;
                case 4:
                    System.out.println("Introduce el dni del usuario ");
                    insti1.imprimirUsuarios();
                    teclado.nextLine();
                    dni = teclado.nextLine();
                    activo = insti1.buscarUsuario(dni);
                    if (activo != null) {
                        String ruta = buscarFichero(dni + ".txt", "usuarios");
                        if (ruta != null) {
                            File archivoAeliminar = new File(ruta);
                            String nombre = archivoAeliminar.getName() + ".txt";
                            String contenido;
                            try {
                                Scanner sc = new Scanner(archivoAeliminar);
                                contenido = sc.nextLine();
                                sc.close();
                                File nuevoArchivo=new File("usuarios/papelera/"+nombre);
                                nuevoArchivo.createNewFile();
                                PrintWriter pw=new PrintWriter(nuevoArchivo);
                                pw.write(contenido);
                                pw.close();
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(IntegracionCarpetas.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(IntegracionCarpetas.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            archivoAeliminar.deleteOnExit();

                        } else {
                            System.out.println("No fue encontrado el fichero");
                        }
                    } else {
                        System.out.println("No se puede borrar porque no existe");
                    }
                    break;
            }
        } while (opcion != 0);

    }

    public static void mostrarMenu() {
        System.out.println("Bienvenido al menu de -Integracion de Carpetas- Elija una opcion");
        System.out.println("1.-Dar de alta un usuario");
        System.out.println("2.-Modificar usuarios o ficheros");
        System.out.println("3.-Generar contraseñas para un usuario en concreto y escribir en fichero");
        System.out.println("4.-Borrar un usuario junto a su fichero");
        System.out.println("5.-Cargar ficheros en array");
        System.out.println("0.-Para salir");
    }

    public static String buscarFichero(String nombreFich, String rutaInicial) {
        File[] arrayFicheros = new File(rutaInicial).listFiles();
        String res = "";
        for (int i = 0; i < arrayFicheros.length; i++) {
            if (arrayFicheros[i].getName().equalsIgnoreCase(nombreFich)) {
                System.out.println("Fichero encontrado");
                res = arrayFicheros[i].getAbsolutePath();
                return res;

            } else if (arrayFicheros[i].isDirectory()) {
                System.out.println("Entrando en directorio");
                System.out.println(rutaInicial + "/" + arrayFicheros[i].getName());
                res = buscarFichero(nombreFich, rutaInicial + "/" + arrayFicheros[i].getName());
                if (res != null) {
                    return res;
                }
            }
        }
        return null;
    }

}
