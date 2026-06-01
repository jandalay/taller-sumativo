package clinicaveterinaria.model;

public class VacunaTratamiento extends Tratamiento {
    public VacunaTratamiento(int id, String descripcion, double costo) {
        super(id, TipoTratamiento.VACUNA, descripcion, costo);
    }

    @Override
    public double calcularCostoFinal() {
        return getCosto() + 5.0;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Observar fiebre durante 24 horas.";
    }

    @Override
    public double calcularCostoConImpuestos() {
        return calcularCostoFinal() * 1.12;
    }

    @Override
    public String obtenerPreparacionSala() {
        return "Preparar refrigeracion y jeringas.";
    }
}
