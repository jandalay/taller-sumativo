package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.ICostoImpuesto;
import clinicaveterinaria.interfaces.ITratamiento;

public class CalculadoraCostoTratamiento implements ICostoImpuesto {
    private final ITratamiento tratamiento;

    public CalculadoraCostoTratamiento(ITratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public double calcularConImpuestos() {
        return tratamiento.calcularCostoConImpuestos();
    }
}
