package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Veterinario;

public interface ICitaService {
    void crearCita(Cita cita);

    Cita obtenerCita(int id);

    void cancelarCita(int id);

    void crearVeterinario(Veterinario veterinario);

    Veterinario obtenerVeterinario(int id);
}