# Ejercicio 09 — Sistema de Autenticación Empresarial

## Descripción del Problema

La empresa maneja cinco métodos de autenticación: contraseña, Google OAuth, Microsoft, token empresarial y biometría. Según el tipo de usuario, el sistema selecciona el mecanismo correcto. Una vez autenticado exitosamente, la solicitud debe pasar por cuatro validaciones en secuencia: credenciales válidas, permisos del rol, ubicación geográfica autorizada y horario laboral permitido. Si cualquier validación falla, el acceso se deniega sin continuar con las siguientes.

---

## Solución Propuesta

Se combinan dos patrones que representan dos fases completamente distintas del proceso de acceso:

- **Strategy** resuelve la fase de autenticación: *¿quién eres?* Cada mecanismo de autenticación implementa `AuthStrategy` con el método `authenticate(Credentials)`. El `AuthService` recibe la estrategia adecuada y la ejecuta sin saber si es contraseña, biometría u OAuth. Cambiar o agregar un mecanismo no afecta al resto del sistema.

- **Chain of Responsibility** resuelve la fase de autorización: *¿qué puedes hacer?* Los cuatro validadores se encadenan: `CredentialValidator → PermissionValidator → LocationValidator → TimeValidator`. Cada uno evalúa su condición y, si falla, detiene la cadena inmediatamente. Si todos aprueban, se concede el acceso.

La interacción es: el usuario elige método y proporciona credenciales → Strategy autentica y produce un `AuthResult` → el resultado recorre la cadena de validadores → si todos aprueban, acceso concedido.

---

## Patrones de Diseño Implementados

### Strategy
- **Interfaz:** `AuthStrategy` — declara `authenticate(Credentials)`
- **Estrategias concretas:** `PasswordStrategy` (verifica prefijo `PWD_`), `GoogleStrategy` (verifica prefijo `GOOGLE_`), `BiometricStrategy` (verifica prefijo `BIO_`)
- **Resultado:** `AuthResult` — encapsula si la autenticación fue exitosa y el rol del usuario
- **Datos de entrada:** `Credentials` — encapsula usuario, token, país y hora

### Chain of Responsibility
- **Validator abstracto:** `AuthValidator` — define `validate()` y gestiona el encadenamiento
- **Validators concretos:** `CredentialValidator`, `PermissionValidator`, `LocationValidator`, `TimeValidator`
- **Orquestador:** `AuthService` — construye la cadena y coordina Strategy + Chain

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `Credentials` | Clase de datos | Encapsula usuario, token, país y hora de acceso |
| `AuthResult` | Clase de datos | Encapsula resultado de autenticación y rol del usuario |
| `AuthStrategy` | Interfaz | Contrato del patrón Strategy |
| `PasswordStrategy` | Estrategia concreta | Autentica verificando prefijo `PWD_` en el token |
| `GoogleStrategy` | Estrategia concreta | Autentica verificando prefijo `GOOGLE_` en el token |
| `BiometricStrategy` | Estrategia concreta | Autentica verificando prefijo `BIO_` en el token |
| `AuthValidator` | Validator abstracto | Define la cadena y el flujo del Chain of Responsibility |
| `CredentialValidator` | Validator concreto | Verifica que la autenticación fue exitosa |
| `PermissionValidator` | Validator concreto | Verifica que el rol del usuario tiene permisos |
| `LocationValidator` | Validator concreto | Verifica que el país de acceso está autorizado |
| `TimeValidator` | Validator concreto | Verifica que la hora de acceso está dentro del horario permitido |
| `AuthService` | Orquestador | Construye la cadena y coordina ambos patrones |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 13 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Sistema de Autenticacion Empresarial ===
Nombre de usuario (o 'salir'): juan.perez
Metodos: password, google, biometria
Metodo de autenticacion: google
Token de acceso: GOOGLE_abc123
Pais de acceso: Colombia
Hora de acceso (0-23): 10
  [Google]    Verificando OAuth... OK
  [Credencial] OK
  [Permisos]   Rol: USER -> OK
  [Ubicacion]  Colombia -> OK
  [Horario]    Hora 10:00 -> OK
Resultado: ACCESO CONCEDIDO
```
