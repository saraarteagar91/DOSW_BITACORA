# Ejercicio 01 — Plataforma de Pagos Inteligentes

## Descripción del Problema

Una aplicación de e-commerce necesita soportar múltiples métodos de pago según el país del usuario. Colombia dispone de PSE, Nequi y Tarjeta de crédito; USA dispone de PayPal y Stripe. El sistema debe seleccionar automáticamente el proveedor correcto según el país y delegar el procesamiento al método elegido, sin que el flujo de compra cambie en absoluto.

---

## Solución Propuesta

Se combinan dos patrones para separar responsabilidades claramente:

- **Strategy** resuelve *cómo se ejecuta el pago*: cada método de pago es una clase independiente que implementa la misma interfaz. El `Checkout` nunca sabe con qué medio está trabajando, simplemente llama `process(amount)`.

- **Factory Method** resuelve *quién construye el método correcto*: dependiendo del país del usuario, una fábrica concreta instancia la estrategia adecuada. El cliente (Main) solo pide la fábrica por país y luego el método por nombre; nunca instancia nada directamente.

La interacción es la siguiente: el usuario ingresa su país → `PaymentFactoryProvider` selecciona la fábrica correspondiente → la fábrica crea la `PaymentStrategy` concreta → `Checkout` ejecuta el pago usando esa estrategia.

Sin Factory, el `Checkout` o el `Main` tendrían que saber qué estrategia instanciar para cada país, generando acoplamiento fuerte. Sin Strategy, habría condicionales `if/else` dentro del flujo de compra para cada método de pago.

---

## Patrones de Diseño Implementados

### Strategy
- **Interfaz:** `PaymentStrategy` — declara el contrato `process(double amount)`
- **Implementaciones concretas:** `TarjetaStrategy`, `PseStrategy`, `NequiStrategy`, `PaypalStrategy`, `StripeStrategy`
- **Contexto:** `Checkout` — recibe cualquier `PaymentStrategy` y ejecuta la compra sin conocer la implementación

### Factory Method
- **Interfaz de fábrica:** `PaymentFactory` — declara `create(String type)`
- **Fábricas concretas:** `ColombiaPaymentFactory` (crea PSE, Nequi, Tarjeta), `UsaPaymentFactory` (crea PayPal, Stripe)
- **Proveedor de fábricas:** `PaymentFactoryProvider` — selecciona la fábrica concreta según el país ingresado

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `PaymentStrategy` | Interfaz | Contrato del patrón Strategy |
| `TarjetaStrategy` | Clase concreta | Estrategia de pago con tarjeta |
| `PseStrategy` | Clase concreta | Estrategia de pago por PSE |
| `NequiStrategy` | Clase concreta | Estrategia de pago por Nequi |
| `PaypalStrategy` | Clase concreta | Estrategia de pago por PayPal |
| `StripeStrategy` | Clase concreta | Estrategia de pago por Stripe |
| `PaymentFactory` | Interfaz | Contrato del patrón Factory Method |
| `ColombiaPaymentFactory` | Clase concreta | Fábrica de métodos de pago para Colombia |
| `UsaPaymentFactory` | Clase concreta | Fábrica de métodos de pago para USA |
| `PaymentFactoryProvider` | Clase utilitaria | Selecciona la fábrica según el país |
| `Checkout` | Clase contexto | Ejecuta la compra usando la Strategy |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 12 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Plataforma de Pagos Inteligentes ===
Ingrese su pais (colombia / usa): colombia
Metodos disponibles: pse, nequi, tarjeta
Elija metodo de pago: pse
Ingrese el monto a pagar: $150000
Procesando compra...
[PSE] Debito bancario de $150000.00 procesado.
Compra completada exitosamente.
```
