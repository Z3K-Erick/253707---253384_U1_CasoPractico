public class Chofer {
    private String nombreCompleto;
    private String numeroLicencia;

    public Chofer(String nombreCompleto, String numeroLicencia) {
        this.nombreCompleto = nombreCompleto;
        this.numeroLicencia = numeroLicencia;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    @Override
    public String toString() {
        return "Chofer: " + nombreCompleto + " (Licencia: " + numeroLicencia + ")";
    }
}