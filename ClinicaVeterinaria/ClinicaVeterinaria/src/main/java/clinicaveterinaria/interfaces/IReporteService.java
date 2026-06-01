public interface IReporteService {
    List<Cita> generarReporteCitasPorVeterinario(int veterinarioId);

    List<Mascota> generarReporteMascotasPorDueno(String duenoNombre);

}