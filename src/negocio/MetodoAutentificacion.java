package negocio;

public abstract class MetodoAutentificacion {
    private int nivelSeguridad;
    private String tipo;

    public MetodoAutentificacion(int nivelSeguridad, String tipo) {
        this.nivelSeguridad = nivelSeguridad;
        this.tipo = tipo;
    }

    public int getNivelSeguridad() {
        return nivelSeguridad;
    }

    public void setNivelSeguridad(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "Tipo: "+tipo+"\nNivel de seguridad: " + nivelSeguridad;
    }

    public abstract boolean Autenticar(String patron);

}
