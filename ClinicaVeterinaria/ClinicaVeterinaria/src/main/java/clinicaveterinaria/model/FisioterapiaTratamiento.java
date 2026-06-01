package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.ITratamiento;

public class FisioterapiaTratamiento implements ITratamiento {
    private final double costo;

    public FisioterapiaTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal() {
        return costo + 0.95;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Repetir sesiones dos veces por semana.";
    }

    @Override
    public double calcularCostoConImpuestos() {
        return calcularCostoFinal() * 1.05;
    }

    @Override
    public String obtenerPreparacionSala() {
        return "Preparar camilla y bandas elasticas.";
    }
}
