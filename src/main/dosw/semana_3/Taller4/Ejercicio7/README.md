# Ejercicio 07 — Flujo de Aprobación de Documentos

## Descripción del Problema

Los documentos empresariales pasan por una cadena de revisión: autor, líder y área jurídica. No todos los documentos pasan por todas las etapas; la cadena puede configurarse según el tipo de documento. Paralelamente, cada documento tiene un estado propio que evoluciona: borrador, en revisión, aprobado o rechazado. Las transiciones entre estados dependen del resultado de cada revisor, y el sistema no debe tener condicionales del tipo `if(estado == BORRADOR)` dispersos por el código.

---

## Solución Propuesta

Se combinan dos patrones que gestionan aspectos ortogonales del problema:

- **Chain of Responsibility** resuelve el enrutamiento del documento por la cadena de revisores. Cada `DocumentHandler` evalúa si puede atender el documento según su estado actual; si puede, lo procesa; si no, lo pasa al siguiente en la cadena. La cadena se configura dinámicamente en tiempo de ejecución.

- **State** resuelve la gestión de estados sin condicionales. El `Document` delega las operaciones `approve()` y `reject()` al objeto de estado actual. Cada estado sabe exactamente a qué estado puede transicionar y qué operaciones son válidas. El documento nunca tiene un `switch` o `if/else` sobre su propio estado.

La interacción es: un handler de la cadena procesa el documento → llama `doc.approve()` o `doc.reject()` → el objeto `DocumentState` activo ejecuta la transición correspondiente cambiando el estado del documento → el siguiente handler lo recibe ya en su nuevo estado.

---

## Patrones de Diseño Implementados

### Chain of Responsibility
- **Handler abstracto:** `DocumentHandler` — define `handle(Document)`, `canHandle()`, `process()` y gestiona el encadenamiento
- **Handlers concretos:** `AutorHandler` (actúa en estado BORRADOR), `LiderHandler` (actúa en estado EN_REVISION, configurable si aprueba o rechaza), `JuridicoHandler` (actúa en estado EN_REVISION)

### State
- **Interfaz de estado:** `DocumentState` — declara `approve(Document)`, `reject(Document)` y `getStateName()`
- **Estados concretos:** `DraftState`, `InReviewState`, `ApprovedState`, `RejectedState`
- **Contexto:** `Document` — mantiene el estado actual y delega operaciones a él

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `DocumentState` | Interfaz | Contrato del patrón State |
| `DraftState` | Estado concreto | Comportamiento cuando el documento es borrador |
| `InReviewState` | Estado concreto | Comportamiento cuando el documento está en revisión |
| `ApprovedState` | Estado concreto | Comportamiento cuando el documento fue aprobado |
| `RejectedState` | Estado concreto | Comportamiento cuando el documento fue rechazado |
| `Document` | Contexto (State) | Mantiene el estado actual y delega `approve/reject` |
| `DocumentHandler` | Handler abstracto | Define la cadena y el flujo del Chain of Responsibility |
| `AutorHandler` | Handler concreto | Revisa documentos en estado BORRADOR |
| `LiderHandler` | Handler concreto | Revisa documentos en estado EN_REVISION (aprueba o rechaza según configuración) |
| `JuridicoHandler` | Handler concreto | Valida aspectos jurídicos en estado EN_REVISION |
| `Main` | Clase principal | Punto de entrada, configura la cadena e interactúa con el usuario |

**Total: 11 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Flujo de Aprobacion de Documentos ===
Ingrese el titulo del documento: Contrato de servicios
Documento 'Contrato de servicios' -> BORRADOR
Revisores disponibles: autor, lider, juridico
Ingrese la cadena de revisores en orden: autor,lider
  El lider aprueba? (si/no): si

-- Procesando documento --
[Autor]    Revision del autor OK.
  [State] Borrador enviado a revision.
[Lider]    Lider aprueba.
  [State] Documento aprobado.

Documento 'Contrato de servicios' -> APROBADO
```
