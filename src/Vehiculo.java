public class Vehiculo {
    private String placa;
    private double kilometraje;
    private String estatus;
    private Chofer choferAsignado;

    public Vehiculo(String placa, double kilometraje) {
        this.placa = placa;
        this.kilometraje = kilometraje;
        // Al registrar un vehículo nuevo, su estatus por defecto es disponible
        this.estatus = "disponible"; 
        this.choferAsignado = null;
    }

    public String getPlaca() { 
        return placa; 
    }
    
    public String getEstatus() { 
        return estatus; 
    }

    // Método para asignar el chofer y cambiar el estatus automáticamente
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