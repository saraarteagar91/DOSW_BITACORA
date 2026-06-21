# DOSW_BITACORA

Bitácora de Sara Viviana Arteaga para el curso DOSW.

Este repositorio reúne, semana a semana, los ejercicios de práctica realizados en clase y en talleres.

---
# DOSW_BITACORA

Bitácora de Sara Viviana Arteaga para el curso DOSW.

Este repositorio reúne, semana a semana, los ejercicios de práctica realizados en clase y en talleres.

---

## Estructura del repositorio

```
src/main/dosw/
├── semana_1/
│   └── streams             
├── semana_2/
│   └── pokemon            
│       ├── Ejercicio1..20      
│       └── EjercicioNPatrones  
└── semana_3/
    └── Taller4            
        └── Ejercicio1..10     
```

Los ejercicios de semana_3/Taller4 ya cuentan cada uno con su propio README.md con descripción del problema, solución propuesta, patrones implementados, estructura de clases y ejecución. El resto de la bitácora de semana 1 y semana 2 se describe completa en este mismo documento.

---

## Semana 1 — Streams (semana_1/streams)

Contiene cinco ejercicios introductorios a la API de Streams de Java (filter, map, sorted, collect, reduce, anyMatch) usando listas de números, palabras y record.

| Clase | Descripción |
|---|---|
| Ejercicio1 | Filtra de una lista de enteros los valores que son a la vez mayores a 10 y pares. |
| Ejercicio2 | Filtra palabras de longitud mayor a 4, las convierte a mayúsculas, las ordena alfabéticamente y cuenta cuántas quedan. |
| Ejercicio3 | Usa un record User(id, name, age, active) para extraer los nombres de los usuarios activos. |
| Ejercicio4 | Reutiliza el record User para filtrar usuarios activos y mayores de edad. |
| Ejercicio5 | Usa un record Transaction(id, amount, approved) para verificar con anyMatch si existen transacciones no aprobadas. |

---

## Semana 2 — Pokémon: Streams y Patrones (semana_2/pokemon)

### Streams

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

### Patrones de diseño 

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

A continuación, el esquema de clases de cada ejercicio de patrones.

#### Ejercicio1Patrones — Factory Method

| Clase / Interfaz | Rol |
|---|---|
| MetodoPago | Interfaz del producto (procesarPago) |
| TarjetaCredito, PayPal, TransferenciaBancaria | Productos concretos |
| PagoFactory | Creador abstracto, declara el factory method y el flujo común (procesarPago) |
| TarjetaCreditoFactory, PayPalFactory, TransferenciaBancariaFactory | Creadores concretos, cada uno fabrica su propio MetodoPago |
| Main | Clase de prueba, ejecuta el flujo con cada fábrica |

#### Ejercicio2Patrones — Abstract Factory

| Clase / Interfaz | Rol |
|---|---|
| Control, Juego, InterfazGrafica | Interfaces de productos |
| ControlPlayStation, JuegoPlayStation, InterfazGraficaPlayStation | Familia de productos PlayStation |
| ControlXbox, JuegoXbox, InterfazGraficaXbox | Familia de productos Xbox |
| ConsolaFactory | Fábrica abstracta |
| PlayStationFactory, XboxFactory | Fábricas concretas |
| Main | Cliente y clase de prueba, arma los componentes a través de las interfaces sin conocer la consola concreta |

#### Ejercicio3Patrones — Builder

| Clase / Interfaz | Rol |
|---|---|
| Muneco | Producto complejo a construir |
| MunecoBuilder | Interfaz constructora, declara los pasos del ensamblaje |
| MunecoAccionBuilder, MunecoClasicaBuilder | Builders concretos |
| Director | Director, ejecuta la secuencia de construcción sobre el builder activo |
| Main | Clase de prueba |

#### Ejercicio4Patrones — Adapter

| Clase / Interfaz | Rol |
|---|---|
| SistemaAbastecimiento | Interfaz objetivo esperada por el cliente |
| VehiculoCombustion | Implementación nativa de la interfaz objetivo |
| CargadorRapido, CargadorLento | Clases adaptadas, interfaz incompatible (cargar) |
| AdaptadorCargadorRapido, AdaptadorCargadorLento | Adaptadores, traducen abastecer a cargar |
| Main | Clase de prueba |

#### Ejercicio5Patrones — Bridge

| Clase / Interfaz | Rol |
|---|---|
| Forma | Abstracción, mantiene una referencia a Color |
| Circulo, Cuadrado | Abstracciones refinadas |
| Color | Interfaz de implementación (aplicarColor) |
| Rojo, Azul | Implementaciones concretas del color |
| Main | Clase de prueba |

#### Ejercicio6Patrones — Composite

