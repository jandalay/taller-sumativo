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
    Lo primero que se hizo fue eliminar el contenido de IAnimal, ya que notamos que no es necesario. Además, la problemática menciona que el animal puede volar, nadar y caminar, pero todos los aniamles heredan esas características, y es algo incongruente, ya que no todos o pueden cumplirlo, por ejemplo un pez no puede volar, ni caminar.
    Por eso, se creó unas interfaces segmentadas, ya que con eso se tendría la jerarquía correcta, en este caso sería Caminador, Nadador y Volador. Esto lo que nos ayuda es para que cada animal pueda tener sus condiciones reales, es decir, que cada animal pueda hacer las acciones según sus capacidades (ejemplo un perro no puede volar). 
    Respecto a las preguntas. 
    1. El lanzar UnsupportedOperationException puede ser una señal de mal diseño, porque indica que una clase está obligada a implementar un método que realmente no se puede ejecutar.
    2. La clase Animal estaba prometiendo que todos los animales podían realizar las acciones de caminar, nadar y volar, ya que dichos métodos formaban parte de su definición o de la interfaz que implementaba. Y eso era practicamente imposible, ya que hay aniamles que no pueden realizar todas las tareas juntas.
    3. Cuando se modelan capacidades en lugar de utilizar una herencia demasiado amplia, cada clase implementa únicamente los comportamientos que realmente puede realizar. Esto en esta seccion quierre decir que no se va a obligar a cada aninal a realizar todas las acciones, por eso se especifica con las interfaces Caminador, Volador y Nadador. Esto lo que hace es evitar errores o que existan comportamientos inesperados.

- Integrante 4: refactorizar ISP y DIP.

Lee `guia.md` para instrucciones, checklists y preguntas de discusión.
