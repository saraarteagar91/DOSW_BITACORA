# Ejercicio 08 — Sistema de Pedidos en Restaurante

## Descripción del Problema

Un restaurante necesita que el cliente pueda armar su pedido de hamburguesa eligiendo tamaño, tipo de carne, toppings y acompañantes. Una vez confirmado el pedido, el sistema debe notificar simultáneamente a todos los subsistemas involucrados: cocina (para preparar), facturación (para generar la cuenta) y domicilio (para preparar la ruta de entrega), sin que el pedido conozca directamente a ninguno de ellos.

---

## Solución Propuesta

Se combinan dos patrones que actúan en momentos distintos del ciclo de vida del pedido:

- **Builder** resuelve la construcción del pedido. `OrderBuilder` permite configurar el pedido paso a paso con métodos encadenados (`setSize().setMeat().addTopping().addSide()`). El método `build()` retorna un `Order` inmutable: una vez construido, ningún subsistema puede modificarlo accidentalmente. Se evita así un constructor caótico con todos los parámetros a la vez.

- **Observer** resuelve la notificación desacoplada al confirmar. `Order` actúa como Subject: cuando se llama `confirm()`, notifica a todos los observadores registrados. Cada subsistema (`KitchenService`, `BillingService`, `DeliveryService`) reacciona de forma independiente. El pedido no sabe cuántos ni cuáles subsistemas están escuchando.

La interacción es: el cliente configura el pedido con el Builder → llama `build()` obteniendo un `Order` inmutable → registra los observadores necesarios → llama `confirm()` → el `Order` notifica a cada Observer que ejecuta su propia lógica.

---

## Patrones de Diseño Implementados

### Builder
- **Builder:** `OrderBuilder` — configura `Order` con setters encadenados y valores por defecto
- **Producto:** `Order` — objeto inmutable creado por el Builder; su constructor es de acceso restringido al paquete

### Observer
- **Subject:** `Order` — mantiene lista de observadores y los notifica al confirmar
- **Interfaz Observer:** `OrderObserver` — declara `onOrderConfirmed(Order order)`
- **Observadores concretos:** `KitchenService`, `BillingService`, `DeliveryService`

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `OrderObserver` | Interfaz | Contrato del patrón Observer |
| `KitchenService` | Observer concreto | Recibe el pedido y lo prepara en cocina |
| `BillingService` | Observer concreto | Genera la cuenta con el total del pedido |
| `DeliveryService` | Observer concreto | Prepara la ruta de entrega con la dirección |
| `Order` | Producto + Subject | Objeto inmutable del Builder y Subject del Observer |
| `OrderBuilder` | Builder | Construye `Order` paso a paso con valores por defecto seguros |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 7 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Sistema de Pedidos en Restaurante ===
Tamano de la hamburguesa (sencilla/doble/triple): doble
Tipo de carne (res/pollo/vegetariana): res
Agregar toppings (separados por coma, o Enter para ninguno): queso,lechuga
Agregar acompanantes (separados por coma, o Enter para ninguno): papas
Direccion de entrega (o Enter para recoger en tienda): Calle 72 #10-35
Valor total del pedido: $32500
Servicios a notificar (separados por coma): cocina,facturacion,domicilio

Confirmando pedido...
  [Cocina]      Preparando: doble | res | extras:[queso, lechuga] | acomp:[papas]
  [Facturacion] Total: $32500.00
  [Domicilio]   Ruta para: Calle 72 #10-35
Pedido confirmado.
```
