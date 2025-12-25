package Util;

import negocio.Empleado;
import negocio.HuellaDigital;
import negocio.ReconocimientoFacial;
import negocio.TokenSeguridad;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private List<Empleado> empleados;
    //crar listado de toda iformacion que manejamos, contructor por defescto inicializa todas las listas,
    // y en esta clase uitl tiene todos los requerimietos funcionales

    public Util(){
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(String cedula, String nombre){
        int indice = buscarEmpleado(cedula);
        if(indice == -1){
            empleados.add(new Empleado(cedula, nombre));
        }else{
            System.out.println("Empleado ya existe...");
        }
    }

    public void agregarAutenticacionHuella(String cedula, String tipo,int nivelSeguridad, String patronHuella){
        int indice = buscarEmpleado(cedula);
        if (indice != -1){
            empleados.get(indice).agregarAutentificacion(new HuellaDigital(nivelSeguridad, patronHuella));
        }else{
            System.out.println("empleado no existe...");
        }
    }

    public int cantidadAutenticacionHuella(String cedula){
        int indice = buscarEmpleado(cedula);
        if (indice != -1){
            return empleados.get(indice).cantidadAutetificacionesHuellas();
        }else{
            System.out.println("empleado no existe...");
            return -1;
        }
    }

    public void agregarAutenticacionFacial(String cedula, String tipo, int nivelSeguridad, String patronRostro){
        int indice = buscarEmpleado(cedula);
        if (indice != -1){
            int cantidadActual = empleados.get(indice).cantidadAutetificacionesFacial();
            if (cantidadActual == 0){
                empleados.get(indice).agregarAutentificacion(new ReconocimientoFacial(nivelSeguridad, patronRostro));
                System.out.println("rostro registrado");
            }else{
                System.out.println("el empleado ya tiene rostro registrado...");
            }

        }else{
            System.out.println("empleado no existe...");
        }
    }

    public int cantidadAutenticacionFacial(String cedula){
        int indice = buscarEmpleado(cedula);
        if (indice != -1){
            return empleados.get(indice).cantidadAutetificacionesFacial();
        }
        return -1;
    }

    public void agregarAutenticacionToken(String cedula, String tipo, int nivelSeguridad, String token){
        int indice = buscarEmpleado(cedula);
        if (indice != -1){
            int cantidadActual = empleados.get(indice).cantidadAutetificacionesToken();
            if (cantidadActual == 0){
                empleados.get(indice).agregarAutentificacion(new TokenSeguridad(nivelSeguridad, token));
                System.out.println("token registrado");
            }else{
                System.out.println("el empleado ya tiene token registrado...");
            }

        }else{
            System.out.println("empleado no existe...");
        }
    }

    public int cantidadAutenticacionToken(String cedula){
        int indice = buscarEmpleado(cedula);
        if (indice != -1){
            return empleados.get(indice).cantidadAutetificacionesToken();
        }
        return -1;
    }

    public String auteticacionesUmbralMayor(String cedula, int umbral){
        int indice = buscarEmpleado(cedula);
        if (indice != -1){
            return empleados.get(indice).autetificacionesMayorUmbral(umbral);
        }else{
            return "empleado no existe...";
        }
    }

    public boolean autenticarEmpleado(String cedula, String tipo, String patron){
        int indice = buscarEmpleado(cedula);
        if (indice != -1){
            return empleados.get(indice).autenticar(tipo, patron);
        }else{
            return false;
        }
    }

    public int buscarEmpleado(String cedula){
        for (int i = 0; i < empleados.size(); i++){
            if (empleados.get(i).getCedula().equals(cedula)){
                return i;
            }
        }
        return -1;
    }
}
