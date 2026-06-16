# Ejercicio 10 — Aplicación de Edición de Imágenes

## Descripción del Problema

Una aplicación de edición permite aplicar filtros acumulativos sobre una imagen: blanco y negro, sepia, brillo ajustable y contraste. El usuario puede apilarlos en cualquier orden. Adicionalmente, cada acción debe poder deshacerse de forma individual (no solo la última), y también rehacerse. La imagen base nunca debe modificarse.

---

## Solución Propuesta

Se combinan dos patrones que se complementan perfectamente:

- **Decorator** resuelve la aplicación acumulativa de filtros. Cada filtro es un decorador que envuelve la imagen anterior y extiende su método `render()`. La imagen base nunca cambia; los filtros se apilan como capas. Al llamar `render()` en el decorador más externo, la llamada se propaga hacia adentro acumulando todas las transformaciones.

- **Command** resuelve el historial de operaciones y el undo/redo. Cada aplicación de filtro se encapsula en un objeto comando con `execute()` y `undo()`. Antes de ejecutar, el comando guarda el estado previo de la imagen en `ImageContext`. El `ImageEditor` mantiene dos pilas: `history` para deshacer y `redoStack` para rehacer. El undo simplemente restaura el estado guardado por el comando.

La interacción es: el usuario elige aplicar un filtro → el `Command` guarda el estado actual y envuelve la imagen con el `Decorator` correspondiente → el comando se apila en el historial → al deshacer, el `Command` restaura el estado previo eliminando la capa del `Decorator`.

---

## Patrones de Diseño Implementados

### Decorator
- **Componente:** `Image` — interfaz con `render()`
- **Componente concreto:** `BaseImage` — imagen original, nunca modificada
- **Decorator abstracto:** `ImageDecorator` — mantiene referencia a la imagen envuelta
- **Decoradores concretos:** `GrayscaleDecorator`, `SepiaDecorator`, `BrightnessDecorator`, `ContrastDecorator`

### Command
- **Interfaz:** `ImageCommand` — declara `execute()`, `undo()` y `getName()`
- **Comandos concretos:** `ApplyGrayscaleCommand`, `ApplySepiaCommand`, `ApplyBrightnessCommand`, `ApplyContrastCommand`
- **Contexto compartido:** `ImageContext` — mantiene referencia a la imagen actual, compartida entre comandos y editor
- **Invocador:** `ImageEditor` — gestiona las pilas `history` y `redoStack` para undo/redo

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `Image` | Interfaz | Componente base del patrón Decorator |
| `BaseImage` | Clase concreta | Imagen original, nunca modificada directamente |
| `ImageDecorator` | Clase abstracta | Decorator base que envuelve cualquier `Image` |
| `GrayscaleDecorator` | Decorator concreto | Aplica filtro de escala de grises |
| `SepiaDecorator` | Decorator concreto | Aplica filtro de tono sepia |
| `BrightnessDecorator` | Decorator concreto | Aumenta el brillo según el nivel indicado |
| `ContrastDecorator` | Decorator concreto | Aplica ajuste de contraste |
| `ImageCommand` | Interfaz | Contrato del patrón Command con `execute` y `undo` |
| `ImageContext` | Clase de contexto | Mantiene referencia mutable a la imagen actual |
| `ApplyGrayscaleCommand` | Command concreto | Aplica/deshace el filtro de escala de grises |
| `ApplySepiaCommand` | Command concreto | Aplica/deshace el filtro sepia |
| `ApplyBrightnessCommand` | Command concreto | Aplica/deshace el filtro de brillo con nivel configurable |
| `ApplyContrastCommand` | Command concreto | Aplica/deshace el filtro de contraste |
| `ImageEditor` | Invocador | Gestiona las pilas de historial y rehacer para undo/redo |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 15 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Aplicacion de Edicion de Imagenes ===
Nombre del archivo de imagen: foto.jpg
Imagen cargada: [Base:foto.jpg]

Comandos: aplicar, deshacer, rehacer, salir
Filtros disponibles: blanconegro, sepia, brillo, contraste

Comando: aplicar
  Filtro a aplicar: blanconegro
  [+] Filtro BlancoNegro aplicado.
  Vista: [Base:foto.jpg] -> [BlancoNegro]

Comando: deshacer
  [-] Filtro BlancoNegro removido.
  Vista: [Base:foto.jpg]
```
