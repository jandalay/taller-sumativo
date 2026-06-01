package clinicaveterinaria.service;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;

import clinicaveterinaria.interfaces.IMascotaService;
import clinicaveterinaria.interfaces.ICitaService;



public class RecepcionService implements IMascotaService, ICitaService {
    private final ServicioClinicaCompleto servicioCompleto;

    public RecepcionService(ServicioClinicaCompleto servicioCompleto) {
        this.servicioCompleto = servicioCompleto;
    }

    @Override
    public void crearMascota(Mascota mascota) {
        servicioCompleto.crearMascota(mascota);
    }

    @Override
    public Mascota obtenerMascota(int id) {
        return servicioCompleto.obtenerMascota(id);
    }

    @Override
    public void actualizarMascota(Mascota mascota) {
        servicioCompleto.actualizarMascota(mascota);
    }

    @Override
    public void eliminarMascota(int id) {
        servicioCompleto.eliminarMascota(id);
    }

    @Override
    public void crearVeterinario(Veterinario veterinario) {
        servicioCompleto.crearVeterinario(veterinario);
    }

    @Override
    public Veterinario obtenerVeterinario(int id) {
        return servicioCompleto.obtenerVeterinario(id);
    }


    @Override
    public void crearCita(Cita cita) {
        servicioCompleto.crearCita(cita);
    }

    @Override
    public Cita obtenerCita(int id) {
        return servicioCompleto.obtenerCita(id);
    }

    @Override
    public void cancelarCita(int id) {
        servicioCompleto.cancelarCita(id);
    }

}
