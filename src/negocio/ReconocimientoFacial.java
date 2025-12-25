package negocio;

public class ReconocimientoFacial extends MetodoAutentificacion{
    private String patronRostro;

    public ReconocimientoFacial(int nivelSeguridad, String patronRostro) {
        super(nivelSeguridad, "Recomocimiento facil");
        this.patronRostro = patronRostro;
    }

    public String getPatronRostro() {
        return patronRostro;
    }

    public void setPatronRostro(String patronRostro) {
        this.patronRostro = patronRostro;
    }

    @Override
    public String toString(){
        return super.toString() + "\nReconocmiento facil: " + patronRostro;
    }

    @Override
    public boolean Autenticar(String patron) {
        if (patronRostro.contains(patron)) {
            return true;
        }
        return false;
    }
}
