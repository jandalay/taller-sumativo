package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;

import java.util.List;


public interface IServicioClinica {

    void crearVeterinario(Veterinario veterinario);

    Veterinario obtenerVeterinario(int id);

    void actualizarVeterinario(Veterinario veterinario);

    void eliminarVeterinario(int id);

    void crearTratamiento(Tratamiento tratamiento);

    double calcularTratamiento(Tratamiento tratamiento);

    double calcularIngresosMensual();
}
