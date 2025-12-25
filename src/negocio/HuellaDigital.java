package negocio;

public class HuellaDigital extends MetodoAutentificacion{
    private String patronHuella;

    public HuellaDigital(int nivelSeguridad, String patronHuella) {
        super(nivelSeguridad, "Huella Digital");
        this.patronHuella = patronHuella;
    }

    public String getPatronHuella() {
        return patronHuella;
    }

    public void setPatronHuella(String patronHuella) {
        this.patronHuella = patronHuella;
    }

    @Override
    public String toString(){
        return super.toString() + "\nPatron Huella: " + patronHuella;
    }

    @Override
    public boolean Autenticar(String patron){
        if(patronHuella.contains(patron)){
            return true;
        }
        return false;
    }
}
