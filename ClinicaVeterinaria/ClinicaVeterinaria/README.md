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

- Integrante 1: refactorizar SRP
Se eliminaor los metodos reservarcita, diagnosticar, generarrfactura y crearreporte de la clase Veterinario, en la clase Reservaservice se modifico el metodo reservarcita haciendo que pida tambien el veterinario que lo genera y se agrego el metodo crearreporte a la clase ReporteService, ademas se cambion el codigo del main que generaban conflicto.
¿Cuántas razones para cambiar tenía `Veterinario` antes del refactoring?
4, los metodos ya mencionados
¿Qué ganamos al separar modelo y servicios?
Una facil comprension de la que es algo, que en este caso son los modelos, y que se puede hacer con esos modelos
¿Qué clase debería cambiar si mañana cambia el formato del reporte?
Seguramente la clase ReporteService
- Integrante 2: refactorizar OCP.
- Integrante 3: refactorizar LSP.
- Integrante 4: Pichu Alay Jandry René
refactorizar ISP y DIP.
Preguntas de discusión:

- ¿Qué problema causa una interfaz gigante en equipos grandes?
Que la clase que implemente aquella interfaz tenga que implementar todos sus métodos.
- ¿Por qué `new DirectoBaseDatos()` dificulta cambiar o probar la clase?
Debido a que hay dos códigos que implementa un método propio de su clase DirectoBaseDatos, es decir, no existe aquel método desde la interfaz por lo que se hace Casting si se desea usar.
- ¿Qué dependencia debería conocer el código de alto nivel: interfaz o clase concreta?
interfaz porque se puede implementar varias interfaces en una misma clase.

Lee `guia.md` para instrucciones, checklists y preguntas de discusión.
