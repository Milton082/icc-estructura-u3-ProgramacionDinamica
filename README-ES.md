# Programación Dinámica

## Comenzando

Este proyecto es un ejercicio práctico sobre cómo implementar la secuencia de Fibonacci utilizando diferentes métodos en Java. Demuestra el enfoque recursivo básico y dos técnicas de almacenamiento en caché (usando un `Map` y un arreglo) para optimizar el cálculo.

Este repositorio se refiere a la tercera unidad de Programación Dinámica, centrada en la optimización de algoritmos recursivos.

## Requisitos
- Java JDK 11 o superior
- Git 2.20 o superior

## Definición de Programación Dinámica

La Programación Dinámica (PD) es un método para resolver problemas complejos descomponiéndolos en subproblemas más simples. Es particularmente útil cuando el problema tiene subproblemas superpuestos y una estructura óptima, lo que permite reutilizar resultados previamente calculados para mejorar la eficiencia.

## Implementación

### Método Recursivo Normal

El método recursivo básico para calcular la secuencia de Fibonacci sin ningún tipo de almacenamiento en caché.

```java
public static int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

### Primera Forma de Caché: Usando un Map

Este método utiliza un `Map` para almacenar los valores previamente calculados, reduciendo los cálculos redundantes.

```java
private static Map<Integer, Integer> cache = new HashMap<>();

public static int fibonacciWithCaching(int n) {
    if (n <= 1) {
        return n;
    }

    if (cache.containsKey(n)) {
        return cache.get(n);
    }

    int result = fibonacciWithCaching(n - 1) + fibonacciWithCaching(n - 2);
    cache.put(n, result);
    return result;
}
```

### Segunda Forma de Caché: Usando un Arreglo

Este método utiliza un arreglo para almacenar los valores previamente calculados, lo que generalmente es más eficiente en términos de tiempo de acceso y uso de memoria.

```java
// Método para calcular el n-ésimo número de la secuencia de Fibonacci
public static int fibonacciCaching(int n) {
    int[] cache = new int[n + 1]; // Utilizamos un arreglo para almacenar los resultados previamente calculados
    return fibonacciMemoria(n, cache);
}

// Método auxiliar para calcular el n-ésimo número de Fibonacci utilizando memorización
private static int fibonacciMemoria(int n, int[] cache) {
    if (n <= 1) {
        return n;
    }

    // Si el valor ya fue calculado previamente, lo retornamos desde el caché
    if (cache[n] != 0) {
        return cache[n];
    }
    // Si el valor no ha sido calculado, lo calculamos recursivamente y lo almacenamos en el caché
    cache[n] = fibonacciMemoria(n - 1, cache) + fibonacciMemoria(n - 2, cache);
    return cache[n];
}
```

### Comparación de Rendimiento

```java
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Programación Dinámica");

        long startTime = System.nanoTime();
        System.out.println(fibonacci(40));
        long endTime = System.nanoTime();
        System.out.println("Tiempo tomado: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        System.out.println(fibonacciWithCaching(40));
        endTime = System.nanoTime();
        System.out.println("Tiempo tomado: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        System.out.println(fibonacciCaching(40));
        endTime = System.nanoTime();
        System.out.println("Tiempo tomado: " + (endTime - startTime) + "ns");
    }
}
```

## Contribuir

Para contribuir a este proyecto, por favor crea un fork y envía un pull request, o simplemente abre un issue con tus comentarios y sugerencias.

## Autores

- [Pablo Torres] - Desarrollo inicial

## V3.1.1

- Programación Dinamica y Ejercicios.