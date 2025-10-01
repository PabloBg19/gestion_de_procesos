# gestion_de_procesos

# CONTADOR PALABRAS
# 📝 Contador de Palabras

Un proyecto en **Java** que cuenta el número total de palabras introducidas por consola.  
Está configurado con **Maven** y se empaqueta como un **JAR ejecutable** para poder ejecutarse fácilmente en cualquier máquina con Java instalado.

---

## 📖 Descripción del funcionamiento

El programa principal está en la clase `contadorPalabras.java` y funciona de la siguiente manera:

1. **Lectura de entrada:**  
   Usa `InputStreamReader` y `BufferedReader` para leer texto línea por línea desde la entrada estándar (la consola).

   ```java
   InputStreamReader isr = new InputStreamReader(System.in);
   BufferedReader br = new BufferedReader(isr);
   ```

2. **Procesamiento de líneas:**  
   Mientras haya texto (`readLine()` no devuelve `null`), se procesa cada línea.  
   Con `trim()` se eliminan espacios al inicio y final, y si la línea no está vacía se continúa.

3. **Separación en palabras:**  
   Se divide el texto en palabras usando `split("\s+")`, donde `\s+` significa “uno o más espacios en blanco”.

   ```java
   String[] palabras = linea.split("\s+");
   contadorPalabras += palabras.length;
   ```

4. **Contador acumulado:**  
   Se van sumando las palabras de cada línea.

5. **Resultado final:**  
   Al terminar la entrada (con `CTRL+Z` en Windows o `CTRL+D` en Linux/Mac), se muestra el número total de palabras.

   ```java
   System.out.println("Número total de palabras: " + contadorPalabras);
   ```

---

## ⚙️ Explicación del `pom.xml`

El archivo `pom.xml` define cómo Maven debe construir el proyecto.

### Datos básicos
```xml
<groupId>org.example</groupId>
<artifactId>contadorPalabras</artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>jar</packaging>
```
📌 Identifican el proyecto y especifican que se construirá un **JAR**.

---

### Dependencias
```xml
<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>3.8.1</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```
📌 Añade **JUnit** para poder escribir y ejecutar tests automáticos.

---

### Configuración del `build`
```xml
<build>
    <finalName>contadorpalabras</finalName>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.4.1</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>contadorpalabras.contadorPalabras</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

- **`<finalName>`** → Define el nombre final del JAR (`contadorpalabras.jar`).  
- **`maven-jar-plugin`** → Configura cómo se empaqueta el JAR.  
- **`<mainClass>`** → Define el punto de entrada del programa (`contadorpalabras.contadorPalabras`).  

👉 Gracias a esto, puedes ejecutar el JAR directamente con `java -jar`.

---

## 🚀 Ejecución del programa

### 1. Compilar y empaquetar
```bash
mvn clean package
```

Esto genera el archivo:
```
target/contadorpalabras.jar
```

### 2. Ejecutar el programa
```bash
java -jar target/contadorpalabras.jar
```

Ejemplo de uso:

Entrada:
```
Hola mundo
Este es un ejemplo
```

Salida:
```
Número total de palabras: 5
```

---

## 📂 Estructura del proyecto

```
contadorPalabras/
├── pom.xml                  # Configuración Maven
├── src/
│   ├── main/
│   │   └── java/
│   │       └── contadorpalabras/
│   │           └── contadorPalabras.java
│   └── test/
│       └── java/
│           └── contadorpalabras/
│               └── contadorPalabrasTest.java
```

---


##FILTRAR LINEAS
# 📑 Filtrar Líneas

Un proyecto en **Java** que lee texto desde la entrada estándar (consola o archivo) y muestra **solo aquellas líneas que tengan más de 20 caracteres**.  

Está configurado con **Maven** y se empaqueta como un **JAR ejecutable**.

---

## 📖 Descripción del funcionamiento

El código principal está en la clase `FiltrarLineas.java`:

1. **Lectura de entrada:**  
   Se usa `InputStreamReader` y `BufferedReader` para leer líneas de texto introducidas por el usuario.

   ```java
   InputStreamReader isr = new InputStreamReader(System.in);
   BufferedReader br = new BufferedReader(isr);
   ```

2. **Procesamiento de líneas:**  
   Cada línea se comprueba con `linea.length() > 20`.  
   Si la condición se cumple, se imprime en pantalla.

   ```java
   if (linea.length() > 20) {
       System.out.println(linea);
   }
   ```

3. **Finalización:**  
   - Si la entrada termina (CTRL+Z en Windows o CTRL+D en Linux/Mac), el programa se detiene.  
   - Se cierran los flujos de entrada (`br.close()` y `isr.close()`).  
   - Si ocurre un error de lectura, se muestra el mensaje `"error al leer"`.

---

## ⚙️ Explicación del `pom.xml`

### Configuración básica
```xml
<groupId>org.example</groupId>
<artifactId>filtrarLineas</artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>jar</packaging>
```
📌 Define el proyecto Maven y especifica que se construirá como un **JAR**.

---

### Dependencias
```xml
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>3.8.1</version>
  <scope>test</scope>
</dependency>
```
📌 Incluye **JUnit** para escribir pruebas automáticas.

---

### Configuración del `build`
```xml
<build>
    <finalName>filtrarlineas</finalName>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.4.1</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>filtrarlineas.FiltrarLineas</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

