# Ejercicio 03 — Sistema de Reportes Empresariales

## Descripción del Problema

La empresa necesita generar reportes en tres formatos: PDF, Excel y CSV. Todos los reportes siguen exactamente el mismo flujo de 4 pasos: obtener datos → procesar información → aplicar formato → exportar archivo. Sin embargo, los pasos de formateo y exportación varían completamente según el formato destino. Además, el sistema debe poder crear el tipo de reporte correcto de forma dinámica sin que el cliente conozca las clases concretas.

---

## Solución Propuesta

Se combinan dos patrones para resolver las dos dimensiones del problema:

- **Template Method** resuelve el flujo fijo con pasos variables. La clase abstracta `ReportGenerator` define el método `final generate()` que ejecuta los 4 pasos en orden. Los pasos 1 y 2 (obtener y procesar datos) son fijos y están implementados en la clase base. Los pasos 3 y 4 (formatear y exportar) son abstractos: cada subclase los implementa a su manera. Esto garantiza que el algoritmo general nunca cambie, solo los detalles.

- **Factory Method** resuelve la creación dinámica. `ReportFactory` centraliza la instanciación: recibe un string con el formato deseado y retorna la instancia concreta correspondiente. El usuario solo interactúa con `ReportFactory` y con la interfaz `ReportGenerator`, nunca con `PdfReport`, `ExcelReport` o `CsvReport` directamente.

La interacción es: el usuario ingresa el formato → `ReportFactory.create()` instancia la subclase correcta → el cliente llama `generate()` → Template Method ejecuta los 4 pasos usando la implementación concreta para los pasos variables.

---

## Patrones de Diseño Implementados

### Template Method
- **Clase abstracta:** `ReportGenerator` — define `final generate()` con los 4 pasos; implementa los fijos (`fetchData`, `processData`) y declara abstractos los variables (`applyFormat`, `exportFile`)
- **Subclases concretas:** `PdfReport`, `ExcelReport`, `CsvReport` — implementan únicamente los pasos variables

### Factory Method
- **Fábrica:** `ReportFactory` — método estático `create(String type)` que retorna la instancia correcta de `ReportGenerator`

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `ReportGenerator` | Clase abstracta | Define el Template Method con los 4 pasos del algoritmo |
| `PdfReport` | Subclase concreta | Implementa `applyFormat` y `exportFile` para PDF |
| `ExcelReport` | Subclase concreta | Implementa `applyFormat` y `exportFile` para Excel |
| `CsvReport` | Subclase concreta | Implementa `applyFormat` y `exportFile` para CSV |
| `ReportFactory` | Fábrica estática | Crea la instancia correcta según el formato solicitado |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 6 clases**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Sistema de Reportes Empresariales ===
Formatos disponibles: PDF, EXCEL, CSV

Ingrese el formato del reporte (o 'salir'): PDF
Generando reporte PDF:
  [1] Obteniendo datos...
  [2] Procesando informacion...
  [3] Aplicando formato PDF...
  [4] Exportando reporte.pdf
Reporte generado exitosamente.
```
