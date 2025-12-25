package negocio;

public class TokenSeguridad extends MetodoAutentificacion{
    private String token;

    public TokenSeguridad(int nivelSeguridad, String token) {
        super(nivelSeguridad, "Token de seguridad");
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean Autenticar(String patron) {
        if (token.equals(patron)) {
            return true;
        }
        return false;
    }
}
