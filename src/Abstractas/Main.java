package Abstractas;

import Util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Util u = new Util();

        int nivelSeguridad;
        String tipo;
        String cedula;
        String nombre;
        String patron;
        int umbral;
        int opcion = 0;
        int existe;
        String reporte;
        int huellas;
        int caras;
        int tokens;
        int suma;

        do {
            menu();
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1:
                    System.out.println("Regsitrar empleado:");
                    System.out.println("ingresar cedula: ");
                    cedula = sc.nextLine();
                    existe = u.buscarEmpleado(cedula);
                    if (existe == -1){
                        System.out.println("ingrese nombre: ");
                        nombre = sc.nextLine();
                        u.agregarEmpleado(cedula, nombre);
                        System.out.println("empleado registrado...");
                    }
                    break;
                case 2:
                    System.out.println("agregra huella digital");
                    System.out.println("ingrese cedula: ");
                    cedula = sc.nextLine();
                    System.out.println("nivel de seguridad: ");
                    nivelSeguridad = Integer.parseInt(sc.nextLine());
                    System.out.println("datos de la huella: ");
                    patron = sc.nextLine();
                    u.agregarAutenticacionHuella(cedula, "Huella Digital", nivelSeguridad, patron);
                    break;
                case 3:
                    System.out.println("Agregar rostro");
                    System.out.print("ingrese cedula: ");
                    cedula = sc.nextLine();
                    System.out.println("nivel de seguridad: ");
                    nivelSeguridad = Integer.parseInt(sc.nextLine());
                    System.out.println("datos del rostro: ");
                    patron = sc.nextLine();
                    u.agregarAutenticacionFacial(cedula, "Recomocimiento facil", nivelSeguridad, patron);
                    break;
                case 4:
                    System.out.println("Agregar token");
                    System.out.println("ingrese la cedula:");
                    cedula = sc.nextLine();
                    System.out.println("nivel de seguridad: ");
                    nivelSeguridad = Integer.parseInt(sc.nextLine());
                    System.out.println("datos del token: ");
                    patron = sc.nextLine();
                    u.agregarAutenticacionToken(cedula, "Token de seguridad", nivelSeguridad, patron);
                    break;
                case 5:
                    System.out.println("Control acceso");
                    System.out.println("Ingrese la cedula: ");
                    cedula = sc.nextLine();
                    System.out.println("seleccion el metodo (Huella Digital, Recomocimiento facil, Token de seguridad)");
                    System.out.println("ingrese el metodo: ");
                    tipo = sc.nextLine();
                    System.out.println("Ingrese el patron clave: ");
                    patron = sc.nextLine();
                    boolean paso = u.autenticarEmpleado(cedula, tipo, patron);
                    if (paso){
                        System.out.println("acceso correcto");
                    }else{
                        System.out.println("acceso incorrecto");
                    }
                    break;
                case 6:
                    System.out.println("reporte de seguridad");
                    System.out.println("ingrese la cedula: ");
                    cedula = sc.nextLine();
                    System.out.println("ver metodos con nivel mayor a: ");
                    umbral = Integer.parseInt(sc.nextLine());
                    reporte = u.auteticacionesUmbralMayor(cedula, umbral);
                    System.out.println("reporte: " + reporte);
                    break;
                case 7:
                    System.out.println("estado de empleado");
                    System.out.println("ingrese la cedula: ");
                    cedula = sc.nextLine();
                    suma=0;
                    huellas = u.cantidadAutenticacionHuella(cedula);
                    caras = u.cantidadAutenticacionFacial(cedula);
                    tokens = u.cantidadAutenticacionToken(cedula);

                    if (huellas != -1){
                        suma += huellas;
                    }
                    if (caras != -1){
                        suma += caras;
                    }
                    if (tokens != -1){
                        suma += tokens;
                    }
                    System.out.println("numero de contrasenias: " + suma);
                    break;
                case 8:
                    System.out.println("Listado");
                    u.mostrarListado();
                    break;
                case 9:
                    System.out.println("saliendo del sistema...");
                    break;
                default:
                    System.out.println("opcion no valida...");
                    break;
            }

        }while(opcion != 9);

    }
    public static void menu(){
        System.out.println("\n===SISTEMA DE SEGURIDAD===");
        System.out.println("1. Registrar nuevo empleado");
        System.out.println("2. Agregar huella digital a empleado");
        System.out.println("3. Agregar reconocimiento facial a empleado");
        System.out.println("4. Agregar token a empleado");
        System.out.println("5. Autenticar acceso");
        System.out.println("6. Reporte del umbral");
        System.out.println("7. Ver cantidad de registros");
        System.out.println("8. Ver lista de Empleados");
        System.out.println("9. Salir");
        System.out.print("Elija una opcion: ");
    }
}
