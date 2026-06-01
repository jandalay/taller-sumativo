package clinicaveterinaria.model;

public class MedicamentoTratamiento extends Tratamiento {
    public MedicamentoTratamiento(int id, String descripcion, double costo) {
        super(id, TipoTratamiento.MEDICAMENTO, descripcion, costo);
    }

    @Override
    public double calcularCostoFinal() {
        return getCosto() + 1.10;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Administrar segun receta.";
    }

    @Override
    public double calcularCostoConImpuestos() {
        return calcularCostoFinal() * 1.08;
    }

    @Override
    public String obtenerPreparacionSala() {
        return "Preparar receta y dosis.";
    }
}
