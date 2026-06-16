# Ejercicio 05 — Integración con Sistema Bancario Antiguo

## Descripción del Problema

El sistema moderno de pagos trabaja con una interfaz `PaymentProcessor` que expone métodos claros como `pay(double amount)` y `getBalance()`. Sin embargo, el banco con el que se debe integrar expone un servicio legado (`LegacyBankService`) con una API completamente incompatible: maneja montos en centavos enteros, usa IDs de cuenta como parámetros posicionales y sus métodos tienen nombres distintos (`executeTransaction`, `verifyBalance`). Además, inicializar correctamente ese servicio legado requiere 8 pasos de configuración que los desarrolladores no deberían conocer ni repetir.

---

## Solución Propuesta

Se aplican dos patrones con responsabilidades complementarias y no excluyentes:

- **Adapter** resuelve la incompatibilidad de interfaces. `LegacyBankAdapter` implementa `PaymentProcessor` e internamente traduce cada llamada moderna al formato legado: convierte montos de pesos a centavos (`amount * 100`), gestiona el ID de cuenta fijo y mapea `pay()` → `executeTransaction()` y `getBalance()` → `verifyBalance()`. El sistema moderno nunca toca `LegacyBankService` directamente.

- **Facade** resuelve la complejidad de inicialización. `BankFacade` expone únicamente dos métodos simples: `procesarPago(monto)` y `consultarSaldo()`. Internamente ejecuta los 8 pasos de configuración en su constructor y delega las operaciones al `LegacyBankAdapter`. El desarrollador obtiene acceso completo al banco legado con solo instanciar `BankFacade`.

La interacción es: el usuario llama métodos de `BankFacade` → Facade inicializa y delega al `LegacyBankAdapter` → Adapter traduce al formato legado → `LegacyBankService` ejecuta la operación real.

---

## Patrones de Diseño Implementados

### Adapter
- **Interfaz objetivo:** `PaymentProcessor` — interfaz moderna que el sistema espera
- **Adaptee:** `LegacyBankService` — sistema legado con API incompatible
- **Adapter:** `LegacyBankAdapter` — implementa `PaymentProcessor` y traduce llamadas a `LegacyBankService`

### Facade
- **Facade:** `BankFacade` — simplifica el uso del sistema completo, oculta los 8 pasos de inicialización y usa internamente al Adapter

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `PaymentProcessor` | Interfaz | Interfaz moderna objetivo del patrón Adapter |
| `LegacyBankService` | Clase legada | Sistema bancario antiguo con API incompatible (centavos, IDs) |
| `LegacyBankAdapter` | Adapter | Implementa `PaymentProcessor` traduciendo llamadas al formato legado |
| `BankFacade` | Facade | Oculta los 8 pasos de inicialización y expone API simple al desarrollador |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 5 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Integracion con Sistema Bancario Antiguo ===
Ingrese saldo inicial de la cuenta: $5000
Inicializando sistema bancario...
  [Facade] Paso 1: Verificando certificados SSL...
  ...
  [Facade] Paso 8: Sistema listo.

  [LEGACY] verifyBalance('ACC-001') -> 500000 centavos
Saldo actual: $5000.00

Ingrese monto a pagar (o 0 para salir): $120.50
  [LEGACY] executeTransaction('ACC-001', 12050 centavos) -> OK
Resultado: APROBADO
```
