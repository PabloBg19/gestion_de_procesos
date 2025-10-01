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


## 🔨 Tecnologías usadas

- **Java** → Código principal.  
- **Maven** → Gestión de dependencias y construcción del JAR.  
- **JUnit** → Framework de testing.  

---


