# ClinicaVeterinaria

Proyecto Java Maven para practicar refactoring con principios SOLID en un taller colaborativo.

El sistema funciona desde el inicio, pero contiene violaciones intencionales de SRP, OCP, LSP, ISP y DIP. La idea es que cada integrante refactorice una zona del código sin romper la ejecución.

## Setup en 5 minutos


Compilar con Maven. Salida esperada:

```text
=== ClinicaVeterinaria funcionando ===
```

## Estructura del proyecto

```text
src/main/java/clinicaveterinaria/
├── Main.java
├── interfaces/
│   ├── IAnimal.java
│   ├── IBaseDatos.java
│   ├── IServicioClinica.java
│   ├── ITratamiento.java
│   └── IVeterinarioService.java
├── model/
│   ├── Mascota.java
│   ├── Veterinario.java
│   ├── Cita.java
│   ├── Tratamiento.java
│   ├── Factura.java
│   └── clases auxiliares para animales y enums
├── repository/
│   ├── BaseDatos.java
│   └── DirectoBaseDatos.java
└── service/
    ├── ReservaService.java
    ├── DiagnosticoService.java
    ├── FacturacionService.java
    ├── ReporteService.java
    └── servicios CRUD y clases con violaciones intencionales
```

## Trabajo del taller

- Integrante 1: refactorizar SRP.
- Integrante 2: refactorizar OCP.
- Integrante 3: refactorizar LSP.
- Integrante 4: refactorizar ISP y DIP.

Lee `guia.md` para instrucciones, checklists y preguntas de discusión.

- Integrante 2: refactorizar OCP.(Jose Navarrete)
PROBLEMAS CON TARTAMIENTO:
Usa muchas condicionales lo que se deveria hacer es crear clases por tipo de tratamiento para poder aplicar el principio Open/Close:
Modificaciones:
## Vacuna tratamiento clase
package clinicaveterinaria.model;

import java.util.Objects;

import clinicaveterinaria.interfaces.ITratamiento;

public class VacunaTratamiento implements ITratamiento {
    private final double costo;

    public VacunaTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal() {
        return costo + 5.0;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Observar fiebre durante 24 horas.";
    }
}
## Medicamento Tratamiento clase 
package clinicaveterinaria.model;

import java.util.Objects;

import clinicaveterinaria.interfaces.ITratamiento;

public class MedicamentoTratamiento implements ITratamiento {
    private final double costo;

    public MedicamentoTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal() {
        return costo + 1.10;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Administrar segun receta.";
    }
}
## FISIOTERAPIA TRATAMIENTO 
package clinicaveterinaria.model;

import java.util.Objects;

import clinicaveterinaria.interfaces.ITratamiento;

public class FisioterapiaTratamiento implements ITratamiento {
    private final double costo;

    public FisioterapiaTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal() {
        return costo + 0.95;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Repetir sesiones dos veces por semana.";
    }
}
## Cirugia Tratamiento 
package clinicaveterinaria.model;

import java.util.Objects;

import clinicaveterinaria.interfaces.ITratamiento;

public class CirugiaTratamiento implements ITratamiento {
    private final double costo;

    public CirugiaTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal() {
        return costo + 1.25 + 80.0;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Ayuno previo y control postoperatorio.";
    }
}

## Asi con cada clase no necesitariamos usar varias condicionales
## Parte Service
EN la parte del Service tambien utiliza condicionales lo que incumple el Pirncipio Open/Close
## CalcularCostoTratamiento
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
## TratamientoService
package clinicaveterinaria.service;

import java.util.List;

import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.repository.BaseDatos;


public class TratamientoService {
    private final BaseDatos baseDatos;

    public TratamientoService(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void crearTratamiento(Tratamiento tratamiento) {
        baseDatos.getTratamientos().add(tratamiento);
        baseDatos.registrarOperacion("crearTratamiento");
    }

    public Tratamiento obtenerTratamiento(int id) {
        for (Tratamiento tratamiento : baseDatos.getTratamientos()) {
            if (tratamiento.getId() == id) {
                return tratamiento;
            }
        }
        return null;
    }

    public void actualizarTratamiento(Tratamiento tratamiento) {
        eliminarTratamiento(tratamiento.getId());
        crearTratamiento(tratamiento);
    }

    public void eliminarTratamiento(int id) {
        baseDatos.getTratamientos().removeIf(tratamiento -> tratamiento.getId() == id);
        baseDatos.registrarOperacion("eliminarTratamiento");
    }

    public String prepararSala(Tratamiento tratamiento) {
        return tratamiento.obtenerPreparacionSala();
    }

    public List<Tratamiento> listarTratamientos() {
        return baseDatos.getTratamientos();
    }
}
## Creacion de interfaz ICostoImpuesto
package clinicaveterinaria.interfaces;


public interface ICostoImpuesto {
    double calcularConImpuestos(); 
}
## Mejora del ITratamiento
package clinicaveterinaria.interfaces;

public interface ITratamiento {
    double calcularCostoFinal();
    double calcularCostoConImpuestos();
    String obtenerIndicaciones();
    String obtenerPreparacionSala();
}
Resumen: Se modifico Itratamiento agregando obtener preparacion de sala y el calculo de costo de impuestos.
## ¿Cómo cambia el diseño cuando modelamos capacidades en lugar de herencia amplia?.
Pues facilita el entendimiento del codigo y ayuda a que el codigo genere menos errores