| Clase / Interfaz | Rol |
|---|---|
| ItemBodega | Componente, interfaz común para hojas y compuestos |
| Producto | Hoja, artículo individual con precio fijo |
| Caja | Compuesto, contiene una lista de ItemBodega y agrega sus resultados |
| Main | Clase de prueba |

#### Ejercicio7Patrones — Decorator

| Clase / Interfaz | Rol |
|---|---|
| Barco | Componente, contrato común |
| BarcoBasico | Componente concreto, barco sin módulos |
| BarcoDecorador | Decorador abstracto, envuelve un Barco y delega por defecto |
| BlindajeReforzado, RadarAvanzado, Misiles, SistemaAntitorpedos | Decoradores concretos |
| Main | Clase de prueba |

#### Ejercicio8Patrones — Chain of Responsibility

| Clase / Interfaz | Rol |
|---|---|
| ControlMigratorio | Manejador abstracto, mantiene el enlace al siguiente control |
| RevisionPassaporteVisa, ControlAntecedentes, RevisionMotivoViaje, AprobacionFinal | Manejadores concretos, cada uno valida un aspecto y delega al siguiente |
| Persona | Objeto de solicitud que recorre la cadena |
| Main | Clase de prueba |

#### Ejercicio9Patrones — Command

| Clase / Interfaz | Rol |
|---|---|
| Comando | Interfaz del comando (ejecutar) |
| ComandoCaminar, ComandoSaltar, ComandoAtacar, ComandoDefenderse | Comandos concretos, encapsulan la invocación sobre Personaje |
| Personaje | Receptor, clase que realmente ejecuta la acción |
| ControlJuego | Invocador, dispara el comando asignado a cada botón |
| Main | Clase de prueba |

#### Ejercicio10Patrones — No implementado

No existe esta carpeta en el repositorio. El ejercicio 10 de patrones quedó pendiente.

#### Ejercicio11Patrones — Strategy

| Clase / Interfaz | Rol |
|---|---|
| EstrategiaRuta | Interfaz de la estrategia (calcularRuta) |
| RutaBicicleta, RutaCarretera, RutaTransportePublico | Estrategias concretas |
| AppNavegacion | Contexto, usa la estrategia activa para calcular la ruta |
| Main | Clase de prueba |

#### Ejercicio12Patrones — Strategy

| Clase / Interfaz | Rol |
|---|---|
| EstrategiaRuta | Interfaz de la estrategia (calcularRuta) |
| RutaBicicleta, RutaCarretera, RutaPie, RutaTransportePublico | Estrategias concretas, agrega RutaPie respecto al ejercicio 11 |
| AppNavegacion | Contexto, usa la estrategia activa para calcular la ruta |
| Main | Clase de prueba |

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

- Nombre y eslogan de la marca
- Público objetivo
- Elementos visuales de diseño
- Uso de colores y tipografías

---

## Tecnologías

- Lenguaje: Java (record, Stream API, Comparator, Collectors avanzados)
- IDE: IntelliJ IDEA (.idea incluido)

## Estructura del repositorio

```
src/main/dosw/
├── semana_1/
│   └── streams             
├── semana_2/
│   └── pokemon            
│       ├── Ejercicio1..20      
│       └── EjercicioNPatrones  
└── semana_3/
    └── Taller4            
        └── Ejercicio1..10     
```

Los ejercicios de semana_3/Taller4 ya cuentan cada uno con su propio README.md con descripción del problema, solución propuesta, patrones implementados, estructura de clases y ejecución. El resto de la bitácora de semana 1 y semana 2 se describe completa en este mismo documento.

---

## Semana 1 — Streams (semana_1/streams)

Contiene cinco ejercicios introductorios a la API de Streams de Java (filter, map, sorted, collect, reduce, anyMatch) usando listas de números, palabras y record.

| Clase | Descripción |
|---|---|
| Ejercicio1 | Filtra de una lista de enteros los valores que son a la vez mayores a 10 y pares. |
| Ejercicio2 | Filtra palabras de longitud mayor a 4, las convierte a mayúsculas, las ordena alfabéticamente y cuenta cuántas quedan. |
| Ejercicio3 | Usa un record User(id, name, age, active) para extraer los nombres de los usuarios activos. |
| Ejercicio4 | Reutiliza el record User para filtrar usuarios activos y mayores de edad. |
| Ejercicio5 | Usa un record Transaction(id, amount, approved) para verificar con anyMatch si existen transacciones no aprobadas. |

---

## Semana 2 — Pokémon: Streams y Patrones (semana_2/pokemon)

### Streams

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

### Patrones de diseño 

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

- Nombre y eslogan de la marca
- Público objetivo
- Elementos visuales de diseño
- Uso de colores y tipografías

---

## Tecnologías

- Lenguaje: Java (record, Stream API, Comparator, Collectors avanzados)
- IDE: IntelliJ IDEA (.idea incluido)

---
```
