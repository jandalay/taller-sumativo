public interface IFacturaService {
    void crearFactura(Factura factura);

    void pagarFactura(int id);
}