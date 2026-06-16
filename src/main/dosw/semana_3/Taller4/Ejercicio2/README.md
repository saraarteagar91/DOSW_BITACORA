# Ejercicio 02 — Sistema de Notificaciones Multicanal

## Descripción del Problema

Cuando un pedido cambia de estado (por ejemplo de PENDIENTE a ENVIADO o ENTREGADO), el sistema debe notificar automáticamente a todos los canales activos del usuario: correo electrónico, SMS y notificación push. No todos los usuarios tienen los mismos canales activos, y cada canal tiene su propia forma de construir y formatear el mensaje internamente.

---

## Solución Propuesta

Se combinan dos patrones para desacoplar completamente el emisor del mensaje de su construcción y entrega:

- **Observer** resuelve el desacoplamiento entre el pedido y los canales. El `Pedido` es el Subject: mantiene una lista de observadores y los notifica cuando cambia de estado. Agregar o quitar un canal no requiere modificar el `Pedido` en absoluto.

- **Factory Method** resuelve la construcción del mensaje por canal. Cada notificador tiene su propia `MessageFactory` que sabe exactamente cómo formatear el mensaje para ese canal: HTML para email, texto plano de máximo 160 caracteres para SMS, y JSON para push. La lógica de construcción queda aislada en cada fábrica.

La interacción es: el `Pedido` cambia de estado → llama `notify(event)` en cada Observer registrado → cada Observer invoca su `MessageFactory` para construir el mensaje en el formato correcto → lo envía por su canal.

---

## Patrones de Diseño Implementados

### Observer
- **Subject:** `Pedido` — mantiene la lista de observadores y notifica cambios de estado
- **Interfaz Observer:** `NotificationObserver` — declara `notify(OrderEvent event)`
- **Observadores concretos:** `EmailNotifier`, `SmsNotifier`, `PushNotifier`
- **Evento:** `OrderEvent` — encapsula el ID del pedido y el nuevo estado

### Factory Method
- **Interfaz de fábrica:** `MessageFactory` — declara `build(OrderEvent event)`
- **Fábricas concretas:** `EmailMessageFactory` (genera HTML), `SmsMessageFactory` (texto plano ≤160 chars), `PushMessageFactory` (payload JSON)

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `OrderEvent` | Clase de datos | Encapsula ID y estado del pedido para propagarlo |
| `MessageFactory` | Interfaz | Contrato Factory Method para construir mensajes |
| `EmailMessageFactory` | Clase concreta | Construye mensajes en formato HTML |
| `SmsMessageFactory` | Clase concreta | Construye mensajes de texto plano ≤160 caracteres |
| `PushMessageFactory` | Clase concreta | Construye payload JSON para notificación push |
| `NotificationObserver` | Interfaz | Contrato del patrón Observer |
| `EmailNotifier` | Observer concreto | Usa `EmailMessageFactory` y envía por correo |
| `SmsNotifier` | Observer concreto | Usa `SmsMessageFactory` y envía por SMS |
| `PushNotifier` | Observer concreto | Usa `PushMessageFactory` y envía push |
| `Pedido` | Subject (Observer) | Mantiene observadores y notifica al cambiar de estado |
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
=== Sistema de Notificaciones Multicanal ===
Ingrese el ID del pedido: ORD-99
Canales disponibles: email, sms, push
Ingrese los canales activos separados por coma: email,sms,push
Ingrese nuevo estado del pedido (o 'salir' para terminar): ENVIADO

-- Pedido ORD-99 -> ENVIADO --
[EMAIL] <html><p>Pedido <b>ORD-99</b> -> <b>ENVIADO</b></p></html>
[SMS]   Pedido ORD-99: ENVIADO
[PUSH]  {"order":"ORD-99","status":"ENVIADO"}
```
