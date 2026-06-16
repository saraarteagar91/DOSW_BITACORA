# Ejercicio 06 — Motor de Recomendaciones

## Descripción del Problema

Una plataforma de streaming tipo Netflix permite a los usuarios cambiar su algoritmo de recomendación en cualquier momento: por género favorito, por historial de visualización, por popularidad o por similitud con otros usuarios. Cada vez que el usuario cambia su preferencia, múltiples componentes de la interfaz deben actualizarse automáticamente y de forma simultánea: la página principal, el servicio de notificaciones push y la lista de sugeridos.

---

## Solución Propuesta

Se combinan dos patrones que actúan sobre dimensiones distintas del problema:

- **Strategy** resuelve el intercambio del algoritmo de recomendación en tiempo de ejecución. Cada algoritmo implementa la interfaz `RecommendationAlgorithm` con el método `recommend(userId)`. El perfil del usuario mantiene una referencia a la estrategia activa y puede cambiarla sin afectar al resto del sistema.

- **Observer** resuelve la propagación automática del cambio. `UserProfile` es el Subject: cuando el usuario cambia su preferencia, notifica a todos los observadores registrados. Cada observador recibe el algoritmo nuevo y lo usa inmediatamente para actualizar su contenido. Agregar un nuevo componente de UI no requiere modificar `UserProfile`.

La interacción es: el usuario selecciona un algoritmo → `UserProfile.changePreference()` actualiza la estrategia y notifica a todos los Observers → cada Observer llama `algorithm.recommend(userId)` con el nuevo algoritmo y renderiza los resultados.

---

## Patrones de Diseño Implementados

### Strategy
- **Interfaz:** `RecommendationAlgorithm` — declara `recommend(String userId)`
- **Estrategias concretas:** `GenreStrategy`, `HistoryStrategy`, `PopularityStrategy`, `SimilarityStrategy`

### Observer
- **Subject:** `UserProfile` — mantiene la estrategia activa y la lista de observadores
- **Interfaz Observer:** `PreferenceObserver` — declara `onPreferenceChanged(userId, algorithm)`
- **Observadores concretos:** `HomePageComponent`, `NotificationService`, `SuggestedListComponent`

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `RecommendationAlgorithm` | Interfaz | Contrato del patrón Strategy |
| `GenreStrategy` | Estrategia concreta | Recomienda según género favorito del usuario |
| `HistoryStrategy` | Estrategia concreta | Recomienda según historial de visualización |
| `PopularityStrategy` | Estrategia concreta | Recomienda el contenido más visto globalmente |
| `SimilarityStrategy` | Estrategia concreta | Recomienda según usuarios con perfil similar |
| `PreferenceObserver` | Interfaz | Contrato del patrón Observer |
| `HomePageComponent` | Observer concreto | Actualiza la portada principal con las recomendaciones |
| `NotificationService` | Observer concreto | Envía notificación push con la primera recomendación |
| `SuggestedListComponent` | Observer concreto | Recalcula la lista lateral de sugeridos |
| `UserProfile` | Subject | Mantiene el algoritmo activo y notifica a los observadores |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

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
=== Motor de Recomendaciones ===
Ingrese su nombre de usuario: juanito
Algoritmos disponibles: genero, historial, popularidad, similitud

Seleccione algoritmo de recomendacion (o 'salir'): genero

Usuario juanito cambio preferencia:
  [HomePage]  Actualizando portada -> [Terror total, Comedia sin fin, Accion pura]
  [Push]      Enviando -> "Mira: Terror total"
  [Sugeridos] Recalculando -> [Terror total, Comedia sin fin, Accion pura]
```
