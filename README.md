# Proyecto de Bioinformática

Este es un proyecto académico de Bioinformática desarrollado en Java. Permite analizar secuencias de ADN, obtener la frecuencia y posiciones de tripletas (codones), identificar aminoácidos correspondientes, detectar colisiones en la tabla hash, y generar reportes completos del análisis genético.

## Características principales

- **Carga de secuencias:** Permite cargar archivos de texto con secuencias de ADN.
- **Análisis de tripletas:** Calcula frecuencia y posiciones de cada tripleta en la secuencia.
- **Codificación de aminoácidos:** Traduce tripletas a aminoácidos usando el código genético estándar.
- **Detección de tripletas de inicio y paro.**
- **Identificación de tripletas más y menos frecuentes.**
- **Detección de colisiones en la tabla hash.**
- **Interfaz gráfica intuitiva** para visualizar y buscar información sobre tripletas y aminoácidos.
- **Reportes completos** de tripletas y aminoácidos.

## Estructura del proyecto

```
src/
└── proyecto/
    └── bioinformática/
        ├── AminoacidosMapper.java
        ├── AnalizadorAminoacidos.java
        ├── ArbolFrecuencias.java
        ├── GestorSecuencia.java
        ├── HashTableTripletas.java
        ├── InterfazProyecto.java
        ├── NodoFrecuencia.java
        ├── ProyectoBioinformática.java
        └── Tripleta.java
```

### Clases principales

- **AminoacidosMapper:** Traducción de tripletas a aminoácidos.
- **AnalizadorAminoacidos:** Lógica de análisis y generación de reportes.
- **ArbolFrecuencias:** Estructura para ordenar tripletas por frecuencia.
- **GestorSecuencia:** Gestión de carga y validación de secuencias.
- **HashTableTripletas:** Tabla hash para almacenamiento eficiente de tripletas.
- **InterfazProyecto:** Interfaz gráfica de usuario.
- **NodoFrecuencia:** Nodo para el árbol de frecuencias.
- **ProyectoBioinformática:** Clase principal de arranque.
- **Tripleta:** Representación de una tripleta de ADN (codón).

## ¿Cómo usar?

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/cesarilja/Proyecto-de-Bioinformatica.git
   ```
2. **Abre el proyecto en tu IDE Java favorito** (NetBeans recomendado por los archivos `.form`).
3. **Compila el proyecto.**
4. **Ejecuta la clase `ProyectoBioinformática.java`** para iniciar la aplicación.

## Ejemplo de uso

- Haz clic en **"Cargar Secuencia"** y selecciona tu archivo `.txt` con la secuencia de ADN.
- Visualiza las tripletas, frecuencias y posiciones en la tabla.
- Busca tripletas específicas o genera reportes completos.
- Usa los botones para ver colisiones, aminoácidos o reportes.

## Requisitos

- Java 8 o superior
- NetBeans (opcional, recomendado)
- Sistema operativo compatible con Java

## Créditos

Desarrollado por [Cesarilja](https://github.com/cesarilja),[AlejandroSimanca] (https://github.com/AlejandroSimanca), [santiagosaturno] (https://github.com/santiagosaturno).

---

¡Esperamos que este proyecto te ayude en tus estudios y análisis bioinformáticos!