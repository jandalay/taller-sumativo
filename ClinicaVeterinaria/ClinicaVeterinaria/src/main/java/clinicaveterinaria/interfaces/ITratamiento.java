package clinicaveterinaria.interfaces;

public interface ITratamiento {
    double calcularCostoFinal();
    double calcularCostoConImpuestos();
    String obtenerIndicaciones();
    String obtenerPreparacionSala();
}
