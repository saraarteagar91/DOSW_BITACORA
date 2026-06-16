# Ejercicio 04 — Plataforma de Videojuegos: Personajes

## Descripción del Problema

Un videojuego necesita crear personajes (guerreros, magos, arqueros) con atributos configurables: nombre, armadura, arma y habilidad especial. Al inicio de la partida el personaje se construye con esos atributos base. Durante el juego, el personaje puede adquirir mejoras temporales combinables: escudo de hielo, velocidad extra e invisibilidad. Cada poder modifica el comportamiento del ataque sin alterar el personaje base, y pueden apilarse en cualquier orden.

---

## Solución Propuesta

Se combinan dos patrones que actúan en momentos distintos del ciclo de vida del personaje:

- **Builder** resuelve la construcción al inicio. `CharacterBuilder` permite configurar el personaje paso a paso con una interfaz fluida (`setArmor().setWeapon().setSkill()`), evitando constructores con múltiples parámetros y garantizando que el objeto esté completo antes de ser usado.

- **Decorator** resuelve la adición dinámica de poderes durante la partida. Cada poder es un decorador que envuelve al personaje (o a otro decorador) y extiende el comportamiento de `attack()` sin modificar `BaseCharacter`. Esto evita la explosión combinatoria: sin Decorator serían necesarias 2^3 = 8 subclases para 3 poderes combinables; con Decorator son solo 3 wrappers y 1 clase base.

La interacción es: el usuario configura el personaje con el Builder → se llama `build()` obteniendo un `Character` base → durante la partida, el usuario activa poderes que van envolviendo el personaje en capas → cada llamada a `attack()` se propaga por todas las capas activas.

---

## Patrones de Diseño Implementados

### Builder
- **Builder:** `CharacterBuilder` — construye `Character` paso a paso con setters encadenados
- **Producto:** `BaseCharacter` — implementación concreta de `Character`, creada exclusivamente por el Builder

### Decorator
- **Componente:** `Character` — interfaz con `attack()` y `getDescription()`
- **Componente concreto:** `BaseCharacter` — implementación base que los decoradores envuelven
- **Decorator abstracto:** `CharacterDecorator` — mantiene referencia al `Character` envuelto
- **Decoradores concretos:** `ShieldDecorator` (bloquea 50% daño), `SpeedDecorator` (doble ataque), `InvisibilityDecorator` (crítico x3)

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `Character` | Interfaz | Componente base del patrón Decorator |
| `BaseCharacter` | Clase concreta | Producto del Builder, componente concreto del Decorator |
| `CharacterBuilder` | Builder | Construye `BaseCharacter` paso a paso |
| `CharacterDecorator` | Clase abstracta | Decorator base que envuelve cualquier `Character` |
| `ShieldDecorator` | Decorator concreto | Añade bloqueo de 50% de daño al ataque |
| `SpeedDecorator` | Decorator concreto | Duplica el número de ataques por turno |
| `InvisibilityDecorator` | Decorator concreto | Añade multiplicador x3 al daño del ataque |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 8 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Plataforma de Videojuegos: Personajes ===
Nombre del personaje: Ragnar
Tipo de armadura: Malla de acero
Tipo de arma: Hacha doble
Habilidad especial: Grito de guerra

Personaje creado: Ragnar | Armadura: Malla de acero | Arma: Hacha doble | Habilidad: Grito de guerra
-- Ataque base --
[Ragnar] Ataca con Hacha doble | Habilidad: Grito de guerra

Poderes disponibles: escudo, velocidad, invisibilidad
Ingrese poderes a activar separados por coma: escudo,velocidad

-- Ataque con poderes activos --
Estado: Ragnar | ... + Escudo de Hielo + Velocidad Extra
  +[Escudo de Hielo - bloquea 50% danio]
  +[Velocidad Extra - doble ataque]
[Ragnar] Ataca...
[Ragnar] Ataca...
```