- **`<finalName>`** → El JAR generado se llamará `filtrarlineas.jar`.  
- **`<mainClass>`** → Indica a Maven cuál es la clase principal (`FiltrarLineas`).  
- **`maven-jar-plugin`** → Permite ejecutar el programa directamente con `java -jar`.

---

## 🚀 Ejecución del programa

### 1. Compilar y empaquetar
```bash
mvn clean package
```

Esto genera el archivo:
```
target/filtrarlineas.jar
```

### 2. Ejecutar el programa
```bash
java -jar target/filtrarlineas.jar
```

---

## 🧪 Ejemplo de uso

Entrada:
```
Hola mundo
Esta línea tiene más de veinte caracteres
Corta
Otra línea muy larga que se mostrará
```

Salida:
```
Esta línea tiene más de veinte caracteres
Otra línea muy larga que se mostrará
```

---

## 📂 Estructura del proyecto

```
filtrarLineas/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── filtrarlineas/
│   │           └── FiltrarLineas.java
│   └── test/
│       └── java/
│           └── filtrarlineas/
│               └── FiltrarLineasTest.java
```

---

##LECTOR DE TEXTO
# Lector de Texto

Aplicación Java simple para leer archivos de texto desde los recursos del proyecto.

## 📋 Descripción

Este proyecto lee y muestra en consola el contenido de un archivo de texto ubicado en la carpeta `resources` del proyecto. Es útil para aprender a manejar archivos empaquetados dentro de un JAR en aplicaciones Java.

## 🛠️ Tecnologías

- **Java**: Lenguaje de programación
- **Maven**: Gestor de dependencias y construcción del proyecto
- **JUnit 3.8.1**: Framework de pruebas (incluido por defecto)

## 📁 Estructura del Proyecto

```
lectorTExto/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── lectortexto/
│   │   │       └── lectorTexto.java
│   │   └── resources/
│   │       └── archivo.txt
│   └── test/
├── pom.xml
└── README.md
```

## ⚙️ Configuración del POM (pom.xml)

### Información del Proyecto
```xml
<groupId>org.example</groupId>
<artifactId>lectorTExto</artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>jar</packaging>
```
- **groupId**: Identificador del grupo/organización
- **artifactId**: Nombre del proyecto
- **version**: Versión actual (SNAPSHOT indica desarrollo)
- **packaging**: Tipo de empaquetado (JAR)

### Propiedades
```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
```
Define la codificación de caracteres como UTF-8 para evitar problemas con caracteres especiales.

### Plugin Maven Jar
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>3.4.1</version>
    <configuration>
        <archive>
            <manifest>
                <mainClass>lectortexto.lectorTexto</mainClass>
            </manifest>
        </archive>
    </configuration>
</plugin>
```
Configura el plugin para generar el JAR e indica cuál es la clase principal ejecutable.

### Dependencias
```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>3.8.1</version>
    <scope>test</scope>
</dependency>
```
Incluye JUnit para pruebas unitarias (solo en fase de testing).

## 💻 Cómo Funciona el Código

### Clase `lectorTexto`

```java
public class lectorTexto {
    public static void main(String[] args) {
```
Punto de entrada de la aplicación.

### Lectura del Archivo desde Resources

```java
InputStream is = lectorTexto.class.getClassLoader()
    .getResourceAsStream("archivo.txt");
```
- **getClassLoader()**: Obtiene el cargador de clases
- **getResourceAsStream()**: Busca el archivo en la carpeta `resources`
- Esta técnica funciona tanto en desarrollo como cuando el proyecto está empaquetado en un JAR

### Validación
```java
if (is == null) {
    throw new FileNotFoundException("No se encontró archivo.txt en resources");
}
```
Verifica que el archivo exista antes de intentar leerlo.

### Lectura Línea por Línea
```java
BufferedReader br = new BufferedReader(new InputStreamReader(is));
String linea;
while ((linea = br.readLine()) != null) {
    System.out.println(linea);
}
br.close();
```
- **BufferedReader**: Lee el texto de forma eficiente
- **InputStreamReader**: Convierte bytes a caracteres
- Lee cada línea y la imprime en consola
- Cierra el BufferedReader al finalizar

### Manejo de Excepciones
```java
catch (IOException e) {
    throw new RuntimeException(e);
}
```
Captura errores de entrada/salida y los convierte en excepciones de tiempo de ejecución.

## 🚀 Cómo Usar

### 1. Crear el archivo de texto
Crea un archivo llamado `archivo.txt` en `src/main/resources/` con el contenido que desees leer.

### 2. Compilar el proyecto
```bash
mvn clean compile
```

### 3. Ejecutar la aplicación
```bash
mvn exec:java -Dexec.mainClass="lectortexto.lectorTexto"
```

### 4. Generar JAR ejecutable
```bash
mvn clean package
```

### 5. Ejecutar el JAR
```bash
java -jar target/lectorTExto-1.0-SNAPSHOT.jar
```



#USO DE TUBERIAS

para usar las tuberias y conectar los archivos debemos de hacer los siguientes pasos:

###1.
-Poner todos los .jar en el mismo target, en este caso he puesto todos los .jar dentro del target de lector de texto 




