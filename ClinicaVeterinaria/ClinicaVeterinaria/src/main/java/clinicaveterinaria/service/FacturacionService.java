package clinicaveterinaria.service;

import java.time.LocalDate;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.repository.BaseDatos;


public class FacturacionService {
    private final BaseDatos baseDatos;

    public FacturacionService(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public Factura generarFactura(int id, Cita cita, double monto, LocalDate fecha) {
        Factura factura = new Factura(id, cita, monto, fecha, false);
        baseDatos.getFacturas().add(factura);
        return factura;
    }
}
