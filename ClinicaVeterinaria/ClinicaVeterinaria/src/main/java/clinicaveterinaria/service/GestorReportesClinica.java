package clinicaveterinaria.service;

import clinicaveterinaria.repository.BaseDatos;
import clinicaveterinaria.interfaces.IBaseDatos;


public class GestorReportesClinica {
    private final IBaseDatos baseDatos;

    public GestorReportesClinica( IBaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void imprimirResumenOperaciones() {
        System.out.println("Resumen interno: " + ((BaseDatos)baseDatos).getAuditoria());
    }
}
