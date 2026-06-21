# DOSW_BITACORA

Bitácora de Sara Viviana Arteaga para el curso de Diseño y Operación de Sistemas de Software (DOSW).

Este repositorio reúne, semana a semana, los ejercicios de práctica realizados en clase y en talleres: desde el manejo de la Stream API de Java hasta la aplicación de los patrones de diseño GoF (creacionales, estructurales y de comportamiento) sobre distintos casos de estudio.

---

## Estructura del repositorio

```
src/main/dosw/
├── semana_1/
│   └── streams             Introducción a la API de Streams de Java
├── semana_2/
│   └── pokemon             Streams avanzados + primer acercamiento a patrones de diseño
│       ├── Ejercicio1..20      (streams con tema Pokémon)
│       └── EjercicioNPatrones  (un patrón de diseño por carpeta, N = 1 a 12)
└── semana_3/
    └── Taller4             Taller integrador: 10 ejercicios, cada uno combina
        └── Ejercicio1..10      dos patrones de diseño sobre un caso de negocio real
```

Cada carpeta de ejercicio es independiente y contiene sus propias clases Java y, cuando aplica, su propio Main.java ejecutable.

Los ejercicios de semana_3/Taller4 ya cuentan cada uno con su propio README.md (descripción del problema, solución propuesta, patrones implementados, estructura de clases y ejecución), así que aquí solo se indexan. El resto de la bitácora (semana 1 y semana 2) se describe completa en este mismo documento.

---

## Semana 1 — Streams (semana_1/streams)

Cinco ejercicios introductorios a la API de Streams de Java (filter, map, sorted, collect, reduce, anyMatch) usando listas de números, palabras y record (usuarios, transacciones).

| Clase | Descripción |
|---|---|
| Ejercicio1 | Filtra de una lista de enteros los valores que son a la vez mayores a 10 y pares. |
| Ejercicio2 | Filtra palabras de longitud mayor a 4, las convierte a mayúsculas, las ordena alfabéticamente y cuenta cuántas quedan. |
| Ejercicio3 | Usa un record User(id, name, age, active) para extraer los nombres de los usuarios activos. |
| Ejercicio4 | Reutiliza el record User para filtrar usuarios activos y mayores de edad. |
| Ejercicio5 | Usa un record Transaction(id, amount, approved) para verificar con anyMatch si existen transacciones no aprobadas. |

---

## Semana 2 — Pokémon: Streams y Patrones (semana_2/pokemon)

### Streams (Ejercicio1 a Ejercicio20)

20 ejercicios de dificultad creciente sobre dos modelos de apoyo: Pokemon (id, nombre, tipo, nivel, poderCombate, región, legendario) y Entrenador (id, nombre, medallas, equipo de Pokemon).

| Clase | Operación principal |
|---|---|
| Ejercicio1 | filter por tipo de elemento sobre un record Pokemon(nombre, tipo) local. |
| Ejercicio2 | filter + map para transformar nombres a mayúsculas. |
| Ejercicio3 | reduce para sumar los niveles del equipo. |
| Ejercicio4 | filter sobre nivel y conteo de resultados. |
| Ejercicio5 | filter por nivel y conteo con collect. |
| Ejercicio6 | distinct para eliminar capturas duplicadas. |
| Ejercicio7 | sorted alfabético de la lista de pokémon. |
| Ejercicio8 | filter por bandera booleana (puede evolucionar). |
| Ejercicio9 | operaciones sobre la clase Pokemon con todos sus atributos. |
| Ejercicio10 | proyección de datos de la pokédex con map. |
| Ejercicio11 | cálculo estadístico sobre la pokédex. |
| Ejercicio12 | forEach sobre la pokédex. |
| Ejercicio13 | groupingBy por tipo o región. |
| Ejercicio14 | groupingBy con criterio adicional. |
| Ejercicio15 | entrenador con más medallas. |
| Ejercicio16 | filtro de entrenadores por medallas. |
| Ejercicio17 | entrenador con mayor poder de equipo. |
| Ejercicio18 | top de pokémon más fuertes. |
| Ejercicio19 | top de entrenadores. |
| Ejercicio20 | estadísticas combinadas del sistema. |

### Patrones de diseño (EjercicioNPatrones)

