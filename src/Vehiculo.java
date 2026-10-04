public class Vehiculo {
    private String placa;
    private double kilometraje;
    private String estatus;
    private Chofer choferAsignado;

    public Vehiculo(String placa, double kilometraje) {
        this.placa = placa;
        this.kilometraje = kilometraje;
        // un vehiculo nuevo tiene por defecto un estatus "disponible"
        this.estatus = "disponible"; 
        this.choferAsignado = null;
    }

    public String getPlaca() { 
        return placa; 
    }
    
    public String getEstatus() { 
        return estatus; 
    }

    // asigna chofer y cambia el status
    public void asignarChofer(Chofer chofer) {
        this.choferAsignado = chofer;
        this.estatus = "ocupado";
    }

    @Override
    public String toString() {
        String info = "Placa: " + placa + " | Km: " + kilometraje + " | Estatus: " + estatus;
        if (choferAsignado != null) {
            info += " | " + choferAsignado.toString();
        }
        return info;
    }
}
