DOSW_BITACORA
Bitácora de Sara Viviana Arteaga para DOSW
---
Estructura del repositorio
```
src/main/dosw/
├── semana_1/
│   └── streams/             Introducción a la API de Streams de Java
├── semana_2/
│   └── pokemon/              Streams avanzados + primer acercamiento a patrones de diseño
│       ├── Ejercicio1..20       (streams con tema Pokémon)
│       └── EjercicioNPatrones   (un patrón de diseño por carpeta, N = 1 a 12)
└── semana_3/
    └── Taller4/                Taller integrador: 10 ejercicios, cada uno combina
        └── Ejercicio1..10        dos patrones de diseño sobre un caso de negocio real
```
Cada carpeta de ejercicio es independiente y contiene sus propias clases Java y, cuando aplica, su propio Main.java ejecutable.
Los ejercicios de semana_3/Taller4 ya cuentan cada uno con su propio README.md (descripción del problema, solución propuesta, patrones implementados, estructura de clases y ejecución), así que aquí solo se indexan. El resto de la bitácora (semana 1 y semana 2) se describe completa en este mismo documento.
---
Semana 1 — Streams (semana_1/streams)
Cinco ejercicios introductorios a la API de Streams de Java (filter, map, sorted, collect, reduce, anyMatch) usando listas de números, palabras y record (usuarios, transacciones).
Clase	Descripción
Ejercicio1	Filtra de una lista de enteros los valores que son a la vez mayores a 10 y pares.
Ejercicio2	Filtra palabras de longitud mayor a 4, las convierte a mayúsculas, las ordena alfabéticamente y cuenta cuántas quedan.
Ejercicio3	Usa un record User(id, name, age, active) para extraer los nombres de los usuarios activos.
Ejercicio4	Reutiliza el record User para filtrar usuarios activos y mayores de edad.
Ejercicio5	Usa un record Transaction(id, amount, approved) para verificar con anyMatch si existen transacciones no aprobadas.
---
Semana 2 — Pokémon: Streams y Patrones (semana_2/pokemon)
Streams (Ejercicio1 a Ejercicio20)
20 ejercicios de dificultad creciente sobre dos modelos de apoyo: Pokemon (id, nombre, tipo, nivel, poderCombate, región, legendario) y Entrenador (id, nombre, medallas, equipo de Pokemon).
Clase	Operación principal
Ejercicio1	filter por tipo de elemento sobre un record Pokemon(nombre, tipo) local.
Ejercicio2	filter + map para transformar nombres a mayúsculas.
Ejercicio3	reduce para sumar los niveles del equipo.
Ejercicio4	filter sobre nivel y conteo de resultados.
Ejercicio5	filter por nivel y conteo con collect.
Ejercicio6	distinct para eliminar capturas duplicadas.
Ejercicio7	sorted alfabético de la lista de pokémon.
Ejercicio8	filter por bandera booleana (puede evolucionar).
Ejercicio9	operaciones sobre la clase Pokemon ya con todos sus atributos (poder de combate, región, legendario).
Ejercicio10	proyección de datos de la pokédex con map.
Ejercicio11	cálculo estadístico (promedio o similar) sobre la pokédex.
Ejercicio12	recorrido con forEach sobre la pokédex.
Ejercicio13	groupingBy por tipo o región, agrupando nombres.
Ejercicio14	groupingBy con un criterio adicional.
Ejercicio15	introduce la clase Entrenador; búsqueda del entrenador con más medallas.
Ejercicio16	filter de entrenadores según un umbral de medallas.
Ejercicio17	cálculo del entrenador con mayor poder acumulado de equipo.
Ejercicio18	sorted + limit para obtener un top de pokémon más fuertes.
Ejercicio19	sorted con Comparator personalizado + limit para un top de entrenadores.
Ejercicio20	estadísticas combinadas: conteo por tipo y región, legendarios, nivel promedio y el pokémon más fuerte.
Patrones de diseño (EjercicioNPatrones)
Cada carpeta EjercicioNPatrones aísla un único patrón GoF aplicado a un mini-caso de uso distinto. La numeración y el caso de uso coinciden con los de la práctica de patrones de la semana 2, salvo el ejercicio 10, que no se desarrolló.
Carpeta	Patrón	Caso de uso
Ejercicio1Patrones	Factory Method	Procesador de pagos: cada PagoFactory concreta fabrica su propio MetodoPago (tarjeta, PayPal, transferencia) sin que el flujo común lo conozca.
Ejercicio2Patrones	Abstract Factory	Motor de videojuego: ConsolaFactory crea familias completas y compatibles de componentes (control, juego, interfaz) según la consola, PlayStation o Xbox.
Ejercicio3Patrones	Builder	Fábrica de muñecos: un Director ejecuta siempre los mismos pasos de ensamblaje sobre un MunecoBuilder (de acción o clásico) intercambiable.
Ejercicio4Patrones	Adapter	Sistema de abastecimiento: adapta cargadores eléctricos (rápido y lento) a la interfaz SistemaAbastecimiento que ya usan los vehículos de combustión.
Ejercicio5Patrones	Bridge	Formas geométricas (círculo, cuadrado) combinables con cualquier color (rojo, azul) sin multiplicar clases.
Ejercicio6Patrones	Composite	Bodega con productos individuales y cajas que pueden contener productos u otras cajas, calculando el precio total de forma recursiva.
Ejercicio7Patrones	Decorator	Barco equipable con módulos combinables (blindaje, radar, misiles, antitorpedos) que modifican ataque y defensa apilándose dinámicamente.
Ejercicio8Patrones	Chain of Responsibility	Control migratorio: la solicitud de una Persona pasa por una cadena de validaciones (pasaporte y visa, antecedentes, motivo de viaje, aprobación final).
Ejercicio9Patrones	Command	Control de videojuego: cada comando (caminar, saltar, atacar, defenderse) se asigna y ejecuta sobre un Personaje sin que el control conozca la acción concreta.
Ejercicio10Patrones	(no implementado)	No existe una carpeta Ejercicio10Patrones en el repositorio; este ejercicio quedó pendiente.
Ejercicio11Patrones	Strategy	Aplicación de navegación que calcula rutas (bicicleta, carretera, transporte público) según la estrategia activa.
Ejercicio12Patrones	Strategy	Misma aplicación de navegación que el ejercicio 11, agregando una estrategia adicional de ruta a pie.
---
Semana 3 — Taller 4: Combinación de Patrones (semana_3/Taller4)
Taller integrador de 10 ejercicios. A diferencia de la semana 2, aquí cada ejercicio combina dos patrones de diseño trabajando juntos sobre un caso de negocio completo. Cada uno ya tiene su propia descripción (problema, solución, clases y ejecución) en su respectivo README:
Ejercicio	Caso de negocio	Patrones combinados
Ejercicio1	Plataforma de pagos inteligente	Strategy + Factory Method
Ejercicio2	Notificaciones multicanal	Observer + Factory Method
Ejercicio3	Reportes empresariales (PDF, Excel, CSV)	Template Method + Factory Method
Ejercicio4	Personajes de videojuego	Builder + Decorator
Ejercicio5	Integración con sistema bancario antiguo	Adapter + Facade
Ejercicio6	Motor de recomendaciones	Strategy + Observer
Ejercicio7	Flujo de aprobación de documentos	Chain of Responsibility + State
Ejercicio8	Pedidos en restaurante	Builder + Observer
Ejercicio9	Autenticación empresarial	Strategy + Chain of Responsibility
Ejercicio10	Edición de imágenes	Decorator + Command
Enlaces a cada README:
src/main/dosw/semana_3/Taller4/Ejercicio1/README.md
src/main/dosw/semana_3/Taller4/Ejercicio2/README.md
src/main/dosw/semana_3/Taller4/Ejercicio3/README.md
src/main/dosw/semana_3/Taller4/Ejercicio4/README.md
src/main/dosw/semana_3/Taller4/Ejercicio5/README.md
src/main/dosw/semana_3/Taller4/Ejercicio6/README.md
src/main/dosw/semana_3/Taller4/Ejercicio7/README.md
src/main/dosw/semana_3/Taller4/Ejercicio8/README.md
src/main/dosw/semana_3/Taller4/Ejercicio9/README.md
src/main/dosw/semana_3/Taller4/Ejercicio10/README.md
---
Tecnologías
Lenguaje: Java (uso de record, Stream API, Comparator, Collectors avanzados)
IDE: IntelliJ IDEA (carpeta .idea incluida)
Ejecución general
Cada ejercicio es autocontenido. Para los patrones de la semana 2 y el Taller 4:
```bash
cd src/main/dosw/<semana>/<carpeta-del-ejercicio>
javac *.java
java Main
```
Para los streams de la semana 1 y los Ejercicio1..20 de la semana 2, cada clase trae su propio main y se ejecuta individualmente:
```bash
cd src/main/dosw/semana_1/streams
javac Ejercicio1.java
java main.dosw.semana_1.streams.Ejercicio1
```