| Carpeta | Patrón | Caso de uso |
|---|---|---|
| Ejercicio1Patrones | Factory Method | Procesador de pagos con diferentes métodos |
| Ejercicio2Patrones | Abstract Factory | Motor de videojuegos por consola |
| Ejercicio3Patrones | Builder | Construcción de muñecos |
| Ejercicio4Patrones | Adapter | Adaptación de sistemas de carga |
| Ejercicio5Patrones | Bridge | Formas y colores desacoplados |
| Ejercicio6Patrones | Composite | Bodega de productos jerárquica |
| Ejercicio7Patrones | Decorator | Barco con módulos mejorables |
| Ejercicio8Patrones | Chain of Responsibility | Control migratorio |
| Ejercicio9Patrones | Command | Control de videojuego |
| Ejercicio10Patrones | (no implementado) | Pendiente |
| Ejercicio11Patrones | Strategy | Rutas de navegación |
| Ejercicio12Patrones | Strategy | Variantes de rutas |

---

## Semana 3 — Taller 4: Combinación de Patrones (semana_3/Taller4)

Taller integrador de 10 ejercicios donde cada uno combina dos patrones de diseño:

| Ejercicio | Caso de negocio | Patrones combinados |
|---|---|---|
| Ejercicio1 | Plataforma de pagos inteligente | Strategy + Factory Method |
| Ejercicio2 | Notificaciones multicanal | Observer + Factory Method |
| Ejercicio3 | Reportes empresariales | Template Method + Factory Method |
| Ejercicio4 | Personajes de videojuego | Builder + Decorator |
| Ejercicio5 | Sistema bancario antiguo | Adapter + Facade |
| Ejercicio6 | Motor de recomendaciones | Strategy + Observer |
| Ejercicio7 | Flujo de aprobación de documentos | Chain of Responsibility + State |
| Ejercicio8 | Pedidos en restaurante | Builder + Observer |
| Ejercicio9 | Autenticación empresarial | Strategy + Chain of Responsibility |
| Ejercicio10 | Edición de imágenes | Decorator + Command |

### Manual de Identidad

Documento complementario desarrollado durante la Semana 3, enfocado en la construcción de una identidad de marca alrededor de un producto. El manual presenta los elementos visuales, comunicativos y conceptuales necesarios para representar una propuesta de valor.

Este trabajo tiene como objetivo mostrar cómo un producto puede representar a su creador y vendedor, convirtiéndose en una extensión de sus cualidades, habilidades y fortalezas personales. A través de la identidad visual, la comunicación y la propuesta de valor, se busca transmitir características que permiten diferenciar el producto y generar una conexión más cercana con el público objetivo.

El manual incluye:

- Nombre e identidad de la marca
- Público objetivo
- Valores y propuesta de valor
- Elementos visuales de diseño
- Uso de colores y tipografías
- Aplicaciones de la identidad
- Estrategias de comunicación orientadas a fortalezas personales

Enlaces:

- src/main/dosw/semana_3/Taller4/Ejercicio1/README.md
- src/main/dosw/semana_3/Taller4/Ejercicio2/README.md
- src/main/dosw/semana_3/Taller4/Ejercicio3/README.md
- src/main/dosw/semana_3/Taller4/Ejercicio4/README.md
- src/main/dosw/semana_3/Taller4/Ejercicio5/README.md
- src/main/dosw/semana_3/Taller4/Ejercicio6/README.md
- src/main/dosw/semana_3/Taller4/Ejercicio7/README.md
- src/main/dosw/semana_3/Taller4/Ejercicio8/README.md
- src/main/dosw/semana_3/Taller4/Ejercicio9/README.md
- src/main/dosw/semana_3/Taller4/Ejercicio10/README.md
- src/main/dosw/semana_3/ManualIdentidad/README.md

---

## Tecnologías

- Lenguaje: Java (record, Stream API, Comparator, Collectors avanzados)
- IDE: IntelliJ IDEA (.idea incluido)

---

## Ejecución general

```bash
cd src/main/dosw/<semana>/<carpeta>
javac *.java
java Main
```

Streams (semana 1 y 2):

```bash
cd src/main/dosw/semana_1/streams
javac Ejercicio1.java
java main.dosw.semana_1.streams.Ejercicio1
```
