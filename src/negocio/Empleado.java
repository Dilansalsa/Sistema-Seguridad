package negocio;

import java.util.ArrayList;
import java.util.List;

public class Empleado {

    private String cedula;
    private String nombre;
    private List<MetodoAutentificacion> autentificaciones;

    public Empleado(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        autentificaciones = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public List<MetodoAutentificacion> getAutentificaciones() {
        return autentificaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarAutentificacion(MetodoAutentificacion m){
        autentificaciones.add(m);
    }

    public int cantidadAutetificacionesHuellas(){
        int cont = 0;
        for (MetodoAutentificacion m: autentificaciones){
            if (m instanceof HuellaDigital){
                cont ++;
            }
        }
        return cont;
    }

    public int cantidadAutetificacionesFacial(){
        int cont = 0;
        for (MetodoAutentificacion m: autentificaciones){
            if (m instanceof ReconocimientoFacial){
                cont ++;
            }
        }
        return cont;
    }

    public int cantidadAutetificacionesToken(){
        int cont = 0;
        for (MetodoAutentificacion m: autentificaciones){
            if (m instanceof TokenSeguridad){
                cont ++;
            }
        }
        return cont;
    }

    public  String autetificacionesMayorUmbral(int umbral){
        String autetificaciones = "";
        for (MetodoAutentificacion m: autentificaciones){
            if(m.getNivelSeguridad() > umbral){
                autetificaciones += m.getTipo();
                autetificaciones += m.getNivelSeguridad();
            }
        }
        return autetificaciones;
    }

    public boolean autenticar(String tipo, String patron){
        for (MetodoAutentificacion m: autentificaciones){
            if(m.getTipo().equalsIgnoreCase(tipo)){
                if (m.Autenticar(patron)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "Cedula: " + cedula + "\nNombre: " + nombre +
                "\nAutentificaciones\n" + autentificaciones;
    }
}
